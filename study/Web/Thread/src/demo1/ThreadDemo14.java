package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/29
 * Time: 18:28
 */

public class ThreadDemo14 {
    public static void main(String[] args) {
        //当使用继承Thread类的方式时,Thread.currentThread等于this,因为this指向Thread实例
        Thread t = new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId());
                System.out.println(this.getId());
            }
        };
        t.start();
        //当使用实现Runnable接口的方式时,Thread.currentThread不等于this,因为this指向Runnable实例
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getId());
//                System.out.println(this.getId());
//            }
//        });
//        t.start();
    }
}
