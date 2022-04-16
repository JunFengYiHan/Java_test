package web.Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-04-12
 * Time: 19:53
 */
public class TestThreadDemo2 {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("线程执行中...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                System.out.println("线程结束!");
            }
        };
        thread.start();

        try {
            System.out.println("join开始执行");
            thread.join();
            //thread.interrupt();
            System.out.println("join执行结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
