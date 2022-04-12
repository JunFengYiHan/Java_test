package 其他练习.学校练习.实践测试题.LettheBalloonRise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-12-17
 * Time: 14:05
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            if (n == 0) break;
            for (int i = 0; i < n; i++) {
                String str = sc.nextLine();
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
            String ret = null;
            int max = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() > max) {
                    ret = entry.getKey();
                    max = entry.getValue();
                }
            }
            System.out.println(ret);
            map.clear();
        }
        sc.close();
    }
}
