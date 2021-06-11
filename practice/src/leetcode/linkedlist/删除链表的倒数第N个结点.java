//package leetcode.linkedlist;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-11
// * Time: 12:53
// */
//class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}
//public class 删除链表的倒数第N个结点 {
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode target = head;
//        ListNode cur = head;
//        ListNode targetPrev = null;
//        //代码的健壮性
//        if(n<0) return head;
//
//        while(n>0){
//            if(cur==null) return head;
//            n--;
//            cur = cur.next;
//        }
//        while(cur!=null){
//            cur = cur.next;
//            targetPrev = target;
//            target = target.next;
//        }
//        if(targetPrev==null){
//            head = head.next;
//        }else{
//            targetPrev.next = target.next;
//        }
//        return head;
//    }
//}
