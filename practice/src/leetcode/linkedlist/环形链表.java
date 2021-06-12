//package leetcode.linkedlist;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-10
// * Time: 0:26
// */
//class ListNode {
//      int val;
//      ListNode next;
//      ListNode(int x) {
//          val = x;
//          next = null;
//      }
//}
//public class 环形链表 {
//    public boolean hasCycle(ListNode head) {
//        ListNode fast = head;
//        ListNode slow = head;
//        //快的一次走两步，慢的一次走一步
//        //如果带环两个节点一定会相遇
//        //有尾节点一定不带环
//        while(fast!=null&&fast.next!=null){
//            fast = fast.next.next;
//            slow = slow.next;
//            if(fast==slow) return true;
//        }
//        return false;
//    }
//}
