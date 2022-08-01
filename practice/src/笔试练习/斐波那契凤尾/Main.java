package 笔试练习.斐波那契凤尾;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/8/1
 * Time: 23:20
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal tmp = new BigDecimal("1000000");
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            BigDecimal ret = fibonacci(n);
            if (ret.compareTo(tmp) < 0) {
                System.out.println(ret);
                continue;
            }
            StringBuilder sb = new StringBuilder(ret + "");
            System.out.println(sb.substring(sb.length() - 6, sb.length()));
        }
    }

    //将已经求好的值存储起来
    static List<BigDecimal> list = new ArrayList<>();
    static BigDecimal f1;
    static BigDecimal f2;

    //添加12
    static {
        list.add(new BigDecimal("1"));
        list.add(new BigDecimal("2"));
    }

    public static BigDecimal fibonacci(int n) {

        if (n <= list.size()) return list.get(n - 1);

        f1 = new BigDecimal("1");
        f2 = new BigDecimal("2");
        while (n > 2) {
            BigDecimal f3 = f1.add(f2);
            f1 = f2;
            f2 = f3;
            list.add(f2);//记录值不重新求
            n--;
        }
        return f2;
    }
    //累加结果太大无法存下
//    public static long fibonacci(int n) {
//        //前两个均为1
//        if (n < 2) {
//            return 1;
//        }
//
//        long f1 = 1;
//        long f2 = 2;
//        while (n > 2) {
//            long f3 = f1 + f2;
//            f1 = f2;
//            f2 = f3;
//            n--;
//        }
//        return f2;
//    }
}
