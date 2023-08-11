package demo2;

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
 * Date: 2023/8/11
 * Time: 21:07
 */

public class UDPDictClient {
    private DatagramSocket socket = null;
    private String serverIP = null;
    private int serverPort = -1;

    public UDPDictClient(String serverIP, int serverPort) throws SocketException {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
        //随机分配空闲的端口号
        this.socket = new DatagramSocket();
    }

    public void start() throws IOException {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("->: ");
            String input = scan.next();
            if ("exit".equals(input)) {
                System.out.println("程序退出");
                return;
            }
            //构造请求并发送
            DatagramPacket requestPacket = new DatagramPacket(input.getBytes(),
                    input.getBytes().length, InetAddress.getByName(serverIP), serverPort);
            socket.send(requestPacket);
            //读取响应并解析
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            String log = String.format("req:%s : resp:%s", input, response);
            System.out.println(log);
        }
    }

    public static void main(String[] args) throws IOException {
        UDPDictClient client = new UDPDictClient("127.0.0.1", 9090);
        client.start();
    }
}