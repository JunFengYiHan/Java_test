package web.Thread;

import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-04-15
 * Time: 22:34
 */
public class ThreadDemo8 {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4);
        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {

                    try {
                        System.out.println("准备申请资源");
                        semaphore.acquire();//获取
                        System.out.println("申请成功");
                        Thread.sleep(1000);
                        System.out.println("释放完毕");
                        semaphore.release();//释放
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }

    }
}
