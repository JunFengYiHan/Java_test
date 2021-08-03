package leetcode.other.两个数组的交集II;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-08-03
 * Time: 22:05
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] tmp = new int[Math.min(nums1.length,nums2.length)];
        int i = 0;
        int j = 0;
        int useSize = 0;
        while(i<nums1.length && j<nums2.length) {
            if (nums1[i]<nums2[j]) {
                i++;
            }else if (nums1[i]>nums2[j]) {
                j++;
            }else {
                tmp[useSize++] = nums1[i++];
                j++;
            }
        }
        int[] ret = new int[useSize];
        for (i = 0; i < useSize; i++) {
            ret[i] = tmp[i];
        }
        return ret;
    }
}
