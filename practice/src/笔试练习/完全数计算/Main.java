package 笔试练习.完全数计算;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-29
 * Time: 18:21
 */
public class Main {
    //求完全数
    public static boolean isPerNum(int n) {
        int sum = 0;//除去本身,约数最大就是它的一半
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum == n;
    }

    //求不大于n的所有完全数
    public static int getPerSum(int n) {
        int count = 0;//可以从6开始
        for (int i = 1; i < n; i++) {
            if (isPerNum(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(getPerSum(n));
        }
    }
}
