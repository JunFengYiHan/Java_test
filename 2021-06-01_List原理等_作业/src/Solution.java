import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-05
 * Time: 16:49
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(String data:tokens){
            switch(data){
                case "+":
                    stack.push(stack.pop()+stack.pop());
                    break;
                case "-":
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(left-right);
                    break;
                case "*":
                    stack.push(stack.pop()*stack.pop());
                    break;
                case "/":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left/right);
                    break;
                default:
                    stack.push(Integer.valueOf(data));
                    break;
            }
        }
        return stack.pop();
    }
}
