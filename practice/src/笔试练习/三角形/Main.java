package 笔试练习.三角形;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/7/26
 * Time: 23:31
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.next();
            String str2 = scanner.next();
            String str3 = scanner.next();
            BigDecimal a = new BigDecimal(str1);
            BigDecimal b = new BigDecimal(str2);
            BigDecimal c = new BigDecimal(str3);
            if (a.add(b).compareTo(c) > 0 && a.add(c).compareTo(b) > 0 && b.add(c).compareTo(a) > 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
