package web;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-04-12
 * Time: 22:54
 */
public class TestThreadDemo3 {
    public static void main(String[] args) {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < threads.length; i++) {
            int n = i;//捕获的变量值不能被修改
            threads[i] = new Thread(){
                @Override
                public void run() {
                    System.out.println(n);
                }
            };
        }
        for (Thread t:threads) {
            t.start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ok");
    }
}
