package leetcode.linkedlist.旋转链表;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-15
 * Time: 23:33
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class 旋转链表 {
//    public ListNode rotateRight(ListNode head, int k) {
//        ListNode tmp = head;
//        int len = 0;
//        //求链表的长度
//        while(tmp!=null){
//            len++;
//            tmp = tmp.next;
//        }
//        k%=len;//防止k过大重复旋转
//        if(k==0) return head;//只有一个节点 or k为len的倍数不需要旋转
//        ListNode fast = head;
//        ListNode slow = head;
//        while(k-->0) fast = fast.next;//先走k步
//        //fast走到最后一个节点，slow则刚好走到倒数第k+1个节点
//        while(fast.next!=null){
//            fast = fast.next;
//            slow = slow.next;
//        }
//        fast.next = head;//尾指向头，连成环
//        ListNode newHead = slow.next;//记录新的头节点
//        slow.next = null;//从新的头节点处断开环，形成新的链表
//        return newHead;
//    }
    public ListNode rotateRight(ListNode head, int k) {
        ListNode newHead = new ListNode(-1,head);
        int len = 0;//链表长度
        ListNode tmp = head;
        ListNode prev = null;
        while(tmp!=null){
            prev = tmp;
            tmp = tmp.next;
            len++;
        }
        //节点个数小于等于1，是否旋转结果都一样，直接返还
        if(len<=1) return head;
        //防止k过大反复旋转
        k%=len;
        if(k==0) return head;//k为len的倍数不需要旋转
        //先构成环
        prev.next = head;
        tmp = newHead;
        //找到旋转节点的前一个结点
        for (int i = 0; i < len - k ; i++) {
            tmp = tmp.next;
        }
        //获得新的头
        newHead.next = tmp.next;
        tmp.next=null;//断开环
        return newHead.next;
    }
}
