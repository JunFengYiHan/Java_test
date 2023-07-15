package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/15
 * Time: 20:18
 */

public class ThreadDemo7 {
    public static final long COUNT = 10_0000_0000;

    public static void serial() {
        //时间戳:以1970年1月1日0时0分0秒为起点,和当前时间的毫秒级差值
        long beg = System.currentTimeMillis();//获取当前时间戳
        long a = 0;
        for (long i = 0; i < COUNT; i++) {
            a++;
        }
        long b = 0;
        for (long i = 0; i < COUNT; i++) {
            b++;
        }
        System.out.println(a+b);
        long end = System.currentTimeMillis();
        System.out.println(end-beg);

    }

    public static void concurrency(){
        long beg = System.currentTimeMillis();
        //匿名内部类实现并发
        Thread t1 = new Thread(){
            @Override
            public void run() {
                long a = 0;
                for (long i = 0; i < COUNT; i++) {
                    a++;
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                long b = 0;
                for (long i = 0; i < COUNT; i++) {
                    b++;
                }
            }
        };
        //启动线程
        t1.start();
        t2.start();

        try {
            //join()方法,表示等待对应线程执行完成
            //等待t1和t2执行完
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end-beg);
    }

    public static void main(String[] args) {
        //serial();
        concurrency();
    }
}
