package demo3;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/2
 * Time: 21:12
 */

public class ThreadDemo2 {

    static class Result{
        public  Object locker = new Object();
        public  int sum = 0;
    }

    public static void main(String[] args) throws InterruptedException {
        Result result = new Result();
        Thread t = new Thread(){
            @Override
            public void run() {
                int sum = 0;
                for (int i = 1; i <= 1000; i++) {
                    sum+=i;
                }
                result.sum = sum;
                synchronized (result.locker) {
                    result.locker.notify();
                }
            }
        };

        t.start();

        //t.join();
        synchronized (result.locker) {
            while(result.sum==0) {
                result.locker.wait();
            }
        }
        System.out.println(result.sum);
    }
}
