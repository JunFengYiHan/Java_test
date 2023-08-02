package demo3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/2
 * Time: 21:38
 */

public class ThreadDemo3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= 1000; i++) {
                    sum += i;
                }
                return sum;
            }
        };
        //因为Thread类不直接支持Callable于是需要使用FutureTask类保存Callable的返回值
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        //Thread t = new Thread(callable);
        Thread t = new Thread(futureTask);
        t.start();
        //尝试获取值,如果获取不到则阻塞等待
        Integer result = futureTask.get();
        System.out.println(result);
    }
}
