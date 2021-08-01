package 其他练习.杂七杂八.旧键盘;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-30
 * Time: 11:05
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        Set<Character> set1 = new HashSet<>();//存放好的键盘
        Set<Character> set2 = new HashSet<>();//存放已经输出的字符
        for (int i = 0; i < str2.length(); i++) {
            set1.add(str2.charAt(i));
        }
        for (int i = 0; i < str1.length(); i++) {
            if (!set1.contains(str1.charAt(i))&& !set2.contains(str1.charAt(i))) {
                System.out.print(str1.charAt(i));
                set2.add(str1.charAt(i));
            }
        }
    }
}
