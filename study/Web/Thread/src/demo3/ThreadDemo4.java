package demo3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/2
 * Time: 21:52
 */

public class ThreadDemo4 {

    static class Counter {
        public int count = 0;
                                                   //传入true成为公平锁
        public ReentrantLock locker = new ReentrantLock();
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    //counter.locker.tryLock();
                    counter.locker.lock();
                    counter.count++;
                    counter.locker.unlock();

                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    counter.locker.lock();
                    counter.count++;
                    counter.locker.unlock();
                }
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.count);
    }
}
