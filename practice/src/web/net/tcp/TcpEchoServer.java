package web.net.tcp;

import java.io.*;
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
public class TcpEchoServer {
    private ServerSocket listenSocket = null;

    public TcpEchoServer(int port) throws IOException {
        this.listenSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动!");
        while (true) {
            Socket clientSocket = listenSocket.accept();
            precessClient(clientSocket);
        }
    }

    private void precessClient(Socket clientSocket) throws IOException {
        String log = String.format("[%s:%d] 客户端上线", clientSocket.getInetAddress(), clientSocket.getPort());
        System.out.println(log);

        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {

            while (true) {
                Scanner scanner = new Scanner(inputStream);
                if (!scanner.hasNext()) {
                    log = String.format("[%s:%d] 客户端下线", clientSocket.getInetAddress(), clientSocket.getPort());
                    System.out.println(log);
                    break;
                }
                String request = scanner.nextLine();
                String response = precess(request);

                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(response);
                printWriter.flush();//刷新缓冲区,强制发送
                log = String.format("[%s,%d] request:%s response:%s", clientSocket.getInetAddress(), clientSocket.getPort(),
                        request, response);
                System.out.println(log);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            clientSocket.close();
        }
    }

    private String precess(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();
    }
}
