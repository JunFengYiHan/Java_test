package 笔试练习.删除公共字符;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-12
 * Time: 18:35
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            if (!s2.contains(ch+"")) {
                sb.append(ch);
            }
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
