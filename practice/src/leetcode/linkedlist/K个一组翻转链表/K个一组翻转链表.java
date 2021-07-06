package leetcode.linkedlist.K个一组翻转链表;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-27
 * Time: 18:14
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class K个一组翻转链表 {
//    public ListNode reverseKGroup(ListNode head, int k) {
//          还需要完善
//        ListNode dummy = new ListNode(-1,head);
//        ListNode prev = dummy;
//        ListNode tail = dummy;
//        while(head!=null) {
//            for (int i = 0; i < k; i++) {
//                tail = tail.next;
//                if(tail==null) {
//                    return dummy.next;
//                }
//            }
//            ListNode next = tail.next;
//            prev.next = overturn(prev.next,tail.next);
//            prev = head;
//            head = next;
//        }
//        prev.next=null;
//        return dummy.next;
//    }
//    public ListNode overturn(ListNode l1,ListNode l2) {
//        ListNode prev = null;
//        ListNode cur = l1;
//        while(cur!=l2) {
//            ListNode next = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = next;
//        }
//        return prev;
//    }
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while(head!=null) {
            stack.push(head);
            if(stack.size()==k) {
                //栈中节点到达k个链表翻转这部分链表
                head = head.next;
                while(!stack.empty()){
                    prev.next = stack.pop();
                    prev = prev.next;
                }
            }else{
                head = head.next;
            }
        }
        //将栈中不足k个的节点翻转回来
        Stack<ListNode> tmpStack = new Stack<>();
        while(!stack.empty()){
            tmpStack.push(stack.pop());
        }
        while(!tmpStack.empty()) {
            prev.next = tmpStack.pop();
            prev = prev.next;
        }
        //防止形成环
        prev.next=null;
        return dummy.next;
    }
}
