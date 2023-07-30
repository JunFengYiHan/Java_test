package demo2;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/30
 * Time: 17:17
 */

public class ThreadDemo3 {
    static class Counter {
        //添加volatile确保内存可见性
        public volatile int flag = 0;
        //public int flag = 0;
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t = new Thread() {
            @Override
            public void run() {
                //当大量重复读取时,编译器会将进行优化,不会每次都读取主内存
                //而是将数据读取到工作内存中,读取数据是读取工作内存中的数据
                //工作内存是所有的cache的统称
                while (counter.flag == 0) {

                }
                System.out.println("线程结束");
            }
        };
        t.start();

        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个整数:");
        counter.flag = scan.nextInt();
    }
}
