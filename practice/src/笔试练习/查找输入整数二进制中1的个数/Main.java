package 笔试练习.查找输入整数二进制中1的个数;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-28
 * Time: 18:06
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(findOne(n));
        }
    }
    public static int findOne(int n) {
        int count = 0;
        while(n!=0) {
            count++;
            n = n & n-1;
        }
        return count;
    }
//    public static int findOne(int n) {
//        if (n==0) {
//            return 0;
//        }
//        return 1+findOne(n&(n-1));
//    }
}
