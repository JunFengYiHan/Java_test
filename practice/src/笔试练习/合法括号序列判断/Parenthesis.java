package 笔试练习.合法括号序列判断;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-19
 * Time: 16:09
 */
public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char tmp = A.charAt(i);
            if(tmp=='('||tmp==')') {
                if(tmp=='(') {
                    stack.push(tmp);
                }else{
                    if(!stack.empty()&&stack.peek()=='(') {
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }else{
                return false;
            }
        }
        return stack.empty();
    }
//    public boolean chkParenthesis(String A, int n) {
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < n; i++) {
//            char tmp = A.charAt(i);
//            if (tmp=='(') {
//                stack.push(tmp);
//            }else if (tmp==')') {
//                if (stack.empty()||stack.pop()!='(') {
//                    return false;
//                }
//            }else {
//                return false;
//            }
//        }
//        return stack.empty();
//    }
}
