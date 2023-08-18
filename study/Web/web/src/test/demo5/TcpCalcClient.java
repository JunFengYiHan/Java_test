package test.demo5;

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
 * Date: 2023/8/18
 * Time: 20:59
 */

public class TcpCalcClient {
    private Socket socket = null;
    private String serverIp = null;
    private int serverPort = -1;

    public TcpCalcClient(String serverIp, int serverPort) throws IOException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        this.socket = new Socket(serverIp, serverPort);
    }

    public void start() {
        Scanner input = new Scanner(System.in);
        System.out.print("输入计算表达式->:");
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            Scanner scanner = new Scanner(inputStream);
            PrintWriter writer = new PrintWriter(outputStream);
            while (input.hasNext()) {
                String request = input.next();
                writer.println(request);
                writer.flush();
                String response = scanner.next();
                String log = String.format("%s = %s", request, response);
                System.out.println(log);
                System.out.print("输入计算表达式->:");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpCalcClient calcClient = new TcpCalcClient("127.0.0.1", 9090);
        calcClient.start();
    }
}
