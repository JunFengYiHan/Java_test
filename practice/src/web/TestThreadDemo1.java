package web;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-04-12
 * Time: 18:34
 */
public class TestThreadDemo1 {
    private static long count = 20_0000_0000L;

    //并发
    public static void concurrency() {
        long start = System.currentTimeMillis();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                int a = 0;
                for (int i = 0; i < count; i++) {
                    a++;
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                int b = 0;
                for (int i = 0; i < count; i++) {
                    b++;
                }
            }
        };
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("并发: " + (end - start));
    }

    //串行
    public static void serial() {
        Thread t = new Thread() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                int a = 0;
                for (int i = 0; i < count; i++) {
                    a++;
                }
                int b = 0;
                for (int i = 0; i < count; i++) {
                    b++;
                }
                long end = System.currentTimeMillis();
                System.out.println("串行: " + (end - start));
            }
        };
        t.start();
    }

    public static void main(String[] args) {
        serial();
        concurrency();
    }
}
