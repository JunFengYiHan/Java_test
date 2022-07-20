package 笔试练习.杨辉三角的变形;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-30
 * Time: 17:49
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n <= 2) {
                System.out.println(-1);
            } else if (n % 2 == 1) {//n % 4 == 1 || n % 4 == 3
                System.out.println(2);
            } else if (n % 4 == 0) {
                System.out.println(3);
            } else {
                System.out.println(4);
            }
        }
    }

}
