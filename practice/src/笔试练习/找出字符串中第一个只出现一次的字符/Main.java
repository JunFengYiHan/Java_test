package 笔试练习.找出字符串中第一个只出现一次的字符;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-11-05
 * Time: 16:20
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            boolean flag = false;
            char ch = '0';
            for (int i = 0; i < str.length(); i++) {
                ch = str.charAt(i);
                if (map.get(ch) == 1) {
                    flag = true;
                    break;
                }
            }
            System.out.println(flag ? ch : "-1");
            System.out.println(flag ? ch : -1);
        }
    }
}
