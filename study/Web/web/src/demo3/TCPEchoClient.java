package demo3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/11
 * Time: 22:23
 */

public class TCPEchoClient {
    private Socket socket = null;
    private String serverIP;
    private int port;

    public TCPEchoClient(String serverIP, int serverPort) throws IOException {
        this.serverIP = serverIP;
        this.port = serverPort;
        //创建socket,同时尝试和服务器建立连接
        this.socket = new Socket(serverIP, serverPort);
    }

    public void start() {
        Scanner scan = new Scanner(System.in);
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            while (true) {
                //输入请求/构造请求
                System.out.print("->: ");
                String request = scan.next();
                if ("exit".equals(request)) {
                    System.out.println("程序退出");
                    break;
                }

                //发送请求
                PrintWriter writer = new PrintWriter(outputStream);
                writer.println(request);

                //刷新缓冲区,强制发送
                writer.flush();

                //接收响应,并解析
                Scanner respScan = new Scanner(inputStream);
                String response = respScan.next();
                //显示响应
                String log = String.format("req:%s : resp:%s", request, response);
                System.out.println(log);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TCPEchoClient client = new TCPEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
