import java.util.SplittableRandom;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-06
 * Time: 21:02
 */
public class Solution {

    public boolean backspaceCompare(String s, String t) {
        return Builder(s).equals(Builder(t));
    }
    //重构字符串
    public String Builder(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)!='#'){
                sb.append(str.charAt(i));
            }else {
                if(sb.length()>0){
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        return sb.toString();
    }
//    //双字符栈
//    public boolean backspaceCompare(String s, String t) {
//        Stack<Character> stack1 = new Stack<>();
//        Stack<Character> stack2 = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            if(s.charAt(i)!='#'){
//                stack1.push(s.charAt(i));
//            }else if(!stack1.empty()){
//                stack1.pop();
//            }
//        }
//        for (int i = 0; i < t.length(); i++) {
//            if(s.charAt(i)!='#'){
//                stack2.push(s.charAt(i));
//            }else if(!stack1.empty()){
//                stack2.pop();
//            }
//        }
//        return String.valueOf(stack1).equals(String.valueOf(stack2));
//    }
}
