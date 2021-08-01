package 其他练习.杂七杂八.斐波那契数列;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-31
 * Time: 9:21
 */
public class Main {
    //求一个数变成斐波那契数的最小步数
    public static void main(String[] args) {
        //斐波那契数列的前两个数
        int f1 = 0;
        int f2 = 1;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int f3 = f1+f2;//第三项等于前两项之和
        while(f3<n) {
            f1 = f2;
            f2 = f3;
            f3 = f1+f2;
        }
        int stepNums = Math.min(f3 - n, n - f2);
        System.out.println(stepNums);
    }
}
