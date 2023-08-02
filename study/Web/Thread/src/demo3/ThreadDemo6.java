package demo3;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/2
 * Time: 22:54
 */

public class ThreadDemo6 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(8);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("起跑");
                //Math.random随机生成一个[0,1)的浮点数
                try {
                    Thread.sleep((long) (Math.random() * 10000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();//表示当前线程已经结束
                System.out.println("撞线");
            }
        };
        for (int i = 0; i < 8; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
        latch.await();//等待所有线程结束
        System.out.println("比赛结束");
    }
}
