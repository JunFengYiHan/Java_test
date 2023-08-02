package demo3;

import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/2
 * Time: 22:10
 */

public class ThreadDemo5 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4);
        //实现接口,方便创建多个相同线程
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("准备申请资源");
                    //申请资源
                    semaphore.acquire();
                    System.out.println("申请成功");
                    //执行   休眠代替
                    System.out.println("执行中...");
                    Thread.sleep(1000);
                    //释放资源
                    semaphore.release();
                    System.out.println("释放成功");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //通过接口创建多个相同线程
        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
    }
}
