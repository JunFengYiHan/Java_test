package demo2;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/30
 * Time: 16:25
 */

public class ThreadDemo2 {
    static class Counter {
        private static int count = 0;
        //锁
        synchronized public void increase() {
            count++;
        }
        //可重入
        synchronized public void increase2(){
            increase();
        }
//        public void increase() {
//            synchronized (this) {
//                count++;
//            }
//        }

    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    counter.increase();
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    counter.increase();
                }
            }
        };

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Counter.count);

    }
}
