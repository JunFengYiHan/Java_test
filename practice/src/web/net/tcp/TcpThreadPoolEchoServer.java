package web.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-04-24
 * Time: 13:15
 */
public class TcpThreadPoolEchoServer {
    private ServerSocket listenSocket = null;

    public TcpThreadPoolEchoServer(int port) throws IOException {
        listenSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器上线");
        while (true) {
            Socket socket = listenSocket.accept();
            ExecutorService exception = Executors.newCachedThreadPool();
            exception.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        precessClient(socket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }

    private void precessClient(Socket clientSocket) throws IOException {
        String log = String.format("[%s:%d] 客户端上线!", clientSocket.getInetAddress(), clientSocket.getPort());
        System.out.println(log);
        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {

            Scanner scanner = new Scanner(inputStream);
            String request = null;
            String response = null;
            while (true) {
                if (!scanner.hasNext()) {
                    log = String.format("[%s:%d] 客户端下线!", clientSocket.getInetAddress(), clientSocket.getPort());
                    System.out.println(log);
                    break;
                }
                request = scanner.nextLine();
                response = precess(request);

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
        TcpThreadPoolEchoServer tcpThreadPoolEchoServer = new TcpThreadPoolEchoServer(9090);
        tcpThreadPoolEchoServer.start();
    }
}
