//package LeetCode;
//
//import java.util.List;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-07
// * Time: 19:57
// */
//
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}
//public class 移除链表元素 {
//    public ListNode removeElements(ListNode head, int val) {
//        ListNode newHead = new ListNode(-1);
//        ListNode cur = newHead;
//        while(head!=null){
//            if(head.val!=val){
//                cur.next = head;
//                cur = cur.next;
//            }
//            head = head.next;
//        }
//        return newHead.next;
//    }
//}
