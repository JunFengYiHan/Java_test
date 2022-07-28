package 笔试练习.有假币;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/7/28
 * Time: 23:19
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();

            if (n == 0) break;

            if (n == 1) {
                System.out.println(0);
                continue;
            }
            int count = 1;//最少一次
            while (n > 3) {
                count++;
                if (n % 3 == 1) {
                    n += 2;
                }
                n /= 3;
            }
            System.out.println(count);
        }
    }
}
