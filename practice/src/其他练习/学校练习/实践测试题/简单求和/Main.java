package 其他练习.学校练习.实践测试题.简单求和;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-12-17
 * Time: 13:58
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(summation(a, n));
        sc.close();
    }

    private static double summation(int a, int n) {
        double sum = 0;
        double tmp = 0;
        for (int i = 1; i <= n; i++) {
            tmp = tmp * 10 + a;
            sum += tmp;
        }
        return sum;
    }
}
