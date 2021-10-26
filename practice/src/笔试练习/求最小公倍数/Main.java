package 笔试练习.求最小公倍数;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-26
 * Time: 11:13
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int ret = Math.max(m, n);
        int tmp = ret;
        while(ret%m!=0||ret%n!=0) {
            ret+=tmp;
        }
        System.out.println(ret);
    }
}
