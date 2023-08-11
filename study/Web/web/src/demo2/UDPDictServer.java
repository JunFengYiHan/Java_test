package demo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/11
 * Time: 21:07
 */

public class UDPDictServer {
    private DatagramSocket socket = null;
    private HashMap<String, String> dict = new HashMap<>();
    //服务器的端口号需要固定,方便客户端的定位
    public UDPDictServer(int port) throws SocketException {
        socket = new DatagramSocket(port);

        dict.put("hello", "你好");
        dict.put("cat", "小猫");
        dict.put("dog", "小狗");

    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            //接收请求
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket);
            //解析请求
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());
            //计算响应
            String response = process(request);
            //构造响应
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),
                    response.getBytes().length, requestPacket.getSocketAddress());
            //回发响应
            socket.send(responsePacket);
            //打印日志
            String log = String.format("[%s:%d] req:%s; resp:%s", requestPacket.getAddress().toString(),
                    requestPacket.getPort(), request, response);
            System.out.println(log);
        }
    }

    private String process(String request) {
        //业务逻辑
        return dict.getOrDefault(request, "单词不存在");
    }

    public static void main(String[] args) throws IOException {
        UDPDictServer server = new UDPDictServer(9090);
        server.start();
    }
}
