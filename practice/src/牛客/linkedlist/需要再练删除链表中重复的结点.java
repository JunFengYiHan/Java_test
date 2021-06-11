//package 牛客;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-09
// * Time: 19:53
// */
//class ListNode {
//    int val;
//    ListNode next = null;
//
//    ListNode(int val) {
//        this.val = val;
//    }
//}
//public class 删除链表中重复的结点 {
//    //还需要看一下，链接：https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&&tqId=11209&rp=1&ru=/activity/oj&qru=/ta/coding-interviews/question-ranking
//    public ListNode deleteDuplication(ListNode pHead) {
//        if(pHead==null||pHead.next==null) return pHead;
//        ListNode newHead = new ListNode(-1);
//        ListNode prev = newHead;
//        ListNode cur = pHead;
//        while(cur!=null){
//            if(cur.next!=null&&cur.val==cur.next.val){
//                while(cur.next!=null&&cur.val==cur.next.val){
//                    cur = cur.next;
//                }
//            }else{
//                prev.next = cur;
//                prev = cur;
//            }
//            cur = cur.next;
//        }
//        prev.next = null;
//        return newHead.next;
//    }
//}
