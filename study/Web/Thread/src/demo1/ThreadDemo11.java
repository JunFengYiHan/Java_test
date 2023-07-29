package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/29
 * Time: 17:42
 */

public class ThreadDemo11 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                //isInterrupted()默认值为false
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        System.out.println("线程执行中...");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        //触发异常时也能正常结束线程
                        break;
                    }
                }
            }
        };

        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //修改isInterrupted()的值为true
        t.interrupt();
    }
}
