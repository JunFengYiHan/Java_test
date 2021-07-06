package leetcode.linkedlist.移除链表元素;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-07
 * Time: 19:57
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class 移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(-1);//傀儡头节点
        ListNode cur = newHead;
        //遍历整个链表
        while(head!=null){
            //不相同则将节点串在傀儡节点后面
            if(head.val!=val){
                cur.next = head;
                cur = cur.next;
            }
            head = head.next;
        }
        //返回需要的链表头节点
        return newHead.next;
    }
}
