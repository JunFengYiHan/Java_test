//package 牛客;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-09
// * Time: 20:54
// */
//class ListNode {
//    int val;
//    ListNode next = null;
//
//    ListNode(int val) {
//        this.val = val;
//    }
//}
//public class 需练链表的回文结构 {
//    //还需要再熟悉一下 链接：https://www.nowcoder.com/practice/d281619e4b3e4a60a2cc66ea32855bfa?tpId=49&&tqId=29370&rp=1&ru=/activity/oj&qru=/ta/2016test/question-ranking
//    public boolean chkPalindrome(ListNode A) {
//        if(A==null) return false;
//
//        ListNode fast = A;
//        ListNode slow = A;
//        while(fast!=null&&fast.next!=null){
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        ListNode cur = slow.next;
//        ListNode curNext;
//        while(cur!=null){
//            curNext = cur.next;
//            cur.next = slow;
//            slow = cur;
//            cur = curNext;
//        }
//        while(A!=slow && A.next!=slow){
//
//            if(A.val!=slow.val) return false;
//
//            A = A.next;
//            slow = slow.next;
//        }
//        return true;
//    }
//}
