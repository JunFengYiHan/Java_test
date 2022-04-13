package web;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-04-13
 * Time: 19:21
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                Thread.currentThread().interrupt();
                while (true) {
                    System.out.println("thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        // break;
                    }
                }
                //System.out.println("run: " + Thread.interrupted());
            }
        };
        thread.start();
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Thread.currentThread().interrupt();

        System.out.println(Thread.interrupted());

        System.out.println(thread.isInterrupted());
    }
}
