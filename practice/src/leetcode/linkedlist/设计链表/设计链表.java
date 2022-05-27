package leetcode.linkedlist.设计链表;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-03
 * Time: 1:37
 */
class Node{
    int val;
    Node next;
    Node prev;
    public Node(int val){
        this.val = val;
    }
}
class MyLinkedList {
    Node head;//傀儡头
    Node trail;//傀儡尾
    int size;//链表长度
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.size = 0;//初始长度为0
        this.head = new Node(-1);//实例化头
        this.trail = new Node(0);//实例化尾
        this.head.next = this.trail;//头的next指向尾
        this.trail.prev = this.head;//尾的prev指向头
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        //题目要求下标不合理返回-1
        //实际设计应该抛出异常
        //因为oj无法识别异常，所以按照题目要求返回-1
        if(index<0||index>=this.size) return -1;
//        if(index<0||index>=this.size) {
//          throw new NullPointerException();
//        }
        //可以根据index和size/2的关系，考虑从头还是从尾开始减少遍历时间
        Node cur = this.head.next;
        while(index>0){
            cur = cur.next;
            index--;
        }
        return cur.val;
    }

    /** AddOperation a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.prev = this.head;
        node.next = this.head.next;
        this.head.next.prev = node;
        this.head.next = node;//更新头节点的next的指向
        this.size++;//链表长度+1
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        node.next = this.trail;
        node.prev = this.trail.prev;
        this.trail.prev.next = node;
        this.trail.prev = node;//更新尾节点的prev的指向
        this.size++;//链表长度+1
    }

    /** AddOperation a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index>this.size) return;
        //索引小于等于0调用头插
        if(index<=0){
            addAtHead(val);
            return;
        }
        //索引等于链表长度调用尾插
        if(index==this.size){
            addAtTail(val);
            return;
        }
        //找到当前节点
        Node cur = this.head.next;
        while(index>0){
            cur = cur.next;
            index--;
        }
        //插入在当前节点的前面
        Node node = new Node(val);
        node.next = cur;//node的next指向当前节点
        node.prev = cur.prev;//node的prev指向当前节点的上一个节点
        cur.prev.next = node;//当前节点的上一个节点的next指向node
        cur.prev = node;//当前节点的prev指向node
        this.size++;//链表长度+1
    }
    //按顺序打印节点数据
    public void disPlay() {
        Node cur = this.head.next;
        while(cur.next != null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
    }

    /** DeleteOperation the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index>=this.size||index<0) return;

        Node cur = this.head.next;
        while(index>0){
            cur = cur.next;
            index--;
        }
        //跳过当前节点即可
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        this.size--;//链表长度-1
    }
}

public class 设计链表 {
    //此处设计了一个双向链表，提交记录有单向设计
    //oj链接 https://leetcode-cn.com/problems/design-linked-list/
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.disPlay();
        System.out.println(linkedList.get(1));
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.get(2));
        linkedList.disPlay();
    }
}
