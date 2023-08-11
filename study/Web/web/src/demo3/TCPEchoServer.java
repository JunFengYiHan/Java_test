package demo3;

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
 * Date: 2023/8/11
 * Time: 22:22
 */

public class TCPEchoServer {
    private ServerSocket listenSocket = null;

    public TCPEchoServer(int port) throws IOException {
        listenSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            //先判断是否建立连接,而UDP会直接阻塞到receive
            Socket clientSocket = listenSocket.accept();
            processConnection(clientSocket);
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
            while (true) {
                if (!scanner.hasNext()) {
                    log = String.format("[%s:%d] 客户端下线",
                            clientSocket.getInetAddress().toString(), clientSocket.getPort());
                    System.out.println(log);
                    break;
                }
                //读取请求
                String request = scanner.next();
                //计算响应
                String response = process(request);
                //回发响应
                writer.println(response);

                //刷新缓冲区,强制发送
                writer.flush();

                //打印日志
                log = String.format("[%s:%d] req:%s ; resp:%s", clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(), request, response);
                System.out.println(log);
            }
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

    //计算请求
    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TCPEchoServer server = new TCPEchoServer(9090);
        server.start();
    }
}
