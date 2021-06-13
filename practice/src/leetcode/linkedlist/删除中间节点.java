//package leetcode.linkedlist;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-13
// * Time: 23:15
// */
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}
//public class 删除中间节点 {
//    public void deleteNode(ListNode node) {
//        //取下一个节点的值，赋值给当前节点
//        //然后跳过下一个节点，形成删除当前节点的效果
//        node.val = node.next.val;
//        node.next = node.next.next;
//    }
//}
