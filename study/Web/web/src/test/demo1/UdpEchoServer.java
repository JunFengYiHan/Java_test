package test.demo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/13
 * Time: 22:29
 */

public class UdpEchoServer {
    //编写 udp 版本的 echo server 和 echo client
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        this.socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            DatagramPacket reqPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(reqPacket);

            String request = new String(reqPacket.getData(), 0, reqPacket.getLength());

            String response = process(request);

            DatagramPacket respPacket = new DatagramPacket(response.getBytes(),
                    response.getBytes().length, reqPacket.getSocketAddress());
            socket.send(respPacket);

            String log = String.format("[%s:%d] req:%s ; resp:%s", reqPacket.getAddress().toString(),
                    reqPacket.getPort(), request, response);
            System.out.println(log);
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
