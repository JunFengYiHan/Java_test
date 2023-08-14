package test.demo4;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/14
 * Time: 23:51
 */

public class TcpThreadPoolDirtServer extends TcpThreadDirtServer {

    public TcpThreadPoolDirtServer(int port) throws IOException {
        super(port);
    }

    @Override
    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            Socket client = listenSocket.accept();
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    processConnection(client);
                }
            });
        }
    }
}
