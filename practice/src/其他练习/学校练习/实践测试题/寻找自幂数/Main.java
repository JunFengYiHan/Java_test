package 其他练习.学校练习.实践测试题.寻找自幂数;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-12-14
 * Time: 15:53
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = (int) Math.pow(10, n - 1); i <= Math.pow(10, n) - 1; i++) {
                if (isSincePow(i, n)) {
                    System.out.println(i);
                }
            }
        }
    }

    private static boolean isSincePow(int num, int n) {
        int sum = 0;
        int tmp = num;
        while (tmp != 0) {
            sum += Math.pow(tmp % 10, n);
            tmp /= 10;
        }
        return sum == num;
    }
}
