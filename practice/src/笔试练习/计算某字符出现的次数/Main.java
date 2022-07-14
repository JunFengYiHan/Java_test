package 笔试练习.计算某字符出现的次数;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/7/14
 * Time: 23:54
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        char ch = str2.charAt(0);
        int ret = getCharNum(str1, ch);
        System.out.println(ret);
    }

    private static int getCharNum(String str, char ch) {
        String tmp = str.toUpperCase();
        if (ch >= 'a') ch -= 32;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tmp.length(); i++) {
            char cur = tmp.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        return map.getOrDefault(ch, 0);
    }
}
