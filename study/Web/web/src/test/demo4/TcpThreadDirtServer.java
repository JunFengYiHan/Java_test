package test.demo4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/14
 * Time: 23:40
 */

public class TcpThreadDirtServer {
    protected ServerSocket listenSocket = null;
    private HashMap<String, String> dirt = new HashMap<>();

    public TcpThreadDirtServer(int port) throws IOException {
        listenSocket = new ServerSocket(port);

        dirt.put("hello", "你好");
        dirt.put("cat", "小猫");
        dirt.put("dark", "黑暗");
        dirt.put("duck", "鸭子");
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            Socket client = listenSocket.accept();
            new Thread() {
                @Override
                public void run() {
                    processConnection(client);
                }
            }.start();
        }
    }

    protected void processConnection(Socket client) {
        String log = String.format("[%s:%d] 客户端已上线",
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
                        client.getInetAddress().toString(),
                        client.getPort(), request, response);
                System.out.println(log);
            }
            log = String.format("[%s:%d] 客户端已下线",
                    client.getInetAddress(), client.getPort());
            System.out.println(log);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String process(String request) {
        return dirt.getOrDefault(request, "词典中未收录该词");
    }

    public static void main(String[] args) throws IOException {
        TcpThreadDirtServer server = new TcpThreadDirtServer(9090);
        server.start();
    }
}
