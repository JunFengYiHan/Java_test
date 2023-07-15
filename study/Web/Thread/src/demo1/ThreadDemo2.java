package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/15
 * Time: 14:03
 */

class MyThread2 extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println("MyThread2");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadDemo2 {
    public static void main(String[] args) {
        Thread t = new MyThread2();

        t.start();//会实际创建一个线程,独立于main线程执行
        //t.run();//不会实际创建一个线程,挂在main线程下执行

        while (true) {
            System.out.println("mainThread");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
