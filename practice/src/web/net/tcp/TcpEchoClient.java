package web.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-04-18
 * Time: 22:27
 */
public class TcpEchoClient {
    private Socket clientSocket = null;
    private String ServerIp;
    private int serverPort;

    public TcpEchoClient(String serverIp, int serverPort) throws IOException {
        ServerIp = serverIp;
        this.serverPort = serverPort;
        clientSocket = new Socket(serverIp, serverPort);
    }

    public void start() throws IOException {
        System.out.println("客户端启动!");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try (InputStream inputStream = clientSocket.getInputStream();
                 OutputStream outputStream = clientSocket.getOutputStream()) {

                while (true) {
                    System.out.print("-> ");
                    String request = scanner.nextLine();
                    if ("exit".equals(request)) {
                        System.out.println("程序退出!");
                        return;
                    }

                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.println(request);
                    printWriter.flush();//刷新缓冲区,强制发送
                    Scanner respScanner = new Scanner(inputStream);
                    String response = respScanner.nextLine();
                    String log = String.format("[%s:%d] request:%s response:%s", clientSocket.getInetAddress(),
                            clientSocket.getPort(), request, response);
                    System.out.println(log);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                clientSocket.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient tcpEchoClient = new TcpEchoClient("127.0.0.1", 9090);
        tcpEchoClient.start();
    }
}
