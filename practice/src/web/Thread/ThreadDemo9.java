package web.Thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-04-15
 * Time: 23:23
 */
public class ThreadDemo9 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(8);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("起跑");
                try {
                    Thread.sleep((long) (Math.random()*10000));
                    System.out.println("撞线");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        for (int i = 0; i < 8; i++) {
            new Thread(runnable).start();
        }
        countDownLatch.await();
        System.out.println("比赛结束");
    }
}
