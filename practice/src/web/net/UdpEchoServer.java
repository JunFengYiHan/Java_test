package web.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-04-17
 * Time: 22:31
 */
public class UdpEchoServer {
    private DatagramSocket socket = null;
    //port表示端口号,表示范围为2字节无符号整数 0-65535
    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);//指定端口
    }
    public void start() throws IOException {
        System.out.println("服务器启动!");
        //客服端随时待命
        while(true) {
            //创建packet对象并指定缓冲区大小
            DatagramPacket packet = new DatagramPacket(new byte[2048],2048);
            socket.receive(packet);
            //解析packet
            String request = new String(packet.getData(),0,packet.getLength());
            String response = process(request);
            //打包并返回请求
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),request.getBytes().length,
                                                                packet.getSocketAddress());
            //打印日志
            socket.send(responsePacket);
            String log = String.format("[%s,%d] 请求:%s 响应:%s",
                                        packet.getAddress().toString(),
                                        packet.getPort(),
                                        request,response);
            System.out.println(log);
        }
    }

    private String process(String request) {
        return request;//分析请求,并回应
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
