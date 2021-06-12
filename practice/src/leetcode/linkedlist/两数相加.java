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
//            //不为空则取出值，为空则取0
//            int n1 = l1!=null?l1.val:0;
//            int n2 = l2!=null?l2.val:0;
//            sum = n1+n2+carry;//得到当前位的和
//            carry = sum/10;//得到当前位的进位
//            ListNode node = new ListNode(sum%10);//值放入新的节点
//            cur.next = node;//串成新的链表
//            cur = cur.next;
//            //不为空则继续往下走
//            l1 = l1!=null?l1.next:null;
//            l2 = l2!=null?l2.next:null;
//        }
//        //进位之后比原来的链表长，单独加一位
//        if(carry>0){
//            cur.next = new ListNode(carry);
//        }
//        return head;//返回新的链表头部
//    }
//}
