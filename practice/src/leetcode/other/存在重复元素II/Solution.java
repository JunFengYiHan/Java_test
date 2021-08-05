package leetcode.other.存在重复元素II;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-08-04
 * Time: 16:10
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            //判断是否已经包含当前元素
            if (set.contains(nums[i])) {
                return true;
            }
            //添加当前元素
            set.add(nums[i]);
            //维护一个k大小的空间,确保abs(i-j)<=k
            if (set.size()>k) {
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
    //超时
//    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = nums.length - 1; j > i; j--) {
//                if (nums[i]==nums[j] && j-i<=k) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
