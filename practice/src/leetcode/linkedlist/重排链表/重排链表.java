package leetcode.linkedlist.重排链表;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-19
 * Time: 22:39
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class 重排链表 {
    public void reorderList(ListNode head) {
        //没有节点，1个节点，2个节点都不需要重排
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode fast = head;
        ListNode slow = head;
        //求得中间节点的前一个节点
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode cur = slow.next;//中间节点（奇数为最中间的后一个，偶数为后一个）
        slow.next = null;//断开两个链表的链接
        ListNode prev = null;//前驱节点
        ListNode next;//下一个节点
        //翻转后半部分的链表
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        //合并两个链表
        ListNode l1 = head;
        ListNode l2 = prev;
        ListNode l1Next;
        ListNode l2Next;
        //l1一定不比l2短，所以判断l2即可
        while (l2 != null) {
            l1Next = l1.next;
            l2Next = l2.next;
            l1.next = l2;
            l1 = l1Next;
            l2.next = l1;
            l2 = l2Next;
        }
    }
//    public void reorderList(ListNode head) {
//        //没有节点，1个节点，2个节点都不需要重排
//        if(head==null||head.next==null||head.next.next==null) return;
//        List<ListNode> list = new ArrayList<>();
//        ListNode tmp = head;
//        while(tmp!=null) {
//            list.add(tmp);
//            tmp = tmp.next;
//        }
//        int left = 0;
//        int right = list.size() - 1;
//        //left从最左开始，right从最右开始，往中间走
//        while(left<right) {
//            //将右边对应的节点串在左边的节点后面
//            list.get(left).next = list.get(right);
//            left++;//左往中间走一步
//            if(left==right) break;//left变了判断一下，相遇了，说明串联完了，终止循环
//            //将左边对应的节点串在右边节点后面
//            list.get(right).next = list.get(left);
//            right--;
//        }
//        //将当前的尾节点指向置为空，因为当前尾节点是之前的中间节点
//        list.get(left).next = null;
//    }
}
