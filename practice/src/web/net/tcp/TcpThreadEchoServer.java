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
 * Date: 2022-04-24
 * Time: 12:52
 */
public class TcpThreadEchoServer {
    private ServerSocket listenSocket = null;

    public TcpThreadEchoServer(int port) throws IOException {
        this.listenSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器上线!");
        while (true) {
            Socket clientSocket = listenSocket.accept();

            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        precessClient(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }

    }

    private void precessClient(Socket clientSocket) throws IOException {
        String log = String.format("[%s:%d] 客户端上线!", clientSocket.getInetAddress(), clientSocket.getPort());
        System.out.println(log);


        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {
            while (true) {
                Scanner scanner = new Scanner(inputStream);
                if (!scanner.hasNext()) {
                    log = String.format("[%s:%d] 客户端下线!", clientSocket.getInetAddress(), clientSocket.getPort());
                    System.out.println(log);
                    break;
                }
                String request = scanner.nextLine();
                String response = precess(request);
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(response);
                printWriter.flush();
                log = String.format("[%s:%d] request:%s response:%s", clientSocket.getInetAddress(),
                        clientSocket.getPort(), request, response);
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
        TcpThreadEchoServer tcpThreadEchoServer = new TcpThreadEchoServer(9090);
        tcpThreadEchoServer.start();
    }
}
