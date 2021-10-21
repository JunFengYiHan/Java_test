package 笔试练习.走方格的方案数;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-21
 * Time: 18:44
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(func(n, m));
        }
        sc.close();
    }
    public static int func(int x,int y) {
        if (x==0 || y==0) {
            return 1;
        }
        return func(x-1,y) + func(x,y-1);
    }
}
