//package leetcode.linkedlist;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-14
// * Time: 2:10
// */
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}
//public class 链表中倒数第k个节点 {
//    //还可以利用栈来做
//    public ListNode getKthFromEnd(ListNode head, int k) {
//        ListNode fast = head;
//        ListNode slow = head;
//        while(k>0){
//            if(fast==null) return null;
//            fast = fast.next;
//            k--;
//        }
//        while(fast!=null){
//            fast = fast.next;
//            slow = slow.next;
//        }
//        return slow;
//    }
//}
