package 笔试练习.查找组成一个偶数最近的两个素数;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-23
 * Time: 18:52
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;
        while(sc.hasNext()) {
            int n = sc.nextInt();
            for (int i = n/2; i >=2; i--) {//从最大的开始,第一个就是答案
                if (isPrime(i)&&isPrime(n-i)) {
                    a = i;
                    b = n - i;
                    break;
                }
            }
            System.out.println(a+"\n"+b);
        }
        sc.close();
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = 0;
//        int b = 0;
//        while(sc.hasNext()) {
//            int n = sc.nextInt();
//            for (int i = 2; i <= n/2; i++) {//从最小的开始逐个替换,最后结果就是答案
//                if (isPrime(i)&&isPrime(n-i)) {
//                    a = i;
//                    b = n - i;
//                }
//            }
//            System.out.println(a+"\n"+b);
//        }
//        sc.close();
//    }
    //判断是不是素数
    public static boolean isPrime(int n) {
        if (n == 2) return true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n%i==0) {
                return false;
            }
        }
        return true;
    }
}
