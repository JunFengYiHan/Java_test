package leetcode.linkedlist.奇偶链表;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-18
 * Time: 22:47
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class 奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
        //没有节点，一个节点，两个节点都不需要修改
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode odd = head;//奇节点的头
        ListNode even = head.next;//偶节点的头
        ListNode cur = even.next;//从第三个结点开始遍历链表
        ListNode oddCur = odd;
        ListNode evenCur = even;
        boolean flag = true;//
        while (cur != null) {
            if (flag) {
                oddCur.next = cur;
                oddCur = cur;
                flag = false;
            } else {
                evenCur.next = cur;
                evenCur = cur;
                flag = true;
            }
            cur = cur.next;
        }
        //将偶节点串到奇节点
        oddCur.next = even;
        //将尾节点指向置为空
        evenCur.next = null;
        return odd;
    }
}
