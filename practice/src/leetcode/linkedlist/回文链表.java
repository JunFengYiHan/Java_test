//package leetcode.linkedlist;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-11
// * Time: 21:34
// */
//class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}
//public class 回文链表 implements Cloneable{
//    public boolean isPalindrome(ListNode head) {
//        //没有节点和一个节点直接返回true
//        if(head==null || head.next==null) return true;
//
//        ListNode fast = head;//一次两步
//        ListNode slow = head;//一次一步
//        ListNode slowPrev = slow;//slow的前一个节点
//        ListNode prevPrev = null;//slow的前一个节点的前一个节点即prevPrev，prev，slow
//        //一边遍历一边翻转前半部分链表
//        while(fast!=null&&fast.next!=null){
//            //遍历
//            fast = fast.next.next;
//            slow = slow.next;
//            //翻转
//            slowPrev.next = prevPrev;//翻转节点
//            prevPrev = slowPrev;//更新前一个节点为当前节点
//            slowPrev = slow;//指向slow
//        }
//        //记录中间节点
//        ListNode middle = slow;
//        //记录翻转后的头节点
//        slowPrev = prevPrev;
//        //奇数个节点，跳过中间节点
//        if(fast!=null){
//            slow = slow.next;
//        }
//        //从中间向两头走
//        //slow和prevPrev一样长所以会同时为空，判断一个是否为空就行
//        while(slow!=null){
//            if(slow.val!=prevPrev.val){
//                return false;
//            }
//            slow = slow.next;
//            prevPrev = prevPrev.next;
//        }
//        //将链表复原
//        while(slowPrev!=null){
//            prevPrev = slowPrev.next;//记录下一个待翻转的节点
//            slowPrev.next = middle;//翻转当前节点
//            middle = slowPrev;//更新前一个节点
//            slowPrev = prevPrev;//指向下一个待翻转的节点
//        }
//        return true;
//    }
////    public boolean isPalindrome(ListNode head) {
////        ListNode fast = head;
////        ListNode slow = head;
////        //得到中间节点
////        while(fast!=null&&fast.next!=null){
////            fast = fast.next.next;
////            slow = slow.next;
////        }
////        //反转后半部分节点
////        ListNode cur = slow.next;
////        ListNode curNext;
////        while(cur!=null){
////            curNext = cur.next;
////            cur.next = slow;
////            slow = cur;
////            cur =curNext;
////        }
////        //两个指针未相遇则继续
////        while(head!=slow&&head.next!=slow){
////
////            if(head.val!=slow.val) return false;
////
////            head = head.next;
////            slow = slow.next;
////        }
////        //返回true会导致两个节点时一定为true
////        //return true;
////        return head.val == slow.val;
////    }
//}
