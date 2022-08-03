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
        String str = scanner.nextLine();
        String[] strs = str.split("<br/>");
        for (int i = 0; i < strs.length; i++) {
            int n = Integer.parseInt(strs[i]);
            System.out.print(getRabbitNum(n));
            if (i < strs.length - 1) {
                System.out.print("<br/>");
            }
        }
    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        while (scanner.hasNext()) {
//            int n = scanner.nextInt();
//            System.out.println(getRabbitNum(n));
//        }
//    }

    static List<BigDecimal> list = new ArrayList<>();
    static BigDecimal f = new BigDecimal("1");
    static BigDecimal sum = new BigDecimal("0");

    static {
        list.add(f);
    }

    public static BigDecimal getRabbitNum(int n) {
//        if (n < list.size()) {
//            return list.get(n);
//        }
        while (n > list.size()) {
            f = f.multiply(new BigDecimal("2"));
            list.add(f);
        }
        return list.get(n - 1);
    }
}
