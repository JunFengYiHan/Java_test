package demo3;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/12
 * Time: 23:49
 */
//通过继承简化代码
public class TCPDirtServer extends TCPThreadPoolEchoServer {

    private HashMap<String, String> dict = new HashMap<>();

    public TCPDirtServer(int port) throws IOException {
        super(port);

        dict.put("hello", "你好");
        dict.put("cat", "小猫");
        dict.put("dog", "小狗");

    }

    @Override
    public String process(String request) {
        return dict.getOrDefault(request, "单词不存在");
    }

    public static void main(String[] args) throws IOException {
        TCPDirtServer server = new TCPDirtServer(9090);
        server.start();
    }
}
