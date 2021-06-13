//package leetcode.linkedlist;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-09
// * Time: 21:30
// */
//
//class ListNode {
//      int val;
//      ListNode next;
//      ListNode(int x) {
//          val = x;
//          next = null;
//      }
//  }
//public class 链表相交 {
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode l1 = headA;
//        ListNode l2 = headB;
//        while(l1!=l2){
//            //A长度为 a, B长度为b， 假设存在交叉点，此时 A到交叉点距离为 c， 而B到交叉点距离为d
//            //后续交叉后长度是一样的，那么就是 a-c = b-d -> a+d = b+c
//            //这里意味着只要分别让A和B额外多走一遍B和A，
//            //那么必然会走到交叉，注意这里边缘情况是，
//            //大家都走到null依然没交叉，那么正好返回null即可
//            l1 = l1!=null?l1.next:headB;
//            l2 = l2!=null?l2.next:headA;
//        }
//        return l1;
//    }
//
////    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
////        ListNode fast = headA;
////        ListNode slow = headB;
////        int countA = 0;
////        int countB = 0;
////        //先求得两个链表的长度
////        while(fast!=null){
////            fast = fast.next;
////            countA++;
////        }
////        while(slow!=null) {
////            slow = slow.next;
////            countB++;
////        }
////        //两条链表的差值
////        int count = 0;
////        //长的赋值给fast
////        //短的赋值给slow
////        if(countA>countB){
////            count = countA-countB;
////            fast = headA;
////            slow = headB;
////        }else{
////            count = countB-countA;
////            fast = headB;
////            slow = headA;
////        }
////        //长的先走差值步
////        while(count>0){
////            fast = fast.next;
////            count--;
////        }
////        //如果相遇说明相交或遍历完了
////        while(fast!=slow){
////            fast = fast.next;
////            slow = slow.next;
////        }
////        //不管相不相交都可以返回fast，因为不相交最后两个节点都会为null
////        //相交返回相较节点，不相交返回null
////        return fast;
////    }
//}
