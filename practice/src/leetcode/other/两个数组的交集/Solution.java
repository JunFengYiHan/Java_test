package leetcode.other.两个数组的交集;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-08-01
 * Time: 10:40
 */
public class Solution {
    //方法二,排序+双指针
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();//存放结果,并去重
        int i = 0;
        int j = 0;
        //两个数组均有序了
        while(i<nums1.length && j<nums2.length) {
            if (nums1[i]>nums2[j]) {
                j++;
            } else if (nums1[i]<nums2[j]) {
                i++;
            }else {
                set.add(nums1[i]);
            }
        }
        int[] ret = new int[set.size()];
        int useSize = 0;
        for (Integer data: set) {
            ret[useSize++] = data;
        }
        return ret;
    }
    //方法一,双set
//    public int[] intersection(int[] nums1, int[] nums2) {
//        Set<Integer> set1 = new HashSet<>();//存储1中所有元素
//        Set<Integer> set2 = new HashSet<>();//存放交集
//        for (int data:nums1) {
//            set1.add(data);
//        }
//        for (int data:nums2) {
//            if (set1.contains(data)) {//1中存在才放入2中
//                set2.add(data);
//            }
//        }
//        int[] ret = new int[set2.size()];
//        int useSize = 0;
////        Iterator<Integer> it = set2.iterator();//迭代器打印
////        while (it.hasNext()) {
////            ret[useSize++] = it.next();
////        }
//        for (Integer data:set2) {
//            ret[useSize++] = data;
//        }
//        return ret;
//    }
}
