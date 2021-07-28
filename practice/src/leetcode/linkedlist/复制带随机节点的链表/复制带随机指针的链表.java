package leetcode.linkedlist.复制带随机节点的链表;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-16
 * Time: 21:52
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public  class 复制带随机指针的链表 {
    //方法三，map拷贝
    public Node copyRandomList(Node head) {
        //为空直接返回
        if(head==null){
            return null;
        }
        //创建一个哈希表
        HashMap<Node,Node> map = new HashMap<>();
        Node tmp = head;
        //将所有节点都复制一份，以原节点为key，新节点为value放入哈希表中
        while(tmp!=null) {
            map.put(head,new Node(tmp.val));
            tmp = tmp.next;
        }
        tmp = head;
        //将哈希表中的新链表串联起来
        //并复制random指针
        while(tmp!=null){
            map.get(tmp).next = map.get(tmp.next);//不存在返回null
            //也可以使用下面这种方式代替，指定返回值
            //map.get(tmp).next = map.getOrDefault(tmp.next,null);
            map.get(tmp).random = map.get(tmp.random);//赋值不影响
            tmp = tmp.next;
        }
        return map.get(head);
    }
    //方法二，哈希+递归拷贝
//    HashMap<Node,Node> map = new HashMap<>();
//    public Node copyRandomList(Node head) {
//        //如果为空直接返回
//        if(head==null) return null;
//        //如果已经遍历过了则直接取值返回
//        if(map.containsKey(head)) return map.get(head);
//        //创建一个新的节点，并将其放入哈希表中
//        Node node = new Node(head.val);
//        map.put(head,node);
//        //递归创建新的链表，并拷贝random指针
//        node.next =  copyRandomList(head.next);
//        node.random = copyRandomList(head.random);
//        return node;
//    }
    //方法一，在原链表中复制节点
//    public Node copyRandomList(Node head) {
//        if(head==null) return null;
//
//        Node tmp = head;
//        //复制链表成新老节点交错
//        while(tmp!=null){
//            Node node = new Node(tmp.val);
//            node.next = tmp.next;
//            tmp.next = node;
//            tmp = node.next;
//        }
//        //复制random节点
//        tmp = head;
//        while(tmp!=null){
//            if(tmp.random!=null) {
//                tmp.next.random = tmp.random.next;
//            }
//            tmp = tmp.next.next;
//        }
//        tmp = head;
//        Node newHead = new Node(-1);
//        Node cur = newHead;
//        //将链表拆分，必须拆开而不是截取需要的部分
//        //oj会检查原链表的地址
//        while(tmp!=null) {
//            cur.next = tmp.next;
//            cur = cur.next;
//            tmp.next = cur.next;
//            tmp = tmp.next;
//        }
//        return newHead.next;
//    }
}
