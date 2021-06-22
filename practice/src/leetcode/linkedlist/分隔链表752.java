//package leetcode.linkedlist;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-22
// * Time: 21:01
// */
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }
//public class 分隔链表752 {
//    public ListNode[] splitListToParts(ListNode head, int k) {
//        int len = 0;
//        ListNode tmp = head;
//        while(tmp!=null) {
//            len++;
//            tmp = tmp.next;
//        }
//        //算出额外的的节点
//        int extra = len%k;
//        //每一节的长度
//        int extent = len/k;
//        //创捷一个数组存储
//        ListNode[] result = new ListNode[k];
//        ListNode cur = head;//从当前头节点开始
//        for (int i = 0; i < k; i++) {
//            tmp = cur;        //需要减一，不然会多分一个节点，因为当前指向的节点也算在内
//            for (int j = 0; j < extent + (i<extra?1:0) - 1; j++) {
//                if(cur!=null) cur = cur.next;//不断后移
//            }
//            //不为空除了切断链接
//            if(cur!=null) {
//                ListNode prev = cur;
//                cur = cur.next;
//                prev.next = null;
//            }
//            //将当前部分的头放入数组中
//            result[i] = tmp;
//        }
//        return result;
//    }
//}
