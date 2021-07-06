package leetcode.linkedlist.两数相加II;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-20
 * Time: 23:50
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class 两数相加II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        //将两个链表分别存储到两个栈中
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while(l1!=null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while(l2!=null){
            stack2.push(l2);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode(-1);
        int carry = 0;
        //将对应的值加起来存储到对应节点
        while(!stack1.empty()||!stack2.empty()||carry>0) {
            //栈为空则直接取0，不为空弹出栈顶元素并取出该节点的的值
            int n1 = stack1.empty()?0:stack1.pop().val;
            int n2 = stack2.empty()?0:stack2.pop().val;
            int sum = n1+n2+carry;
            carry = sum/10;
            //使用头插法
            ListNode node = new ListNode(sum%10);
            node.next = dummy.next;
            dummy.next = node;
        }
        //返回当前头节点
        return dummy.next;
    }
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        //有一个链表为空直接返回
//        if(l1==null) return l2;
//        if(l2==null) return l1;
//        //将链表翻转
//        l1 = overturn(l1);
//        l2 = overturn(l2);
//        ListNode dummy = new ListNode(-1);
//        ListNode tmp = dummy;
//        int carry = 0;//进位
//        while(l1!=null||l2!=null) {
//            int n1 = l1==null?0:l1.val;
//            int n2 = l2==null?0:l2.val;
//            int sum = n1+n2+carry;
//            carry = sum/10;
//            tmp.next = new ListNode(sum%10);
//            tmp = tmp.next;
//            l1 = l1==null?null:l1.next;
//            l2 = l2==null?null:l2.next;
//        }
//        if(carry>0) {
//            tmp.next = new ListNode(carry);
//        }
//        //将串好的链表再次翻转
//        return overturn(dummy.next);
//    }
//    //翻转链表
//    public ListNode overturn(ListNode head) {
//        if(head==null||head.next==null) return head;
//        ListNode prev = null;
//        ListNode cur = head;
//        ListNode next;
//        while(cur!=null) {
//            next = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = next;
//        }
//        return prev;
//    }
}
