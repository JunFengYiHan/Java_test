//package leetcode.linkedlist;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-07
// * Time: 20:19
// */
//class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }
//public class 反转链表 {
//    public ListNode reverseList(ListNode head) {
//        // if(head == null){
//        //     return null;
//        // }
//        ListNode prev = null;
//        ListNode cur = head;
//        //从头开始遍历链表，不需要单独判断头是不是为空
//        while(cur != null) {
//            ListNode curNext = cur.next;//在循环里面使用防止空指针异常
//            cur.next = prev;//反转，指向前一个节点
//            prev = cur;//更新前一个节点
//            cur = curNext;//指向未反转的下一个节点
//        }
//        return prev;
//    }
////    public ListNode reverseList(ListNode head) {
////        //链表为空不需要反转
////        if(head==null) return null;
////
////        ListNode cur = head;
////        ListNode curNext = head.next;
////        cur.next = null;//头的next置为空,变成尾节点
////        cur = curNext;//cur指向第二个节点
////        //遍历整个链表
////        while(cur!=null){
////            curNext = cur.next;//curNext指向cur的下一个节点
////            cur.next = head;//指向前一个节点，head为最前的节点
////            head = cur;//更新前一个节点
////            cur = curNext;//cur指向下一个节点
////        }
////        return head;
////    }
//}
