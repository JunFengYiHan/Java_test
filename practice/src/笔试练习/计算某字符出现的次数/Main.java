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
        String str = scanner.nextLine();
        int ret = getCharNum(str);
    }

    private static int getCharNum(String str) {
        String tmp = str.toLowerCase();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < tmp.length(); i++) {
            char cur
            map.put()
        }
    }
}
