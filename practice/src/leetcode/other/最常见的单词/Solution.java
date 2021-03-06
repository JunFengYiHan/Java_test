package leetcode.other.最常见的单词;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-08-01
 * Time: 18:16
 */
public class Solution {
//    //存在不足,以下测试用例会和预期答案不符合
//    // "Bob hit the ball, a the hit BALL flew far after it was hit."
//    //["hit"]
//    public String mostCommonWord(String paragraph, String[] banned) {
//        paragraph += ".";//防止空串
//        Set<String> banSet = new HashSet();
//        for (String word: banned) banSet.add(word);
//        Map<String, Integer> count = new HashMap();
//        String ans = "";//最终结果
//        int ansFreq = 0;//出现的次数
//        StringBuilder word = new StringBuilder();
//        for (char c: paragraph.toCharArray()) {
//            //判断是不是字母,是就变成小写放到字符串中,拼成单词
//            if (Character.isLetter(c)) {
//                word.append(Character.toLowerCase(c));
//            } else if (word.length() > 0) {//当前字符不是字母,且word已经是单词
//                String finalWord = word.toString();//变成字符串
//                if (!banSet.contains(finalWord)) {//不是禁止的字符串
//                    count.put(finalWord, count.getOrDefault(finalWord, 0) + 1);//数量加一
//                    if (count.get(finalWord) > ansFreq) {
//                        ans = finalWord;
//                        ansFreq = count.get(finalWord);
//                    }
//                }
//                word = new StringBuilder();
//            }
//        }
//        return ans;
//    }
    //未完善的代码
    public static String mostCommonWord(String paragraph, String[] banned) {
        //字母全部转小写
        paragraph = paragraph.toLowerCase();
        Set<String> set = new HashSet<>();
        Map<String,Integer> map = new HashMap<>();
        for (String word:banned) {
            set.add(word);
        }
                                       //正则表达式,匹配括号里的符号,+表示一次或者多次
        String[] strings = paragraph.split("[ !?',;.]+");
        for (String str:strings) {
            if (!set.contains(str)) {
                map.put(str,map.getOrDefault(str,0)+1);
            }
        }
        ArrayList<String> arr = new ArrayList<>(map.keySet());
        Collections.sort(arr,(o1,o2)->{
            int n1 = map.get(o1);
            int n2 = map.get(o2);
            if (n1==n2) {
                return o1.compareTo(o2);
            }
            return n2 - n1;
        });

        return arr.get(0);
    }

    public static void main(String[] args) {
//        String str = "Bob hit a ball, the hit BALL flew far after it was hit.";
//        String[] ban = {"hit"};
        String str = "Bob. hIt, baLl";
        String[] ban = {"bob", "hit"};
        mostCommonWord(str,ban);
    }
}
