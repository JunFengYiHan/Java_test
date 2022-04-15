package web;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-04-15
 * Time: 22:13
 */
public class ThreadDemo7 {
    static int count = 0;//可以通过传入参数形成公平锁和非公平锁,公平锁:true 非公平锁:false
    static ReentrantLock locker = new ReentrantLock();
    static void increment() {
        locker.lock();
        count++;
        locker.unlock();
    }
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    increment();
                }
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    increment();
                }
            }
        };
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
