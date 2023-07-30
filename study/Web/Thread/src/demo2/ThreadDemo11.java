package demo2;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/30
 * Time: 22:28
 */

public class ThreadDemo11 {

    public static void main(String[] args) {
        System.out.println("代码开始执行");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("触发定时器");
            }
        },3000);

    }
}
