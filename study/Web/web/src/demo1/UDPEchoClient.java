package demo1;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/10
 * Time: 22:42
 */

public class UDPEchoClient {

    private DatagramSocket socket = null;
    private String serverIp = null;
    private int serverPort = -1;

    //需要指定服务器的Ip和port,以此为基础寻找服务器
    public UDPEchoClient(String serverIp, int serverPort) throws SocketException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        //不需要为客户端指定端口,随机分配空闲端口即可
        this.socket = new DatagramSocket();
    }

    //启动客服端
    public void start() throws IOException {
        while (true) {
            //输入请求内容
            System.out.print("->: ");
            Scanner scan = new Scanner(System.in);
            String request = scan.next();
            if ("exit".equals(request)) {
                System.out.println("exit");
                return;
            }
            //构造请求
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length,
                    InetAddress.getByName(serverIp), serverPort);
            //发送请求
            socket.send(requestPacket);
            //读取响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            //解析响应并显示
            String log = String.format("rep:%s; resp:%s", request, response);
            System.out.println(log);
        }

    }

    public static void main(String[] args) throws IOException {
        UDPEchoClient client = new UDPEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
