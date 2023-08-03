package test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/3
 * Time: 16:01
 */

public class Test4 {
    private static Object locker = new Object();
    private static int count = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (locker) {
                    while (true) {
                        while (count % 3 != 2) {
                            try {
                                locker.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(Thread.currentThread().getName());
                        count++;
                        locker.notifyAll();
                    }
                }
            }
        }, "a");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (locker) {
                    while (true) {
                        while (count % 3 != 1) {
                            try {
                                locker.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(Thread.currentThread().getName());
                        count++;
                        locker.notifyAll();
                    }
                }
            }
        }, "b");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (locker) {
                    while (true) {
                        while (count % 3 != 0) {
                            try {
                                locker.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(Thread.currentThread().getName());
                        count++;
                        locker.notifyAll();
                    }
                }
            }
        },"c");

        t1.start();
        t2.start();
        t3.start();
        //如果只是打印一次还可以使用join
        //打印多次可以使用三个锁对象,分别使用wait和notify
    }
}
