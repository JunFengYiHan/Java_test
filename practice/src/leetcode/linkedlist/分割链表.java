//package leetcode.linkedlist;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-25
// * Time: 23:25
// */
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}
//public class 分割链表 {
//    public ListNode partition(ListNode head, int x) {
//        if(head==null) return null;
//        //4个节点形成两个链表
//        //s链表小于x
//        //e链表大于等于x
//        ListNode s1 = null;//头
//        ListNode s2 = null;//尾
//        ListNode e1 = null;//头
//        ListNode e2 = null;//尾
//        //将原链表分成两段
//        while(head!=null) {
//            if(head.val<x){
//                if(s1==null) {
//                    s1 = head;
//                }else{
//                    s2.next = head;
//                }
//                s2 = head;
//            }else{
//                if(e1==null) {
//                    e1 = head;
//                }else{
//                    e2.next = head;
//                }
//                e2 = head;
//            }
//            head = head.next;
//        }
//        //一段为空直接返回另一端
//        if(s1==null) {
//            return  e1;
//        }
//        if(e1==null) {
//            return s1;
//        }
//        //将大于等于x的串在小于x的后面
//        s2.next = e1;
//        //防止原来的尾节点小于x，不置空会形成环
//        e2.next = null;
//        return s1;
//    }
//}
