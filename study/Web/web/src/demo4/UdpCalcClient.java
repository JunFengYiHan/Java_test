package demo4;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/16
 * Time: 22:23
 */

public class UdpCalcClient {
    private DatagramSocket socket = null;
    private String serverIp = null;
    private int serverPort = -1;

    public UdpCalcClient(String serverIp, int serverPort) throws SocketException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        this.socket = new DatagramSocket();
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        String operator = null;
        while (true) {
            //1.用户输入
            System.out.print("num1:");
            num1 = scanner.nextInt();
            System.out.print("num2:");
            num2 = scanner.nextInt();
            System.out.print("operator:");
            operator = scanner.next();
            //构造请求
            String request = num1 + ";" + num2 + ";" + operator;
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),
                    request.getBytes().length, InetAddress.getByName(serverIp), serverPort);
            //发送请求
            socket.send(requestPacket);
            //接收响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(responsePacket);
            //解析响应,并打印
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("计算结果为:" + response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpCalcClient calcClient = new UdpCalcClient("127.0.0.1", 9090);
        calcClient.start();
    }
}
