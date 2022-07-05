package 笔试练习.最小公倍数;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-20
 * Time: 18:53
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a;
        if(a<b) {
            a = b;
            b = c;
            c = a;
        }
        while(a%b!=0) {
            a+=c;
        }
        System.out.println(a);
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int ret = a>b?a:b;
//        while(ret%b!=0||ret%a!=0) {
//            ret++;
//        }
//        System.out.println(ret);
//    }
}
