package web.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-04-18
 * Time: 21:12
 */
public class UdpDictServer {
    private DatagramSocket socket = null;
    private HashMap<String,String> translate = new HashMap<>();
    public UdpDictServer(int port) throws SocketException {
        this.socket = new DatagramSocket(port);
        translateAdd();
    }

    private void translateAdd() {
        translate.put("hello","你好");
        translate.put("cat","小猫");
        translate.put("dog","小狗");
    }

    public void start() throws IOException {
        System.out.println("服务器启动!");
        while (true) {
            //接收请求
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket);
            //解析并计算请求
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());
            String response = process(request);
            //构造udp数据并发送回客户端
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),0,response.getBytes().length,
                                                                        requestPacket.getSocketAddress());
            socket.send(responsePacket);
            //打印日志
            String log = String.format("[%s:%d] req: %s resp: %s",requestPacket.getAddress(),requestPacket.getPort(),
                                                                    request,response);
            System.out.println(log);
        }
    }

    private String process(String request) {
        return translate.getOrDefault(request,"词典中暂无该单词");
    }

    public static void main(String[] args) throws IOException {
        UdpDictServer server = new UdpDictServer(9091);
        server.start();
    }
}
