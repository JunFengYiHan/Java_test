package 笔试练习.计算糖果;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-14
 * Time: 19:09
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();//A-B
        int b = sc.nextInt();//B-C
        int c = sc.nextInt();//A+B
        int d = sc.nextInt();//B+C
        int A = (a+c)/2;
        int B = (b+d)/2;
        int C = (d-b)/2;
        if (A-B!=a || B-C!=b || A+B!=c || B+C!=d) {
            System.out.print("No");
        }else{
            System.out.print(A+" "+B+" "+C);
        }
        sc.close();
    }
}
