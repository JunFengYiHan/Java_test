package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/29
 * Time: 17:32
 */

public class ThreadDemo10 {

    private static boolean flag = true;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                while(flag) {
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

        Thread.sleep(3000);
        //调整flag的值结束循环
        flag=false;

    }
}
