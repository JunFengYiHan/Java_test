package demo2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/30
 * Time: 18:09
 */

public class ThreadDemo4 {
    public static void main(String[] args) {
        Object object = new Object();
        System.out.println("wait开始");
        synchronized(object) {
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("wait结束");
    }
}
