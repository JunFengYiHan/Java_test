package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/15
 * Time: 20:45
 */

public class ThreadDemo8 {
    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println("hello");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"MyThread");//给线程命名

        t.start();
    }
}
