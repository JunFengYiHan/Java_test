package web.Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-04-12
 * Time: 23:06
 */
public class TestThreadDemo4 {
    private static int count = 0;
    private static Object locker = new Object();
//    synchronized public static void func(){
//        count++;
//    }

    //    public static void func() {
//        synchronized(locker) {
//            count++;
//        }
//
//    }
    public static void func() {//类对象,描述当前类,唯一
        synchronized (TestThreadDemo4.class) {
            count++;
        }

    }

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    func();
                }
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    func();
                }
            }
        };
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
