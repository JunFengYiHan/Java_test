package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/15
 * Time: 14:09
 */

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable");
    }
}

public class ThreadDemo3 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}
