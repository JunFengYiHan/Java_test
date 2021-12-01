package 其他练习.学校练习.Java实验.第8次作业;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-11-29
 * Time: 19:21
 */
public class MyThread3 implements Runnable {
    private int left;
    private int right;
    private int sum;

    public MyThread3(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public void run() {
        sum = (left + right) * (right - left + 1) / 2;
    }
}
