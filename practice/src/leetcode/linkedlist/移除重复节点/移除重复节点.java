package leetcode.linkedlist.移除重复节点;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-13
 * Time: 0:49
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }
public class 移除重复节点 {
    public ListNode removeDuplicateNodes(ListNode head) {
        //时间复杂度太高 O(N^2)/O(1)
        ListNode prev = head;//prev指向head
        while(prev!=null){
            ListNode cur = prev;//cur指向prev
            while(cur.next!=null){
                //cur.next和prev进行值的比较
                if(cur.next.val==prev.val){
                    //跳过下一个节点
                    cur.next = cur.next.next;
                }else{
                    //指向下一个节点
                    cur = cur.next;
                }
            }
            prev = prev.next;
        }
        return head;
    }
//    public ListNode removeDuplicateNodes(ListNode head) {
//        //空间复杂度较高O(N)/O(N)，比较优的解法
//        if(head==null||head.next==null) return head;
//
//        Set<Integer> set = new HashSet<>();
//        set.add(head.val);//添加第一个节点的值
//        ListNode tmp = head;
//        while(tmp.next!=null){
//            //添加下一个节点的值，添加成功返回true
//            //说明该节点没有重复，不需要删除
//            //false说明需要删除，则跳过该节点
//            if(set.add(tmp.next.val)){
//                tmp = tmp.next;
//            }else{
//                tmp.next = tmp.next.next;
//            }
//        }
//        tmp.next = null;
//        return head;
//    }
}
