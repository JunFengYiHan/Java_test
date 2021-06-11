//package leetcode.linkedlist;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-07
// * Time: 11:29
// */
//
//public class 两数相加 {
//    public class ListNode {
//        int val;
//        ListNode next;
//        ListNode() {}
//        ListNode(int val) { this.val = val; }
//        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//    }
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode head = new ListNode(-1);
//        ListNode cur = head;
//        int sum = 0;
//        int carry = 0;//进位
//        while(l1!=null||l2!=null){
//            int n1 = l1!=null?l1.val:0;
//            int n2 = l2!=null?l2.val:0;
//            sum = n1+n2+carry;
//            carry = sum/10;
//            ListNode node = new ListNode(sum%10);
//            cur.next = node;
//            cur = cur.next;
//            l1 = l1!=null?l1.next:null;
//            l2 = l2!=null?l2.next:null;
//        }
//        if(carry>0){
//            cur.next = new ListNode(carry);
//        }
//        return head;
//    }
//}
