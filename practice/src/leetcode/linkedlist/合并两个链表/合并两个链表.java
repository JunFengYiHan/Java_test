package leetcode.linkedlist.合并两个链表;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-24
 * Time: 21:50
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class 合并两个链表 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        //防止出现删除头节点的情况
        ListNode dummy = new ListNode(-1,list1);
        ListNode prev = dummy;
        ListNode tail = dummy;
        int n = a;
        //找到删除区间的前一个节点和后一个节点
        while(a>0){
            prev = prev.next;
            a--;
        }
        tail = prev;
        while(b-n+2>0){
            tail = tail.next;
            b--;
        }
        //串连list2
        prev.next = list2;
        //找到尾节点
        while(prev.next!=null) {
            prev = prev.next;
        }
        //串联list1剩下的节点
        prev.next = tail;
        return dummy.next;
    }
//    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
//        //防止出现删除头节点的情况
//        ListNode dummy = new ListNode(-1,list1);
//        ListNode prev = dummy;
//        ListNode tail = dummy;
//        //找到删除区间的前一个节点
//        while(a>0){
//            prev = prev.next;
//            a--;
//        }
//        //找到删除区间的下一个节点
//        while(b+2>0) {
//            tail = tail.next;
//            b--;
//        }
//        //串连list2
//        prev.next = list2;
//        //找到尾节点
//        while(prev.next!=null) {
//            prev = prev.next;
//        }
//        //串联list1剩下的节点
//        prev.next = tail;
//        return dummy.next;
//    }
}
