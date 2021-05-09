/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-07
 * Time: 22:07
 */

class ListNode{
    int val;//值
    ListNode next;//下一个节点地址，形成链表
    //构造方法
    public ListNode(){}
    public ListNode(int val){
        this.val = val;
    }
}
public class MyLinkedList {
    public ListNode head;//记录当前链表的头节点

    //头插
    public void addFirst(int val){
        ListNode node = new ListNode(val);
//        if(head == null){
//            head = node;
//            return;
//        }
        node.next = head;
        head = node;
    }
    //尾插
    public void addLast(int val){
        ListNode node = new ListNode(val);
        ListNode tmp = this.head;
        if(head == null){
            head = node;
            return;
        }
        while(tmp.next!=null){
            tmp = tmp.next;
        }
        tmp.next = node;
    }
    //返回指定位置的前一个节点
    private ListNode findIndexSubOne(int index){
        ListNode tmp = this.head;

        while(index - 1> 0){
            tmp = tmp.next;
            index--;
        }
        return tmp;
    }
    //求链表长度
    public int size(){
        int count = 0;
        ListNode tmp = head;
        while(tmp!=null){
            tmp = tmp.next;
            count++;
        }
        return count;
    }
    //指定位置插入，0为开始下标
    public void addIndex(int index,int val){
        if(index<0||index>this.size()){
            System.out.println("插入位置非法");
            return;
        }
        if(index == 0){
            this.addFirst(val);
            return;
        }
        if(index==size()){
            this.addLast(val);
            return;
        }
        ListNode node = new ListNode(val);
        ListNode tmp = this.findIndexSubOne(index);
        node.next = tmp.next;
        tmp.next = node;

    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode tmp = this.head;
        while(tmp != null){
            if(tmp.val == key){
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        ListNode tmp = this.head;
        if(this.head == null){
            System.out.println("该链表为空!");
            return;
        }
        if(this.head.val == key){
            this.head = this.head.next;
            return;
        }
        while(tmp.next != null && tmp.next.val!=key){
            tmp = tmp.next;
        }
        if(tmp.next==null){
            System.out.println("该链表中不存在"+key);
        }else{
            tmp.next = tmp.next.next;
        }

    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode node = this.head;
        ListNode del = this.head;
        if(this.head ==null){
            System.out.println("该链表为空");
        }
        while(del != null){
            while(del!=null && del.val!=key){
                node = del;
                del = del.next;
            }
            if(del!=null){
                node.next = del.next;
                del = del.next;
            }
        }
        if(this.head.val == key){
            this.head = this.head.next;
        }
        System.out.println(key+"删除完成！");
    }
    //清空链表
    public void clear(){
        while(this.head!=null){
            ListNode tmp = this.head.next;
            this.head = null;
            this.head = tmp;
        }
        System.out.println("该链表已清空！");
    }
    //打印链表内容
    public void display(){
        ListNode tmp = head;
        if(head == null){
            System.out.println("该链表为空");
        }
        while(tmp != null){
            System.out.print(tmp.val+" ");
            tmp = tmp.next;
        }
    }
}
