package 笔试练习.反转部分单向链表;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/7/27
 * Time: 21:09
 */
public class Main {
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private static Node head = new Node(-1);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node tmp = head;
        // 串联当前链表
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            Node node = new Node(val);
            tmp.next = node;
            tmp = node;
        }
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        Node left = head;
        Node right = head;
        //左前一个
        for (int i = 1; i < l; i++) {
            left = left.next;
        }
        //右边界
        for (int i = 0; i < r; i++) {
            right = right.next;
        }
        reverse(left, right);
        Node cur = head.next;
        for (int i = 0; i < n; i++) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    //翻转链表
    public static void reverse(Node leftPrev, Node right) {
        //前驱节点
        Node prev = right.next;
        //当前节点
        Node cur = leftPrev.next;
        //右边界下一个节点
        Node next = right.next;
        while (cur != next) {
            //System.out.println(cur.val);
            Node curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        leftPrev.next = prev;
    }
}
