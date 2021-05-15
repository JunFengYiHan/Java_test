/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-15
 * Time: 16:25
 */
class ListNode{
    int val;
    ListNode prev;
    ListNode next;

    public ListNode(int val){
        this.val = val;
    }
}
public class MyLinkedList {
    ListNode head = new ListNode(-1);
    ListNode last;

    public void addFirst(int data){
        ListNode listNode = new ListNode(data);
        if(this.head.next == null){
            this.head.next = listNode;
            listNode.prev = this.head;
            this.last = listNode;
            return;
        }
        listNode.prev = this.head;
        listNode.next = this.head.next;
        this.head.next.prev = listNode;
        this.head.next = listNode;
    }
    public void addLast(int data){
        ListNode listNode = new ListNode(data);
        if(this.head.next == null){
            this.head.next = listNode;
            listNode.prev = this.head;
            this.last = listNode;
            return;
        }
        this.last.next = listNode;
        listNode.prev = this.last;
        this.last = listNode;
    }
    public int size(){
        ListNode tmp = this.head.next;
        int count = 0;
        while(tmp != null){
            count++;
            tmp = tmp.next;
        }
        return count;
    }
    public void addIndex(int index,int data){
        if(index<0 || index >this.size()){
            System.out.println("index位置不合法！");
            return;
        }
        if(index == 0){
            this.addFirst(data);
            return;
        }
        if(index == this.size()){
            this.addLast(data);
            return;
        }
        ListNode listNode = new ListNode(data);
        ListNode cur = this.head.next;
        while(index != 0){
            cur = cur.next;
            index--;
        }
        listNode.next = cur;
        listNode.prev = cur.prev;
        cur.prev.next = listNode;
        cur.prev = listNode;
    }
    public boolean contains(int data){
        ListNode cur = this.head.next;
        while(cur != null){
            if(cur.val == data){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public void removeFirstData(int data){
        ListNode cur = this.head.next;
        if(this.head.next == null) {
            System.out.println("该链表为空！");
        }
        while(cur != null){
            if(cur.val == data){
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                if(cur == this.last){
                    this.last = cur.prev;
                }
                return;
            }
            cur = cur.next;
        }
        System.out.println("链表中不存在" + data);
    }
    public void removeAllData(int data){
        if(this.head.next == null){
            System.out.println("该链表为空！");
        }
        ListNode cur = this.head.next;
        while(cur != null){
            if(cur.val == data){
                cur.prev.next = cur.next;
                if(cur.next != null){
                    cur.next.prev = cur.prev;
                }else{
                    last = cur.prev;
                }
            }
            cur = cur.next;
        }
    }
    public void clear(){
        ListNode cur = this.head.next;
        while(cur != null){
            cur.prev.next = null;
            cur = cur.next;
        }
        this.last = null;
        System.out.println("该链表已清空！");
    }
    public int search(int data){
        int count = 0;
        ListNode cur = this.head.next;
        while(cur != null){
            if(cur.val == data){
                return count;
            }
            count++;
            cur = cur.next;
        }
        return -1;
    }
    public void modify(int index,int data){
        ListNode cur = this.head.next;
        if(index < 0 || index > this.size()){
            System.out.println("index位置非法！");
            return;
        }
        while(index != 0){
            cur = cur.next;
            index--;
        }
        cur.val = data;
    }
    public void display(){
        ListNode cur = this.head.next;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
