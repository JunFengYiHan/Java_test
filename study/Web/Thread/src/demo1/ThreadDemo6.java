package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/15
 * Time: 20:00
 */

public class ThreadDemo6 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            while(true) {
                System.out.println("lambda");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}
