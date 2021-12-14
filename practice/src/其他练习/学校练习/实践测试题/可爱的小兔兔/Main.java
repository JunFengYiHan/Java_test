package 其他练习.学校练习.实践测试题.可爱的小兔兔;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-12-14
 * Time: 16:08
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println("第" + n + "个月兔子总数为: " + fib(n));
        }
    }

    private static int fib(int n) {
        if (n <= 2) {
            return 1;
        }
        int f1 = 1;
        int f2 = 1;
        while (n>2) {
            int f3 = f2+f1;
            f1 = f2;
            f2 = f3;
            n--;
        }
        return f2;
    }
}
