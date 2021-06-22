package leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-22
 * Time: 21:30
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class 链表组件 {
    public int numComponents(ListNode head, int[] nums) {
        //创建一个集合
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ListNode cur = head;
        int count = 0;
        while(cur!=null) {
            //判断当前元素是否在集合中，下一个元素是不是在集合中
            //如果当前元素在，且下一个元素不在则说明是一个组件
            if(set.contains(cur.val)&&(cur.next==null||!set.contains(cur.next.val)))
                count++;
            cur = cur.next;
        }
        return count;
    }
}
