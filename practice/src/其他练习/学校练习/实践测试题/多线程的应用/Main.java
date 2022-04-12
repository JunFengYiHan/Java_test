package 其他练习.学校练习.实践测试题.多线程的应用;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-12-17
 * Time: 14:26
 */
public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("A",0);
        MyThread t2 = new MyThread("B",1);
        MyThread t3 = new MyThread("C",2);
        new Thread(t1).start();

        new Thread(t2).start();

        new Thread(t3).start();
    }
}
