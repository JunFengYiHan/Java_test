package 笔试练习.倒置字符串;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-12
 * Time: 19:13
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        for (int i = s.length - 1; i > 0; i--) {
            System.out.print(s[i]+" ");
        }
        System.out.print(s[0]);
        scanner.close();
    }
}
