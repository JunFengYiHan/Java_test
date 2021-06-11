//package 牛客;
//
//
//import java.util.Stack;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-07
// * Time: 20:40
// */
//
//class ListNode {
//    int val;
//    ListNode next = null;
//
//    ListNode(int val) {
//        this.val = val;
//    }
//}
//public class 链表中倒数第k个节点 {
//    //全部入栈，出栈得到倒数第k个节点
//    //记得导入包
//    public ListNode FindKthToTail(ListNode head, int k) {
//        Stack<ListNode> stack = new Stack<>();
//        int count = 0;//记录链表的长度
//        while(head!=null){
//            stack.push(head);
//            head = head.next;
//            count++;
//        }
//        //k非法直接返回null
//        if(k>count||k<=0) return null;
//        while(!stack.empty()&&k>1){
//            stack.pop();
//            k--;
//        }
//        return stack.pop();
//    }
////    public ListNode FindKthToTail(ListNode head, int k) {
////        //if(head==null) return null;
////        ListNode fast = head;
////        ListNode slow = head;
////        while(k>0){
////            //直接判断，防止链表为空
////            if(fast==null){//k过大直接返回null
////                return null;
////            }
////            fast = fast.next;
////            k--;
////        }
////        //同步向后走
////        while(fast!=null){
////            fast = fast.next;
////            slow = slow.next;
////        }
////        return slow;
////    }
//}
