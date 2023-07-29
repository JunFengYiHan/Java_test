package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/29
 * Time: 18:19
 */

public class ThreadDemo13 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                int count = 0;
                while(count<5) {
                    count++;
                    System.out.println("线程执行中...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();

        try {
            //Thread.sleep(6000);//当线程t已经执行完毕则不需要阻塞等待
            //阻塞等待t线程执行完毕
            System.out.println("join 开始执行");
            t.join();
            System.out.println("join 执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
