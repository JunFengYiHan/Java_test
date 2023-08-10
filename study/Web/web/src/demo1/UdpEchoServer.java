package demo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/10
 * Time: 22:41
 */

public class UDPEchoServer {
    private DatagramSocket socket = null;

    //端口号port,取值0-65535
    public UDPEchoServer(int port) throws SocketException {
        this.socket = new DatagramSocket(port);
    }

    //启动服务器
    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            //读取请求
            //将请求读入到DatagramPacket,由创建者指定缓冲区大小
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            this.socket.receive(requestPacket);
            //提取并计算请求
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());
            //构造响应
            String response = process(request);
            //注意区分字符数量和字节数量
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.getBytes().length,
                    requestPacket.getSocketAddress());
            //回发响应
            socket.send(responsePacket);
            //打印日志
            String log = String.format("[%s:%d] req: %s; resp: %s",
                    requestPacket.getAddress().toString(),
                    requestPacket.getPort(), request, response);
            System.out.println(log);
        }
    }

    //直接回显
    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UDPEchoServer server = new UDPEchoServer(9090);
        server.start();
    }
}
