//package leetcode.linkedlist;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-07
// * Time: 21:11
// */
//
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }
//public class 合并两个有序链表 {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode head = new ListNode(-1);//傀儡头节点
//        ListNode cur = head;
//        while(l1!=null&&l2!=null){
//            //根据大小顺序串在傀儡节点后面
//            if(l1.val<l2.val){
//                cur.next = l1;
//                l1 = l1.next;
//            }else {
//                cur.next = l2;
//                l2 = l2.next;
//            }
//            cur = cur.next;
//        }
//        //处理一长一短的情况
//        if(l1==null){
//            cur.next = l2;
//        }
//        if(l2==null){
//            cur.next = l1;
//        }
//        //返回傀儡节点的下一个节点
//        return head.next;
//    }
//}
