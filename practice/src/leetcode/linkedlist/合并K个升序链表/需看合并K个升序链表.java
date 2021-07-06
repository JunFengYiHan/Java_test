package leetcode.linkedlist.合并K个升序链表;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-11
 * Time: 14:04
 */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class 需看合并K个升序链表 {
        //链接：https://leetcode-cn.com/problems/merge-k-sorted-lists/
    public ListNode merge (ListNode l1,ListNode l2){
        ListNode head = new ListNode();
        ListNode tmp = head;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                tmp.next = l1;
                l1 = l1.next;
            }else{
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        if(l1==null){
            tmp.next = l2;
        }
        if(l2==null){
            tmp.next = l1;
        }
        return head.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null) return null;
        if(lists.length<2) return lists[lists.length - 1];
        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = merge(result,lists[i]);
        }
        return result;
    }
}
