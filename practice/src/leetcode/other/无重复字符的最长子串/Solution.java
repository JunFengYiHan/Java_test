package leetcode.other.无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-08-03
 * Time: 19:36
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] str = s.toCharArray();//转为字符数组
        int left = 0;//窗口的最左边
        int lenMax = 0;//存储最长度
        for (int right = 0; right < str.length; right++) {
            //如果这个字符已经出现过了
            if (map.containsKey(str[right])) {
                //当前字符可能在前面出现过,所有加一个判断,确保left不往前移
                left = Math.max(left,map.get(str[right])+1);//指向当前字符出现的位置的下一个字符
            }
            map.put(str[right],right);//放入当前字母出现的位置
            lenMax = Math.max(lenMax,right-left+1);//求取当前较大的长度
        }
        return lenMax;
    }
}
