//package package leetcode.linkedlist;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-09
// * Time: 21:30
// */
//
//class ListNode {
//      int val;
//      ListNode next;
//      ListNode(int x) {
//          val = x;
//          next = null;
//      }
//  }
//public class 相交链表 {
//
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode fast = headA;
//        ListNode slow = headB;
//        int countA = 0;
//        int countB = 0;
//        //先求得两个链表的长度
//        while(fast!=null){
//            fast = fast.next;
//            countA++;
//        }
//        while(slow!=null) {
//            slow = slow.next;
//            countB++;
//        }
//        //两条链表的差值
//        int count = 0;
//        //长的赋值给fast
//        //短的赋值给slow
//        if(countA>countB){
//            count = countA-countB;
//            fast = headA;
//            slow = headB;
//        }else{
//            count = countB-countA;
//            fast = headB;
//            slow = headA;
//        }
//        //长的先走差值步
//        while(count>0){
//            fast = fast.next;
//            count--;
//        }
//        //如果相遇说明相交或遍历完了
//        while(fast!=slow){
//            fast = fast.next;
//            slow = slow.next;
//        }
//        //不管相不相交都可以返回fast，因为不相交最后两个节点都会为null
//        //相交返回相较节点，不相交返回null
//        return fast;
//    }
//}
