package 笔试练习.快到碗里来;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/7/25
 * Time: 23:46
 */
public class Main {
    public static final double PI = 3.14;

    //取值范围在1-2^128可能会大于所有的数据类型范围
    //使用BigDecimal解决大数
    //构造方法参数可以是,整形,浮点型,字符串(纯数值型),推荐使用字符串
    //bigDecimal.add(bigDecimal) 加法
    //bigDecimal.subtract(bigDecimal) 减法
    //bigDecimal.multiply(bigDecimal) 乘法
    //bigDecimal.divide(bigDecimal) 除法
    //bigDecimal.abs(bigDecimal) 绝对值
    //bigDecimal.pow(bigDecimal) 乘方
    //bigDecimal.equals(bigDecimal)  比较精度也比较大小
    //bigDecimal.compareTo(bigDecimal)  只比较大小
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            BigDecimal n = new BigDecimal(scanner.next());
            BigDecimal r = new BigDecimal(scanner.next());
            r = r.multiply(new BigDecimal(2 * PI));
            if (n.compareTo(r) < 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
