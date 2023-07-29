package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/29
 * Time: 19:25
 */

public class ThreadDemo15 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        System.out.println(t.getId()+":"+t.getState());
        t.start();
        Thread.sleep(1000);
        System.out.println(t.getId()+":"+t.getState());
        t.interrupt();
        Thread.sleep(1000);
        System.out.println(t.getId()+":"+t.getState());
        //打印线程的所有状态
//        for (Thread.State state : Thread.State.values()) {
//            System.out.println(state);
//        }
    }
}
