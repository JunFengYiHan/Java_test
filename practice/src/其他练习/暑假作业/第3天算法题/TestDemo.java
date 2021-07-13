package 其他练习.暑假作业.第3天算法题;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-13
 * Time: 9:22
 */
public class TestDemo {
    //求一个十进制数字在内存中二进制1的个数。要求：正数和负数都可以求，并且时间最优
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
         int n = scanner.nextInt();
            System.out.println(n+"二进制中1的个数为"+findBinaryOne(n));
        }
    }
//    private static int findBinaryOne(int n) {
//        if(n==0) return 0;
//        return 1 +findBinaryOne(n&(n-1));
//    }
    private static int findBinaryOne(int n) {
        int count = 0;
        while(n!=0) {
            count++;
            n = n&(n-1);
        }
        return count;
    }
}
