import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-05
 * Time: 18:39
 */
public class 栈的压入弹出序列 {
    public class Solution {
        public boolean IsPopOrder(int [] pushA,int [] popA) {
            Stack<Integer> stack = new Stack();
            for(int i=0,j=0;i<pushA.length;i++){
                if(pushA[i]!=popA[j]){
                    stack.push(pushA[i]);
                }else{
                    j++;
                    while(!stack.empty()&&stack.peek()==popA[j]){
                        stack.pop();
                        j++;
                    }
                }
            }
            return stack.empty();
        }
    }
}
