package leetcode.每日一题.下一个更大元素I;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-26
 * Time: 16:00
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {
            while(!stack.empty() && stack.peek()<nums2[i]){
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int[] ret = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ret[i] = map.getOrDefault(nums1[i],-1);
        }
        return ret;
    }
}
//public class Solution {
//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        int[] ret = new int[nums1.length];
//        for (int i = 0; i < nums1.length; i++) {
//            int j = 0;
//            while(j<nums2.length && nums2[j]!=nums1[i]) {
//                j++;
//            }
//            int k = j + 1;
//            while(k<nums2.length) {
//                if (nums2[k]>nums1[i]) {
//                    break;
//                }
//                k++;
//            }
//            ret[i] = k<nums2.length?nums2[k]:-1;
//        }
//        return ret;
//    }
//}
