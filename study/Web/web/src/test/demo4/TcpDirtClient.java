package test.demo4;

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
 * Date: 2023/8/14
 * Time: 23:10
 */

public class TcpDirtClient {
    private Socket socket = null;
    private String serverIp = null;
    private int serverPort = -1;

    public TcpDirtClient(String serverIp, int serverPort) throws IOException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        this.socket = new Socket(serverIp, serverPort);
    }

    public void start() {
        Scanner input = new Scanner(System.in);
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            Scanner scanner = new Scanner(inputStream);
            PrintWriter writer = new PrintWriter(outputStream);
            System.out.print("->: ");
            while (input.hasNext()) {
                String request = input.next();
                writer.println(request);
                writer.flush();
                String response = scanner.next();
                String log = String.format("req:%s ; resp:%s", request, response);
                System.out.println(log);
                System.out.print("->: ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpDirtClient client = new TcpDirtClient("127.0.0.1", 9090);
        client.start();
    }
}
