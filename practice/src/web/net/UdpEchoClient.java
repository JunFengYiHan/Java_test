package web.net;


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
 * Date: 2022-04-17
 * Time: 22:30
 */
public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;

    public UdpEchoClient(String serverIp, int serverPort) throws SocketException {
        this.serverPort = serverPort;
        this.serverIp = serverIp;
        this.socket = new DatagramSocket();//不指定自己端口和ip系统由随机分配
    }

    public void start() throws IOException {
        while (true) {
            System.out.print("-> ");
            Scanner scanner = new Scanner(System.in);
            String request = scanner.nextLine();
            if ("exit".equalsIgnoreCase(request)) {
                return;
            }
            //打包并发送请求
            DatagramPacket packet = new DatagramPacket(request.getBytes(), 0, request.getBytes().length,
                    InetAddress.getByName(serverIp), serverPort);
            socket.send(packet);
            //接收并解析回应
            DatagramPacket responsePacket = new DatagramPacket(new byte[2048],2048);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(),0,responsePacket.getLength());
            //显示
            String log = String.format("请求:%s 响应:%s",request,response);
            System.out.println(log);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1",9090);
        client.start();
    }
}
