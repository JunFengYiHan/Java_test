package web.Thread;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/7/5
 * Time: 19:57
 */
public class VolatileDemo {
    static  int flag = 0;
    //static volatile int flag = 0;//确保每次访问flag都访问内存,拿到最新值,而不是读取寄存器保存的flag值

    public static void main(String[] args) {

        Thread t1 = new Thread(){
            @Override
            public void run() {
                while(flag==0) {
                    //System.out.println("t1");
                }
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("请输入: ");
                flag = scanner.nextInt();
            }
        };
        t2.start();
    }
}
