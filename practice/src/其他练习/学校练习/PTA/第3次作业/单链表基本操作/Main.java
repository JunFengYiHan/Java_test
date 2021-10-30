package 其他练习.学校练习.PTA.第3次作业.单链表基本操作;


import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-29
 * Time: 10:11
 */
//链表节点
class Node<E> {
    E val;
    Node<E> next;

    public Node(E val) {
        this.val = val;
    }
}

class MyLinkedList<E> {
    Node<E> head;//头节点
    int useSize;//节点个数

    public MyLinkedList() {
        this.head = new Node<E>(null);
        this.useSize = 0;
    }

    //头插
    public void addHead(E val) {
        Node<E> node = new Node<>(val);
        node.next = this.head.next;
        this.head.next = node;
        this.useSize++;
    }

    //尾插
    public void addList(E val) {
        Node<E> node = new Node<>(val);
        Node<E> tmp = this.head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = node;
        this.useSize++;
    }

    //指定位置插入
    public void addIndex(int index, E val) {
        if (index < 0 || index > this.useSize) {
            return;
        }

        if (index == 0) {
            addHead(val);
            return;
        }
        if (index == this.useSize) {
            addList(val);
            return;
        }
        Node<E> node = new Node<>(val);
        Node<E> tmp = getPrevNode(index).next;
        node.next = tmp.next;
        tmp.next = node;
        this.useSize++;
    }

    //获取指定位置的节点的前一个节点
    private Node<E> getPrevNode(int index) {
        Node<E> tmp = this.head;
        while (index-- > 1) {
            tmp = tmp.next;
        }
        return tmp;
    }

    //删除节点
    public void delete(int index) {
        if (index <= 0 || index > this.useSize) {
            return;
        }
        Node<E> tmp = getPrevNode(index);
        tmp.next = tmp.next.next;
        this.useSize--;
    }

    //打印节点
    public void display() {
        Node<E> tmp = this.head.next;
        while (tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
    }
}

public class Main {
    //单链表基本操作
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            list.addList(val);
        }
        n = sc.nextInt();
        boolean flag = false;//标识是不是添加
        for (int i = 0; i < n; i++) {
            flag = sc.nextInt()==0;
            int k = sc.nextInt();
            if (flag) {
                int val = sc.nextInt();
                list.addIndex(k,val);
            }else {
                list.delete(k);
            }
        }
        list.display();
    }
}
