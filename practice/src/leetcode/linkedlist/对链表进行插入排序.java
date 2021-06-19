//package leetcode.linkedlist;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-20
// * Time: 0:21
// */
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}
//public class 对链表进行插入排序 {
//    public ListNode insertionSortList(ListNode head) {
//        //没有节点和1个节点直接返回
//        if(head==null||head.next==null) return head;
//        //将原链表插入排序到傀儡节点后面
//        ListNode dummyNode = new ListNode(-1,head);
//        ListNode tail = head;
//        ListNode cur = head.next;
//        while(cur!=null) {
//            //有序，直接往后走一步
//            if(tail.val<=tail.next.val) {
//                tail = tail.next;
//            }else{
//                ListNode prev = dummyNode;
//                //找到需要插入位置的前驱节点
//                while(prev.next.val<=cur.val){
//                    prev = prev.next;
//                }
//                //先绑定后续节点防止链表断裂
//                //然后没有排序的元素串在已排序好的后面
//                //最后将节点插入到指定位置
//                tail.next = cur.next;
//                cur.next = prev.next;
//                prev.next = cur;
//            }
//            //cur一直为排序好元素的下一个元素
//            cur = tail.next;
//        }
//        return dummyNode.next;
//    }
////    public ListNode insertionSortList(ListNode head) {
////        //没有节点和1个节点直接返回
////        if(head==null||head.next==null) return head;
////        //将原链表插入排序到傀儡节点后面
////        ListNode dummyNode = new ListNode(-1,head);
////        ListNode prev = dummyNode;
////        ListNode cur;
////        //用于遍历链表
////        ListNode tmp = head.next;
////        ListNode tmpNext;
////        ListNode tail = head;
////        //遍历原链表
////        while(tmp!=null) {
////            cur = prev.next;
////            tmpNext = tmp.next;//防止原链表断开
////            //遍历排序好的链表，找到插入位置
////            while(cur!=null&&tmp.val>cur.val) {
////                cur = cur.next;
////                prev = prev.next;
////            }
////            //判断尾节点是否需要更新
////            if(prev==tail) tail = tmp;
////            //插入节点
////            tmp.next = prev.next;
////            prev.next = tmp;
////            prev = dummyNode;
////            tmp = tmpNext;//更新tmp
////            tail.next = null;//将当前尾节点的指向置为null
////        }
////        return dummyNode.next;
////    }
//}
