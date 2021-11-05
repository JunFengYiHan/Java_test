package 笔试练习.小易的升级之路;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-11-05
 * Time: 16:45
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int b = sc.nextInt();
                if (a >= b) {
                    a += b;
                } else {
                    a += gcd(a, b);
                }
            }
            System.out.println(a);
        }
    }

    public static int gcd(int a, int b) {
        while (a % b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return b;
    }
}
