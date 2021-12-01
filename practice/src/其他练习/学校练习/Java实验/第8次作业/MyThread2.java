package 其他练习.学校练习.Java实验.第8次作业;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-11-29
 * Time: 15:51
 */
public class MyThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.print("学号:20208988 ");
            if (i%5==0) {
                System.out.println();
            }
        }
    }
}
