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
 * Date: 2023/8/12
 * Time: 23:10
 */

public class TCPThreadEchoServer {
    private ServerSocket listenSocket = null;

    public TCPThreadEchoServer(int port) throws IOException {
        listenSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            Socket clientSocket = listenSocket.accept();
            //最好使用线程池组织
            new Thread() {
                @Override
                public void run() {
                    processConnection(clientSocket);
                }
            }.start();
        }
    }

    private void processConnection(Socket socket) {
        String log = String.format("[%s:%d] 客户端上线",
                socket.getInetAddress().toString(), socket.getPort());
        System.out.println(log);
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            Scanner scanner = new Scanner(inputStream);
            PrintWriter writer = new PrintWriter(outputStream);
            while (scanner.hasNext()) {
                //接收请求
                String request = scanner.next();
                //计算响应
                String response = process(request);
                //回发响应
                writer.println(response);
                //强制刷新缓冲区,确保发送
                writer.flush();
                //打印日志
                log = String.format("req:%s : resp:%s", request, response);
                System.out.println(log);
            }
            log = String.format("[%s:%d] 客户端下线",
                    socket.getInetAddress().toString(), socket.getPort());
            System.out.println(log);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TCPThreadEchoServer server = new TCPThreadEchoServer(9090);
        server.start();
    }
}
