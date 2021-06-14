//package leetcode.linkedlist;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-14
// * Time: 22:39
// */
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}
//public class 两两交换链表中的节点 {
//    public ListNode swapPairs(ListNode head) {
//        //加上可以提高效率，不加上也不影响
//        //if(head==null||head.next==null) return head;
//
//        ListNode newHead = new ListNode(-1,head);
//        ListNode prev = newHead;
//        ListNode cur = head;//第一个节点
//        ListNode curNext;
//        //是否存在两个待交换的节点
//        while(cur!=null&&cur.next!=null) {
//            curNext = cur.next;//第二个节点
//            cur.next = curNext.next;//先绑定第二个节点后面的节点
//            curNext.next = cur;//第二个节点指向第一个节点
//            prev.next = curNext;//串在傀儡节点的后面
//            prev = cur;//指向交换后的第二个节点
//            cur = cur.next;//更新第一个节点
//        }
//        return newHead.next;
//    }
////    public ListNode swapPairs(ListNode head) {
////        ListNode newHead = new ListNode(-1,head);//傀儡节点
////        ListNode prev = newHead;
////        //当待交换的节点不足两个节点时退出循环
////        //存在傀儡节点所以不必担心prev直接为空
////        while(prev.next!=null&&prev.next.next!=null) {
////            ListNode node1 = prev.next;//要交换的第一个节点
////            ListNode node2 = node1.next;//要交换的第二个节点
////
////            prev.next = node2;//指向第二个节点
////            node1.next = node2.next;//node1.next先绑定第node2.next防止后续节点丢失
////            node2.next = node1;//node2.next指向node1,完成交换
////            prev = node1;//指向交换后的后一个节点，相当于走两步
////        }
////        return newHead.next;
////    }
//}
