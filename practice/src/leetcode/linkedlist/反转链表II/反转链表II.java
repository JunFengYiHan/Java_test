package leetcode.linkedlist.反转链表II;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-13
 * Time: 23:38
 */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class 反转链表II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //利用栈的特性来完成翻转
        Stack<ListNode> stack = new Stack<>();
        ListNode newHead = new ListNode(-1,head);
        ListNode prev = newHead;
        for(int i=0;i<left-1;i++){
            prev = prev.next;
        }
        ListNode tmp = prev;//利用临时变量来遍历
        //放入需要翻转的部分
        for(int i=0;i< right-left+1;i++){
            stack.add(tmp.next);
            tmp = tmp.next;
        }
        ListNode next = tmp.next;//保存翻转区间的下一个节点防止丢失
        //取出节点进行串联，完成翻转
        while(!stack.empty()){
            prev.next = stack.pop();
            prev = prev.next;
        }
        prev.next = next;//串联翻转区间后面的节点
        return newHead.next;
    }
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        //重合节点不需要翻转
//        //只需要一次遍历即可
//        if(left==right) return head;
//        ListNode newHead = new ListNode(-1,head);//傀儡头节点
//        ListNode leftPrev = newHead;
//        int tmp = left;
//        //找到待翻转的左节点的前一个节点
//        while(tmp>1){
//            leftPrev = leftPrev.next;
//            tmp--;
//        }
//        ListNode cur = leftPrev.next;//当前待翻转节点
//        ListNode curNext;//待翻转节点的下一个节点
//        //一边遍历一遍翻转
//        //取当前节点的下一个节点进行"头插"
//        //插入在leftPrev的后面
//        for (int i = 0; i < right-left; i++) {
//            curNext = cur.next;//取到下一个节点
//            cur.next = curNext.next;//链表中删除下一个节点
//            curNext.next = leftPrev.next;//绑定前一个节点的next
//            leftPrev.next = curNext;//更新前一个节点的next完成头插
//        }
//        return newHead.next;//返回当前头节点
//    }
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        //最坏需要遍历两次链表left和right在两端时
//        //重合节点不需要翻转
//        if(left==right) return head;
//        ListNode newHead = new ListNode(-1,head);//傀儡头节点
//        ListNode leftPrev = newHead;//翻转的左节点的前一个节点
//        ListNode rightNext = head;//翻转的右节点的下一个节点
//        //求的leftPrev
//        while(left>1){
//            left--;
//            leftPrev = leftPrev.next;
//        }
//        //求得rightNext
//        while(right>0){
//            right--;
//            rightNext = rightNext.next;
//        }
//        //从前往后翻转（从左往右翻转）
//        ListNode cur = leftPrev.next;//当前需要翻转的节点
//        ListNode curNext;//cur的下一个节点
//        ListNode curPrev = rightNext;//翻转后的尾节点
//        while(cur!=rightNext){
//            curNext = cur.next;//保存下一个待翻转的节点
//            cur.next = curPrev;//当前节点的next指向前一个节点
//            curPrev = cur;//更新前一个节点为当前节点
//            cur = curNext;//当前节点指向下一个节点
//        }
//        //将翻转之后的头节点串在没翻转的后面
//        //因为带傀儡头节点，所以不需要考虑头节点是否翻转
//        leftPrev.next = curPrev;
//
//        return newHead.next;//返回当前头节点
//    }
}
