package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/15
 * Time: 21:36
 */

public class ThreadDemo9 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //currentThread()静态方法获取当前线程实例
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "myThread");
        t.start();

        System.out.println("id: " + t.getId());
        System.out.println("Name: " + t.getName());
        System.out.println("State: " + t.getState());
        System.out.println("Priority: " + t.getPriority());
        System.out.println("Daemon: " + t.isDaemon());
        System.out.println("isInterrupted: " + t.isInterrupted());
        System.out.println("isAlive: " + t.isAlive());

    }
}
