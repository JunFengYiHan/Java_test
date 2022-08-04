package 笔试练习.年会抽奖;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/8/4
 * Time: 23:34
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            double ret = getProbability(n);
            System.out.printf("%.2f%%", ret * 100);
        }
    }

    public static double getProbability(int n) {
        double sum = 1.0;
        //求每个人都没获奖
        for (int i = 0; i < n - 1; i++) {
            sum *= (1.0 - 1.0 /( n - i));
        }
        return sum;
    }
}
