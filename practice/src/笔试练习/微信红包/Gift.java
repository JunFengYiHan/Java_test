package 笔试练习.微信红包;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-11-05
 * Time: 17:25
 */
public class Gift {
    public int getValue(int[] gifts, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int data : gifts) {
            map.put(data, map.getOrDefault(data, 0) + 1);
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if (entry.getValue()>n/2) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
