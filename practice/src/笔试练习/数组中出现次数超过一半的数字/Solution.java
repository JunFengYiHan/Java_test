package 笔试练习.数组中出现次数超过一半的数字;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-13
 * Time: 19:20
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer,Integer> map = new HashMap<>();
        int ret = 0;
        for (int i = 0; i < array.length; i++) {
            map.put(array[i],map.getOrDefault(array[i],0)+1);
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if (entry.getValue() > array.length/2) {
                ret  = entry.getKey();
            }
        }
        return ret;
    }
}
