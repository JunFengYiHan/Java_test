package 笔试练习.分解因数;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/7/31
 * Time: 22:48
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(getFactor(n));
        }
    }

    //存储已经计算过的素数
    private static List<Integer> list = new ArrayList<>();
    static int index = 0;//当前取用到已存储的哪一个下标

    // 计算因数串
    public static String getFactor(int n) {
        StringBuilder sb = new StringBuilder(n + " =");
        int k = 2;
        while (true) {
            while (n % k == 0) {
                sb.append(" " + k + " *");
                n /= k;
            }
            if (n == 1) break;
            k = nextFactor(k);
        }
        index = 0;//下标重新置为0;
        //删除最后两个字符
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    //求取质数
    private static int nextFactor(int k) {
        //list.get(list.size()-1) > k防止list增长导致nextFactor重复调用一次
        if (index < list.size()) {
            return list.get(index++);
        }
        k += 1;//跳过当前k;
        for (int i = 2; i <= Math.sqrt(k); i++) {
            //不是质数重新开始
            if (k % i == 0) {
                k += 1;
                i = 1;
            }
        }
        //保存每一个被计算过的素数,2除外,k从2开始
        list.add(k);
        return k;
    }
}
