package leetcode.other.连续数组;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-08-04
 * Time: 20:45
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        int[] record = new int[nums.length];
        //将0,1转换成1,-1的形式,并求得前缀和
        for (int i = 1; i < nums.length; i++) {
            record[i] = record[i-1] + (nums[i-1]==1?1:-1);
        }
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int ret = 0;
        for (int i = 1; i < record.length; i++) {
            if (!map.containsKey(record[i])) {
                map.put(record[i],i);
            }
            if (map.containsKey(record[i])) {
                ret = Math.max(ret,i-map.get(record[i]));
            }
        }
        return ret;
    }
//    public int findMaxLength(int[] nums) {
//        int[] record = new int[nums.length];
//        Map<Integer,Integer> map = new HashMap<>();
//        int cur = 0;
//        int ret = 0;
//        map.put(cur,-1);//将-1下标当作和的开始,从0开始累加
//        for (int i = 0; i < nums.length; i++) {
//            cur = nums[i]==1?cur+1:cur-1;//1+,0-
//            //第一次出现入表,不是第一次出现求长度
//            if (!map.containsKey(cur)) {
//                map.put(cur,i);
//            } else{
//                ret = Math.max(ret,i-map.get(cur));
//            }
//        }
//        return ret;
//    }
}
