package test.demo5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/18
 * Time: 20:59
 */

public class TcpCalcClient {
    private Socket socket = null;
    private String serverIp = null;
    private int serverPort = -1;

    public TcpCalcClient(String serverIp, int serverPort) throws IOException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        this.socket = new Socket(serverIp, serverPort);
    }

    public void start() {
        Scanner input = new Scanner(System.in);
        System.out.print("输入计算表达式->:");
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            Scanner scanner = new Scanner(inputStream);
            PrintWriter writer = new PrintWriter(outputStream);
            while (input.hasNext()) {
                String request = input.next();
                //先计算后缀表达式然后交给服务器求值
                String temp = transition(request);
                writer.println(temp);
                writer.flush();
                String response = scanner.next();
                String log = String.format("%s = %s", request, response);
                System.out.println(log);
                System.out.print("输入计算表达式->:");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String transition(String request) {
        char[] str = request.toCharArray();
        Stack<Character> stack = new Stack<>();//操作符栈
        StringBuilder sb = new StringBuilder();//最终后缀表达式
        for (int i = 0; i < str.length; i++) {
            char ch = str[i];
            if (ch >= '0' && ch <= '9') {
                sb.append(ch);
            } else {
                //此处如果使用空格分割就需要服务器读取一行
                sb.append(' ');//区分每个数字
                //栈为空直接入栈
                if (stack.empty() || ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    //假设输入的表达式合法,将左右括号直接的操作符全部出栈
                    while (!stack.empty() && stack.peek() != '(') {
                        sb.append(stack.pop());
//                        sb.append(' ');
                    }
                    stack.pop();//去掉栈顶左括号
                } else {
                    //ch为+或-直接出栈
                    if (ch == '+' || ch == '-') {
                        while (!stack.empty() && stack.peek() != '(') {
                            sb.append(stack.pop());
                        }
                        stack.push(ch);
                    } else {
                        //栈顶为+ -直接入栈,* /出栈
//                        if (stack.peek() != '+' && stack.peek() != '-' && stack.peek() != '(') {
                        while (!stack.empty() && (stack.peek() == '*' || stack.peek() == '/')) {
                            sb.append(stack.pop());
                        }
//                        }
                        stack.push(ch);
                    }
                }
            }
        }
        sb.append(' ');
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        TcpCalcClient calcClient = new TcpCalcClient("127.0.0.1", 9090);
        calcClient.start();
    }
}
