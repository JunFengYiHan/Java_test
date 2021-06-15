//package leetcode.linkedlist;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-16
// * Time: 0:29
// */
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}
//public class 需练删除排序链表中的重复元素II {
////    public ListNode deleteDuplicates(ListNode head) {
////        if(head==null||head.next==null) return head;
////
////        ListNode dummyNode = new ListNode(-1,head);
////        ListNode prev = dummyNode;
////        while(head!=null){
////            if(head.next==null||head.val!=head.next.val){
////                prev.next = head;
////                prev = head;
////            }//else{
////                while(head.next!=null&&head.val==head.next.val){
////                    head = head.next;
////                //}
////            }
////            head = head.next;
////        }
////        prev.next = null;
////        return dummyNode.next;
////    }
//    public ListNode deleteDuplicates(ListNode head) {
//        //链表为空，或者只有一个节点，直接返回
//        if(head==null||head.next==null) return head;
//        //傀儡节点
//        ListNode newHead = new ListNode(-1,head);
//        ListNode prev = newHead;
//        ListNode cur = head;//直接用head遍历也可以
//        while(cur!=null) {
//            //下一个节点不为空，且是重复的节点则开始删除
//            if(cur.next!=null&&cur.val==cur.next.val){
//                //跳过所有重复的节点
//                while(cur.next!=null&&cur.val==cur.next.val) {
//                    cur = cur.next;
//                }
//                //到这里指向最后一个重复的节点
//            }else{
//                prev.next = cur;
//                prev = cur;
//            }
//            //不管有没有删除都需要跳过当前节点
//            cur = cur.next;
//        }
//        prev.next=null;
//        return newHead.next;
//    }
//}
