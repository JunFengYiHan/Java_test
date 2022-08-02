package 笔试练习.客似云来;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/8/2
 * Time: 23:57
 */
public class Main {
    static List<BigDecimal> list = new ArrayList<>();

    static {
        list.add(new BigDecimal("1"));
        list.add(new BigDecimal("1"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            if (to > list.size()) {
                fibonacci(to);
            }
            BigDecimal sum = new BigDecimal("0");
            for (int i = from - 1; i < to; i++) {
                sum = sum.add(list.get(i));
            }
            System.out.println(sum);
        }
    }

    static BigDecimal f1 = new BigDecimal("1");
    static BigDecimal f2 = new BigDecimal("1");

    public static void fibonacci(int n) {
        //不需要重置继续往下求
        while (n > list.size()) {
            BigDecimal f3 = f1.add(f2);
            f1 = f2;
            f2 = f3;
            list.add(f3);
        }
    }
}
