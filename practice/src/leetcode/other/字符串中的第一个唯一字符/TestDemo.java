package leetcode.other.字符串中的第一个唯一字符;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-28
 * Time: 21:50
 */
public class TestDemo {
    public int firstUniqChar(String s) {
        //key->出现的字符，value->所在下标
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i),-1);
            }else {
                map.put(s.charAt(i),i);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i))!=-1) {
                return map.get(s.charAt(i));
            }
        }
        return -1;
    }
//    public int firstUniqChar(String s) {
//        //key->出现的字符，value->出现的次数
//        Map<Character,Integer> map = new HashMap<>();
//        //将各个字母出现的次数统计放入map中
//        for (int i = 0; i < s.length(); i++) {
//            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
//        }
//        //再次遍历字符串，从map中寻找出现一次的字母
//        for (int i = 0; i < s.length(); i++) {
//            if (map.get(s.charAt(i))==1) {
//                return i;
//            }
//        }
//        return -1;
//    }
}
