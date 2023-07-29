package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/29
 * Time: 18:12
 */

public class ThreadDemo12 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.interrupted());
                    //System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        };
        t.start();
        t.interrupt();
    }
}
