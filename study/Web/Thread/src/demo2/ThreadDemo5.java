package demo2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/30
 * Time: 18:27
 */

public class ThreadDemo5 {
    static class WaitTask implements Runnable {
        private Object locker = null;

        public WaitTask(Object locker) {
            this.locker = locker;
        }

        @Override
        public void run() {
            //进行wait等待
            System.out.println("wait 开始");
            try {
                synchronized (locker) {
                    locker.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait 结束");
        }
    }

    static class NotifyTask implements Runnable {
        private Object locker = null;

        public NotifyTask(Object locker) {
            this.locker = locker;
        }

        @Override
        public void run() {
            //进行notify唤醒
            System.out.println("notify 开始");
            synchronized (locker) {
                locker.notify();
                //locker.notifyAll();//全部唤醒
            }
            System.out.println("notify 结束");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();
        Thread t10 = new Thread(new WaitTask(locker));
        Thread t11 = new Thread(new WaitTask(locker));
        Thread t12 = new Thread(new WaitTask(locker));
        Thread t2 = new Thread(new NotifyTask(locker));

        t10.start();
        t11.start();
        t12.start();
        Thread.sleep(3000);
        t2.start();
    }
}
