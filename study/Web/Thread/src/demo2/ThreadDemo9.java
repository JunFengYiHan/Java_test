package demo2;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/30
 * Time: 20:52
 */

public class ThreadDemo9 {


    public static void main(String[] args) {
        //交易场所
        BlockingDeque<Integer> queue = new LinkedBlockingDeque<>();
        //消费者
        Thread customer = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Integer value = queue.take();
                        System.out.println("消费了元素: " + value);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        customer.start();

        //生产者
        Thread produce = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("生产了元素: " + i);
                    try {
                        queue.put(i);
                        Thread.sleep(1000);//等待1s效果更加直观
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        produce.start();
    }
}
