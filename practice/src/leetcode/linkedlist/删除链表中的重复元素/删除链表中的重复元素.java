package leetcode.linkedlist.删除链表中的重复元素;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-11
 * Time: 21:24
 */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class 删除链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;//头节点为空直接返回
        ListNode cur = head;
        //题目要求重复节点保留一个
        //有序链表
        while(cur.next!=null){
            if(cur.val==cur.next.val){
                //值相同则跳过下一个
                cur.next = cur.next.next;
            }else{
                //值不相同指向下一个
                cur = cur.next;
            }
        }
        return head;
    }
}
