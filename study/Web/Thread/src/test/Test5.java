package test;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/3
 * Time: 18:18
 */

public class Test5 {
    public static void main(String[] args) {
        Object locker1 = new Object();
        Object locker2 = new Object();
        Object locker3 = new Object();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("线程1尝试加锁locker1");
                synchronized (locker1) {
                    System.out.println("线程1加锁locker1成功");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程1尝试加锁locker2");
                    synchronized (locker2) {
                        System.out.println("线程1加锁locker2成功");
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println("线程2尝试加锁locker2");
                synchronized (locker2) {
                    System.out.println("线程2加锁locker2成功");
                    try {
                        //休眠1s
                        //Thread.sleep(1000);
                        TimeUnit.SECONDS.sleep(1);//位于java.util.concurrent.TimeUnit
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程2尝试加锁locker3");
                    synchronized (locker3) {
                        System.out.println("线程2加锁locker3成功");
                    }
                }
            }
        };
        Thread t3 = new Thread(){
            @Override
            public void run() {
                System.out.println("线程3尝试加锁locker3");
                synchronized (locker3) {
                    System.out.println("线程3加锁locker3成功");
                    try {
                        //休眠1s
                        //Thread.sleep(1000);
                        TimeUnit.SECONDS.sleep(1);//位于java.util.concurrent.TimeUnit
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程3尝试加锁locker1");
                    synchronized (locker1) {
                        System.out.println("线程3加锁locker1成功");
                    }
                }
            }
        };
        t1.start();
        t2.start();
        t3.start();
    }
}
