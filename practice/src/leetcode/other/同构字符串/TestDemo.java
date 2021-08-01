package leetcode.other.同构字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-08-01
 * Time: 10:22
 */
public class TestDemo {
    public boolean isIsomorphic(String s, String t) {
        //存放映射关系,题目要求映射关系唯一,如s映射t 那么 t只能由s映射
        Map<Character,Character> map1 = new HashMap<>();
        Map<Character,Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            //判断对应字符是否相等,返回当前对应值,过滤还没有放入的的情况
            //不同的字符不能映射到同一个字符上
            if (map1.getOrDefault(s.charAt(i),t.charAt(i))==t.charAt(i)
            && map2.getOrDefault(t.charAt(i),s.charAt(i))==s.charAt(i)) {
                //存入对应的映射关系
                map1.put(s.charAt(i),t.charAt(i));
                map2.put(t.charAt(i),s.charAt(i));
            }else {
                return false;
            }
        }
        return true;
    }
}
