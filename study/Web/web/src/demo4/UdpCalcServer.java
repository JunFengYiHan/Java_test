package demo4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/16
 * Time: 22:24
 */

public class UdpCalcServer {
    private DatagramSocket socket = null;

    public UdpCalcServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            //1.读取并解析请求
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket);
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());
            //2.计算响应
            String response = process(request);
            //3.回发响应
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),
                    response.getBytes().length, requestPacket.getSocketAddress());
            socket.send(responsePacket);
            //4.打印日志
            String log = String.format("[%s:%d] req:%s : resp:%s",
                    requestPacket.getAddress(), requestPacket.getPort(), request, response);
            System.out.println(log);
        }
    }

    private String process(String request) {
        // 1.还原操作数和操作符
        String[] token = request.split(";");
        if (token.length != 3) {
            return "[请求格式出错!]";
        }
        int num1 = Integer.parseInt(token[0]);
        int num2 = Integer.parseInt(token[1]);
        String operator = token[2];
        // 2.进行计算
        int result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                return "[请求格式出错]";
        }
        return result + "";
    }

    public static void main(String[] args) throws IOException {
        UdpCalcServer server = new UdpCalcServer(9090);
        server.start();
    }
}
