package leetcode.linkedlist.链表中的下一个更大节点;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-23
 * Time: 22:24
 */
class ListNode {
    int val;
    ListNode next;
     ListNode(int x) { val = x; }
}
public class 链表中的下一个更大节点 {
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for(;head!=null;head = head.next){
            //栈不为空 且 当前栈顶下标的元素小于当前元素
            //栈中小于当前元素的元素下标全部出栈并修改它的值
            //然后放入当前元素下标，就形成了一个从栈底往栈顶的递减栈
            while(!stack.empty()&&list.get(stack.peek())<head.val){
                list.set(stack.pop(),head.val);
            }
            //将list的长度当作下标放入栈中
            stack.push(list.size());
            //向list中添加元素
            list.add(head.val);
        }
        //将没有找到比他大的元素设为0
        for(int i:stack){
            list.set(i,0);
        }
        //将列表转换为数组
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
//    public int[] nextLargerNodes(ListNode head) {
//        List<Integer> list = new ArrayList<>();
//        while(head!=null) {
//            list.add(head.val);
//            head = head.next;
//        }
//        Stack<Integer> stack = new Stack<>();
//        int[] result = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            //栈不为空 且 当前栈顶下标的元素小于当前元素
//            //栈中小于当前i下标元素的元素下标全部出栈并修改它的值
//            //然后放入i下标，就形成了一个从栈底往栈顶的递减栈
//            while(!stack.empty() && list.get(stack.peek())<list.get(i)){
//                result[stack.pop()] = list.get(i);
//            }
//            //元素的下标放入栈中
//            stack.push(i);
//        }
//        return result;
//    }
//    public int[] nextLargerNodes(ListNode head) {
//        //暴力求解
//        List<Integer> list = new ArrayList<>();
//        while(head!=null) {
//            list.add(head.val);
//            head = head.next;
//        }
//        int[] result = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = i+1; j < list.size(); j++) {
//                if(list.get(i)<list.get(j)){
//                    result[i] = list.get(j);
//                    break;
//                }
//            }
//        }
//        return result;
//    }
}
