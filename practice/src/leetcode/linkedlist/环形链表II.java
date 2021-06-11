//package leetcode.linkedlist;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-10
// * Time: 0:31
// */
//class ListNode {
//      int val;
//      ListNode next;
//      ListNode(int x) {
//          val = x;
//          next = null;
//      }
//}
//public class 环形链表II {
//    public ListNode detectCycle(ListNode head) {
//        ListNode fast = head;
//        ListNode slow = head;
//        while(fast!=null && fast.next!=null){
//            fast = fast.next.next;
//            slow = slow.next;
//            if(fast==slow){
//                slow = head;
//                while(fast!=slow){
//                    fast=fast.next;
//                    slow=slow.next;
//                }
//                return slow;
//            }
//        }
//        return null;
//    }
//}
