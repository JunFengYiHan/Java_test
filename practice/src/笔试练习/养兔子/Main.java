package 笔试练习.养兔子;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/8/3
 * Time: 23:40
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(getRabbitNum(n));
        }
    }

    static List<BigDecimal> list = new ArrayList<>();
    static BigDecimal f1 = new BigDecimal("1");
    static BigDecimal f2 = new BigDecimal("1");
    static {
        list.add(f1);
        list.add(f2);
    }
    public static BigDecimal getRabbitNum(int n) {
//        if (n < list.size()) {
//            return list.get(n);
//        }
        while (n > list.size()) {
            BigDecimal f3 = f1.add(f2);
            f1 = f2;
            f2 = f3;
            list.add(f3);
        }
        return list.get(n - 1);
    }
}
