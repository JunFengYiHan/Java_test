package test.demo5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
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

public class TcpCalcServer {
    private ServerSocket listenSocket = null;

    public TcpCalcServer(int port) throws IOException {
        listenSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            Socket client = listenSocket.accept();
            processConnection(client);
        }
    }

    private void processConnection(Socket client) {
        String log = String.format("[%s:%d] 客户端上线",
                client.getInetAddress(), client.getPort());
        System.out.println(log);
        try (InputStream inputStream = client.getInputStream();
             OutputStream outputStream = client.getOutputStream()) {
            Scanner scanner = new Scanner(inputStream);
            PrintWriter writer = new PrintWriter(outputStream);
            while (scanner.hasNext()) {
                String request = scanner.next();
                String response = process(request);
                writer.println(response);
                writer.flush();
                log = String.format("[%s:%d] req:%s ; resp:%s",
                        client.getInetAddress(), client.getPort(), request, response);
                System.out.println(log);
            }
            log = String.format("[%s:%d] 客户端下线",
                    client.getInetAddress(), client.getPort());
            System.out.println(log);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String process(String request) {
        //使用逆波兰算法实现
        String temp = transition(request);
        return evaluation(temp);
    }

    private static String evaluation(String str) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (tmp >= '0' && tmp <= '9') {
                sum = sum * 10 + tmp - '0';
                flag = true;
                continue;
            }
            if (tmp == ' ') {
                if (flag) {
                    stack.push(sum);//当前值入栈
                    flag = false;
                }
                sum = 0;//置空
            } else {
                switch (tmp) {
                    case '+':
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case '*':
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case '-':
                        int n = stack.pop();
                        int m = stack.pop();
                        stack.push(m - n);
                        break;
                    case '/':
                        n = stack.pop();
                        m = stack.pop();
                        if (n == 0) {
                            return "ILLEGAL";
                        }
                        stack.push(m / n);
                        break;
                }
            }

        }
        return stack.pop() + "";
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
        TcpCalcServer server = new TcpCalcServer(9090);
        server.start();
    }
}
