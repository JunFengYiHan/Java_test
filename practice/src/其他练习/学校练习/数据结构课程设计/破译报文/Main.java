package 其他练习.学校练习.数据结构课程设计.破译报文;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-12-03
 * Time: 15:54
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(getCiphertextLength(str));
    }

    private static int getCiphertextLength(String str) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String s = str.substring(i, j);
                if (s.length() < str.length()) {
                    map.put(s, map.getOrDefault(s, 0) + 1);
                }
            }
        }
        int ret = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getKey().length() > ret && entry.getValue() > 1) {
                ret = entry.getKey().length();
            }
        }
        return ret;
    }
}
