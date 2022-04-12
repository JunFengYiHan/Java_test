package 其他练习.学校练习.实践测试题.多线程的应用;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-12-22
 * Time: 20:23
 */
public class MyThread implements Runnable {
    private String val;
    private static int count;
    private static Object lock = new Object();
    private int flag;

    public MyThread(String val, int flag) {
        this.val = val;
        this.flag = flag;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            synchronized (lock) {
                while (count % 3 != flag) {
                    try {
                        lock.wait();//等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(val);
                count++;
                lock.notifyAll();//唤醒所有等待的线程
                //new Object().notifyAll();
            }
        }
    }
}
