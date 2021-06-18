//package leetcode.linkedlist;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-19
// * Time: 0:41
// */
//
//
//class Node {
//    public int val;
//    public Node prev;
//    public Node next;
//    public Node child;
//}
//
//public class 扁平化多级双向链表 {
//    public Node flatten(Node head) {
//        //链表为空直接返回
//        if(head==null) return null;
//        //将所有节点都放入这个顺序表
//        List<Node> list = new ArrayList<>();
//        //相当于一个平躺的二叉树，使用前序遍历
//        preorderTraversal(head,list);
//        Node tmp = head;
//        //遍历，串成一个链表
//        for(Node node:list){
//            //修改每个节点的所有指向
//            node.prev = tmp;
//            node.next = null;
//            node.child = null;
//            tmp.next = node;
//            tmp = node;
//        }
//        //头节点除了next全部置空，确保成为单链表
//        head.prev = null;
//        head.child = null;
//        return head;
//    }
//    public void preorderTraversal (Node root,List<Node> list){
//        if(root==null) return;
//        list.add(root);
//        preorderTraversal(root.child,list);
//        preorderTraversal(root.next,list);
//    }
//}
