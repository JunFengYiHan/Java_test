package demo2;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/30
 * Time: 19:58
 */

public class ThreadDemo8 {
    private static Object blocker = new Object();
    private static int count = 10;
    private static int flag = 0;

    public static void main(String[] args) throws InterruptedException {
        //三个线程按照ABC顺序打印多次
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < count; i++) {
                    //每次唤醒都进行循环判断,不符合则继续阻塞等待
                    synchronized (blocker) {
                        while (flag % 3 != 0) {
                            try {
                                blocker.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        //输出
                        System.out.print("A");
                        //标记位后移
                        flag++;
                        //唤醒其他线程
                        //需要注意notifyAll的位置,确保操作的原子性,以及和锁的搭配
                        blocker.notifyAll();
                    }

                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < count; i++) {
                    synchronized (blocker) {
                        while (flag % 3 != 1) {

                            try {
                                blocker.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print("B");
                        flag++;
                        blocker.notifyAll();
                    }
                }
            }
        };

        Thread t3 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < count; i++) {
                    synchronized (blocker) {
                        while (flag % 3 != 2) {

                            try {
                                blocker.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("C");
                        flag++;
                        blocker.notifyAll();
                    }

                }
            }
        };

        t1.start();
        t2.start();
        t3.start();

    }

}
