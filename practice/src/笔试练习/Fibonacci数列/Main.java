package 笔试练习.Fibonacci数列;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-19
 * Time: 16:02
 */
public class Main {
    public static void main(String[] args) {
        int f1 = 0;
        int f2 = 1;
        int f3 = 1;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(f3<n) {
            f1 = f2;
            f2 = f3;
            f3 = f1+f2;
        }
        System.out.println(Math.min(f3 - n, n - f2));
    }
}
