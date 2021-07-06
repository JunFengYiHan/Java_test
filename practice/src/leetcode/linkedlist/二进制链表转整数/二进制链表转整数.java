package leetcode.linkedlist.二进制链表转整数;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-12
 * Time: 22:31
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
public class 二进制链表转整数 {
    public int getDecimalValue(ListNode head) {
        int num = 0;

        while(head!=null){
            //遍历链表，乘二加当前值
            num = (num<<1) + head.val;
            head = head.next;
        }
        return num;
    }
}
