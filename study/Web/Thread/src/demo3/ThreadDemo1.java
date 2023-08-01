package demo3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/1
 * Time: 22:05
 */

public class ThreadDemo1 {
    public static void main(String[] args) {
        AtomicInteger num = new AtomicInteger(10);
        num.getAndAdd(10);
        System.out.println(num);
    }
}
