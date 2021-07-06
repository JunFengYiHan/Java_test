package leetcode.linkedlist.交换链表中的节点;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-21
 * Time: 0:18
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class 交换链表中的节点 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left = head;//第k个节点
        ListNode right = head;//倒数第k个节点
        ListNode tmp = head;
        //题目保证k不会超过链表长度
        //且索引从1开始
//        int len = 0;
//        while(tmp!=null) {
//            len++;
//            tmp = tmp.next;
//        }
//        if(k<0||k>len) {
//            return head;
//        }
//        tmp = head;
        //让left指向第k个节点
        while(k>1) {
            k--;
            left = left.next;
            tmp = tmp.next;
        }
        //让right指向倒数第k个节点
        while(tmp.next!=null) {
            tmp = tmp.next;
            right = right.next;
        }
        //交换两个节点的值
        int val = left.val;
        left.val = right.val;
        right.val = val;
        return head;
    }
}
