package leetcode.linkedlist.环形链表II;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-10
 * Time: 0:31
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}
public class 环形链表II {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //快的一次走两步，慢的一次走一步
        //如果带环两个节点一定会相遇
        //有尾节点一定不带环
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            //相遇说明带环
            if(fast==slow){
               //将一个节点拉至头节点
                slow = head;
                while(fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
                }
                //再次相遇则说明相遇节点是入环节点，返回
                return slow;
            }
        }
        //返回空说明没有环
        return null;
    }
}
