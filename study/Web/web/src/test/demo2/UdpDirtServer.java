package test.demo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/13
 * Time: 23:03
 */

public class UdpDirtServer {
    private DatagramSocket socket = null;
    private HashMap<String, String> dirt = new HashMap<>();

    public UdpDirtServer(int port) throws SocketException {
        socket = new DatagramSocket(port);

        dirt.put("hello", "你好");
        dirt.put("dog", "小狗");
        dirt.put("cat", "小猫");
        dirt.put("duck", "小鸭子");
        dirt.put("dark", "黑暗");

    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket);
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());

            String response = process(request);

            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),
                    response.getBytes().length, requestPacket.getSocketAddress());
            socket.send(responsePacket);

            String log = String.format("[%s:%d] req:%s ; resp:%s", requestPacket.getAddress().toString(),
                    requestPacket.getPort(), request, response);
            System.out.println(log);
        }
    }

    private String process(String request) {
        return dirt.getOrDefault(request, "词典中暂无此单词");
    }

    public static void main(String[] args) throws IOException {
        UdpDirtServer server = new UdpDirtServer(9090);
        server.start();
    }
}
