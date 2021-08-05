package leetcode.other.找不同;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-08-04
 * Time: 16:00
 */
public class Solution {
    public char findTheDifference(String s, String t) {
        int ret = 0;
        for (int i = 0; i < t.length(); i++) {
            ret += t.charAt(i);
        }
        for (int i = 0; i < s.length(); i++) {
            ret -= s.charAt(i);
        }
        return (char)ret;
    }
//    public char findTheDifference(String s, String t) {
//        int ret = 0;
//        for (int i = 0; i < s.length(); i++) {
//            ret ^= s.charAt(i);
//        }
//        for (int i = 0; i < t.length(); i++) {
//            ret ^= t.charAt(i);
//        }
//        return (char)ret;
//    }
}
