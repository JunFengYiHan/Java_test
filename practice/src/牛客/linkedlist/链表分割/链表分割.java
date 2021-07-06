package 牛客.linkedlist.链表分割;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-07
 * Time: 21:19
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class 链表分割 {
    public ListNode partition(ListNode pHead, int x) {
        ListNode a1 = null;//小于x，头
        ListNode a2 = null;//小于x，尾
        ListNode b1 = null;//大于x，头
        ListNode b2 = null;//大于x，尾
        //串成两个链表，题目保证输入链表升序
        while(pHead!=null){
            if(pHead.val<x){
                if(a1==null){
                    a1=pHead;
                    a2=pHead;
                }else{
                    a2.next=pHead;
                    a2 = a2.next;
                }
            }else{
                if(b1==null){
                    b1=pHead;
                    b2=pHead;
                }else{
                    b2.next=pHead;
                    b2 = b2.next;
                }
            }
            pHead = pHead.next;
        }
        if(a1==null) return b1;//不存在比x小的直接返回大于x的链
        if(b1!=null) b2.next = null;//将尾节点的next置为空

        a2.next = b1;//将大于x的链串到小于x的链后面
        return a1;
    }
}
