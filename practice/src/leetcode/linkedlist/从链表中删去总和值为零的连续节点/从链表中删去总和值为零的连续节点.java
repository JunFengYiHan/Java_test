package leetcode.linkedlist.从链表中删去总和值为零的连续节点;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-24
 * Time: 21:17
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class 从链表中删去总和值为零的连续节点 {
    public ListNode removeZeroSumSubLists(ListNode head) {
        Map<Integer,ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(-1,head);
        ListNode tmp = dummy;
        int sum = 0;
        //将节点以 值-节点 的形式放入map中
        //map中会保存最后一次以当前值为key的节点
        while(tmp!=null) {
            sum+=tmp.val;
            map.put(sum,tmp);
            tmp = tmp.next;
        }
        sum = 0;
        tmp = dummy;
        //从傀儡节点开始，防止删除头节点的情况
        //再次遍历，将map中唯一的节点串起来
        while(tmp!=null) {
            sum+=tmp.val;
            //不存在时返回null结束循环，当前节点是不能取得
            //因为是后面覆盖前面，所以最后一个节点肯定在
            //最少就是一个傀儡节点，最多就全部节点都在
            tmp.next = map.get(sum).next;
            tmp = tmp.next;
        }
        return dummy.next;
    }
}
