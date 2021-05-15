import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-11
 * Time: 21:31
 */

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node(int val) {
        this.val = val;
    }
}

public class TestLinkedList {
    public Node head;
    public Node last;

    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
            this.last = node;
        }else{
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }
    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
        }else{
            this.last.next = node;
            node.prev = this.last;
        }
        this.last = node;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) {
        if(index < 0 || index > size()){
            System.out.println("index位置不合理！");
            return;
        }
        if(index == 0){
            this.addFirst(data);
            return;
        }
        if(index == size()){
            this.addLast(data);
            return;
        }
        Node node = new Node(data);
        Node cur = this.head;
        while(index>0){
            cur = cur.next;
            index--;
        }
        node.next = cur;
        node.prev = cur.prev;
        cur.prev.next = node;
        cur.next.prev = node;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        Node cur = this.head;
        while(cur != null) {
            if(cur.val == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        Node cur = this.head;
        while(cur != null) {
            if(cur.val == key){
                if(cur == this.head){
                    this.head = this.head.next;
                }else{
                    cur.prev.next = cur.next;
                    if(cur != this.last){
                        cur.next.prev = cur.prev;
                    }else{
                        last = cur.prev;
                    }
                }
                return;
            }
            cur = cur.next;
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key) {
        Node cur = this.head;
        while(cur != null) {
            if(cur.val == key){
                if(cur == this.head){
                    this.head = this.head.next;
                    if(this.head != null){
                        this.head.prev = null;
                    }else{
                        this.last = null;
                    }
                }else{
                    cur.prev.next = cur.next;
                    if(cur == this.last){
                        this.last = cur.prev;
                    }else{
                        cur.next.prev = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }
    //得到单链表的长度
    public int size() {
        Node tmp = this.head;
        int count = 0;
        while(tmp != null) {
            count++;
            tmp = tmp.next;
        }
        return count;
    }
    public void display() {
        Node tmp = this.head;
        if(this.head == null){
            System.out.println("该链表为空！");
        }
        while(tmp != null){
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }
    public void clear() {
        Node cur = this.head;
        while(cur != null){
            cur = cur.next;
            this.head = null;
            this.head = cur;
        }
        this.last = null;
        System.out.println("链表已清空！");
    }
}
