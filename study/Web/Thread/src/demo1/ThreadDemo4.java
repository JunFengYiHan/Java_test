package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/15
 * Time: 14:14
 */

public class ThreadDemo4 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                System.out.println("Thread");
            }
        };
        t.start();
    }
}
