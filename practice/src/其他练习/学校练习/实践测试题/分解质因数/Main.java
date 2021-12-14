package 其他练习.学校练习.实践测试题.分解质因数;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-12-14
 * Time: 16:31
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(resolve(n));
        }
    }

    private static String resolve(int n) {
        StringBuilder sb = new StringBuilder();
        int tmp = n;
        sb.append(n).append('=');
        int prime = 2;
        while (tmp != 1) {
            while (tmp % prime == 0) {
                sb.append(prime).append('*');
                tmp /= prime;
            }
            prime = nextPrime(prime);
        }
        //去掉末尾的*并返回字符串
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private static int nextPrime(int prime) {
        boolean flag = true;
        for (int i = prime + 1; i < Integer.MAX_VALUE; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
            flag = true;
        }
        return -1;
    }

}
