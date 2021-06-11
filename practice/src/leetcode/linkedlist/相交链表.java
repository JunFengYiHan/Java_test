//package leetcode;
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
//
//        while(fast!=null){
//            fast = fast.next;
//            countA++;
//        }
//        while(slow!=null) {
//            slow = slow.next;
//            countB++;
//        }
//        int count = 0;
//        if(countA>countB){
//            count = countA-countB;
//            fast = headA;
//            slow = headB;
//        }else{
//            count = countB-countA;
//            fast = headB;
//            slow = headA;
//        }
//        while(count>0){
//            fast = fast.next;
//            count--;
//        }
//        while(fast!=slow){
//            fast = fast.next;
//            slow = slow.next;
//        }
//        return fast;
//    }
//}
