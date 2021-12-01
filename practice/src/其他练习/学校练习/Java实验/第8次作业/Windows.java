package 其他练习.学校练习.Java实验.第8次作业;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-11-29
 * Time: 16:09
 */
public class Windows implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            this.func();
        }
    }

    public synchronized void func() {
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票: " + ticket--);
        }
    }
}
