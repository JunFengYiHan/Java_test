package test.demo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/13
 * Time: 23:03
 */

public class UdpDirtClient {
    private DatagramSocket socket = null;
    private String serverIp = null;
    private int serverPort = -1;

    public UdpDirtClient(String serverIp, int serverPort) throws SocketException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
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

            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),
                    request.getBytes().length, InetAddress.getByName(serverIp), serverPort);
            socket.send(requestPacket);

            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(responsePacket);

            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());

            String log = String.format("req:%s : resp:%s", request, response);
            System.out.println(log);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpDirtClient client = new UdpDirtClient("127.0.0.1", 9090);
        client.start();
    }
}
