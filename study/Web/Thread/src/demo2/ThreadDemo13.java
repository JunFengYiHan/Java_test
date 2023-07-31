package demo2;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/31
 * Time: 22:14
 */

public class ThreadDemo13 {
    public static void main(String[] args) {
        // 内置的线程池

        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 20; i++) {
            int n = i;
            service.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(n);
                }
            });
        }

    }
}
