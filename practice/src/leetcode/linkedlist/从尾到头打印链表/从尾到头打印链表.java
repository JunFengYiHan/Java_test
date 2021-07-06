package leetcode.linkedlist.从尾到头打印链表;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-14
 * Time: 1:45
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
public class 从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        int len = 0;//数组长度
        ListNode tmp = head;
        //临时变量遍历链表，获得长度
        while(tmp!=null){
            len++;
            tmp = tmp.next;
        }
        //创建目标数组
        int[] array = new int[len];
        //再次遍历链表放入元素
        while(head!=null){
            array[--len] = head.val;
            head = head.next;
        }
        return array;
    }
//    public int[] reversePrint(ListNode head) {
//        Stack<Integer> stack = new Stack<>();//创建一个栈存放数据
//        //将链表元素放入栈中
//        while(head!=null){
//            stack.push(head.val);
//            head = head.next;
//        }
//        //创建一个对应长度的数组
//        int[] array = new int[stack.size()];
//        int count = 0;
//        //将数据放入数组中
//        while(!stack.empty()){
//            array[count++] = stack.pop();
//        }
//        //返回数组
//        return array;
//    }
}
