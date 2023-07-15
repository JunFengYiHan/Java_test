package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/10
 * Time: 15:52
 */

class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println("hello!");
    }
}

public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread t = new MyThread1();
        t.start();//会实际创建一个线程,独立于main线程执行
        //t.run();//不会实际创建一个线程,挂在main线程下执行
    }
}
