package web.Thread;

import java.util.concurrent.Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-04-15
 * Time: 21:16
 */
public class ThreadDemo6 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override //泛型参数就是返回值类型
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= 100; i++) {
                    sum+=i;
                }
                return sum;
            }
        };
        //Thread不支持直接使用callable
        //futureTask会保存了callable的返回值
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        int ret = futureTask.get();
        System.out.println(ret);
    }

    static class Result{
        public int sum = 0;
        public Object locker = new Object();
    }
    public static void main1(String[] args) throws InterruptedException {
        Result result = new Result();
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    result.sum+=i;
                }
                synchronized (result.locker) {
                    result.locker.notify();
                }

            }
        };
        thread.start();
        synchronized (result.locker) {
            while(result.sum==0) {
                result.locker.wait();
            }
        }
        System.out.println(result.sum);
    }
}
