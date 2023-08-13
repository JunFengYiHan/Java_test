package test.demo3;

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
 * Date: 2023/8/13
 * Time: 23:30
 */

public class TcpEchoServer {
    private ServerSocket listenSocket = null;

    public TcpEchoServer(int port) throws IOException {
        listenSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            Socket clientSocket = listenSocket.accept();
            processConnection(clientSocket);
        }
    }

    private void processConnection(Socket clientSocket) {
        String log = String.format("[%s:%d] 客户端已上线",
                clientSocket.getInetAddress().toString(), clientSocket.getPort());
        System.out.println(log);
        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {
            Scanner scanner = new Scanner(inputStream);
            PrintWriter writer = new PrintWriter(outputStream);
            while (scanner.hasNext()) {
                String request = scanner.next();
                String response = process(request);
                writer.println(response);
                writer.flush();
                log = String.format("[%s:%d] req:%s ; resp:%s",
                        clientSocket.getInetAddress(), clientSocket.getPort(), request, response);
                System.out.println(log);
            }
            log = String.format("[%s:%d] 客户端已下线",
                    clientSocket.getInetAddress().toString(), clientSocket.getPort());
            System.out.println(log);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();
    }
}
