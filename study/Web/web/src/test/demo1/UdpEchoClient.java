package test.demo1;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/13
 * Time: 22:45
 */

public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serverIp = null;
    private int serverPort = -1;

    public UdpEchoClient(String ip, int port) throws SocketException {
        this.serverIp = ip;
        this.serverPort = port;
        this.socket = new DatagramSocket();
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("->: ");
            String request = scanner.next();
            if ("exit".equals(request)) {
                System.out.println("程序退出");
                break;
            }
            DatagramPacket reqPacket = new DatagramPacket(request.getBytes(),
                    request.getBytes().length, InetAddress.getByName(serverIp), serverPort);
            socket.send(reqPacket);

            DatagramPacket respPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(respPacket);

            String response = new String(respPacket.getData(), 0, respPacket.getLength());
            String log = String.format("req:%s  resp:%s", request, response);
            System.out.println(log);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
