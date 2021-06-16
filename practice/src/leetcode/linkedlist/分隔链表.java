//package leetcode.linkedlist;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-16
// * Time: 20:46
// */
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }
//public class 分隔链表 {
//    public ListNode partition(ListNode head, int x) {
//        ListNode smallHead = new ListNode();
//        ListNode largeHead = new ListNode();
//        ListNode small = smallHead;
//        ListNode large = largeHead;
//        while(head!=null) {
//            if(head.val<x){
//                small.next = head;
//                small = head;
//            }else{
//                large.next = head;
//                large = head;
//            }
//            head = head.next;
//        }
//        large.next = null;
//        small.next = largeHead.next;
//        return smallHead.next;
//    }
////    public ListNode partition(ListNode head, int x) {
////        ListNode s1 = null;
////        ListNode s2 = null;
////        ListNode e1 = null;
////        ListNode e2 = null;
////        //将一条链表分为两条，小于x的一条，其余的一条
////        //创建四个引用，指向新建的两条链表的头尾
////        while(head!=null){
////            if(head.val<x){
////                if(s1==null){
////                    s1 = head;
////                }else{
////                    s2.next = head;
////                }
////                s2 = head;
////            }else{
////                if(e1==null){
////                    e1 = head;
////                }else{
////                    e2.next=head;
////                }
////                e2 = head;
////            }
////            head = head.next;
////        }
////        //如果小于x的链表为空，直接返回另外一条
////        if(s1==null) return e1;
////        //将大于等于x的那一条链表串在小于x的后面
////        s2.next = e1;
////        //如果大于等于x的那条链表不为空，则要将尾置为null防止成环
////        if(e1!=null) e2.next = null;
////        return s1;
////    }
//}
