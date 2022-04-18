package web.net.udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-04-18
 * Time: 21:12
 */
public class UdpDictClient {
    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;

    public UdpDictClient(String serverIp, int serverPort) throws SocketException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        socket = new DatagramSocket();
    }

    public void start() throws IOException {
        System.out.println("客户端启动!");
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("-> ");
            String request = scanner.nextLine();
            if(request.equals("exit")){
                System.out.println("程序退出");
                return;
                //break;
            }
            //构造udp数据并发送给服务器
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),0,request.getBytes().length,
                                                                InetAddress.getByName(serverIp),serverPort);
            socket.send(requestPacket);
            //接收响应并解析
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(responsePacket);

            String response = new String(responsePacket.getData(),0,responsePacket.getLength());
            String log = String.format("req:%s resp:%s",request,response);
            //打印响应结果
            System.out.println(log);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpDictClient client = new UdpDictClient("127.0.0.1",9091);
        client.start();
    }
}
