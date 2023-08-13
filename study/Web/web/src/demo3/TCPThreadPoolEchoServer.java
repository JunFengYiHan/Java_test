package demo3;

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
 * Date: 2023/8/12
 * Time: 23:26
 */

public class TCPThreadPoolEchoServer {
    private ServerSocket listenSocket = null;

    public TCPThreadPoolEchoServer(int port) throws IOException {
        listenSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        //通过Executors创建一个线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            Socket clientSocket = listenSocket.accept();
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    processConnection(clientSocket);
                }
            });
        }
    }

    private void processConnection(Socket clientSocket) {
        String log = String.format("[%s:%d] 客户端上线",
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
                log = String.format("req:%s ; resp:%s", request, response);
                System.out.println(log);
            }
            log = String.format("[%s:%d] 客户端下线",
                    clientSocket.getInetAddress(), clientSocket.getPort());
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

    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TCPThreadPoolEchoServer server = new TCPThreadPoolEchoServer(9090);
        server.start();
    }
}
