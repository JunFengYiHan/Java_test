//package leetcode;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-03
// * Time: 1:37
// */
//class Node{
//    int val;
//    Node next;
//    Node prev;
//    public Node(int val){
//        this.val = val;
//    }
//}
//class MyLinkedList {
//    Node head;
//    Node trail;
//    int size;
//    /** Initialize your data structure here. */
//    public MyLinkedList() {
//        this.size = 0;
//        this.head = new Node(-1);
//        this.trail = new Node(0);
//        this.head.next = this.trail;
//        this.trail.prev = this.head;
//    }
//
//    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
//    public int get(int index) {
//        if(index<0||index>=this.size) return -1;
//        Node cur = this.head.next;
//        while(index>0){
//            cur = cur.next;
//            index--;
//        }
//        return cur.val;
//    }
//
//    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
//    public void addAtHead(int val) {
//        Node node = new Node(val);
//        node.prev = this.head;
//        node.next = this.head.next;
//        this.head.next.prev = node;
//        this.head.next = node;
//        this.size++;
//    }
//
//    /** Append a node of value val to the last element of the linked list. */
//    public void addAtTail(int val) {
//        Node node = new Node(val);
//        node.next = this.trail;
//        node.prev = this.trail.prev;
//        this.trail.prev.next = node;
//        this.trail.prev = node;
//        this.size++;
//    }
//
//    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
//    public void addAtIndex(int index, int val) {
//        if(index>this.size) return;
//        if(index<=0){
//            addAtHead(val);
//            return;
//        }
//        if(index==this.size){
//            addAtTail(val);
//            return;
//        }
//        Node cur = this.head.next;
//        while(index>0){
//            cur = cur.next;
//            index--;
//        }
//        Node node = new Node(val);
//        node.next = cur;
//        node.prev = cur.prev;
//        cur.prev.next = node;
//        cur.prev = node;
//        this.size++;
//    }
//
//    public void disPlay() {
//        Node cur = this.head.next;
//        while(cur.next != null){
//            System.out.print(cur.val+" ");
//            cur = cur.next;
//        }
//    }
//
//    /** Delete the index-th node in the linked list, if the index is valid. */
//    public void deleteAtIndex(int index) {
//        if(index>=this.size||index<0) return;
//
//        Node cur = this.head.next;
//        while(index>0){
//            cur = cur.next;
//            index--;
//        }
//        cur.prev.next = cur.next;
//        cur.next.prev = cur.prev;
//    }
//}
//
//public class 设计链表 {
//    public static void main(String[] args) {
//        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtHead(1);
//        linkedList.addAtTail(3);
//        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//        linkedList.disPlay();
//        //System.out.println(linkedList.get(1));
//        //linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//        //System.out.println(linkedList.get(1));
//
//    }
//}
