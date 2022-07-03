package 模拟面试.餐馆;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/7/3
 * Time: 19:54
 */

class Node implements Comparable<Node> {
    public int num;
    public int price;

    public Node(int num, int price) {
        this.num = num;
        this.price = price;
    }

    @Override
    public int compareTo(Node o) {
        return o.price - this.price;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[] = new int[n];
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            int price = sc.nextInt();
            Node node = new Node(num, price);
            priorityQueue.add(node);
        }

        int ret = 0;
        while (!priorityQueue.isEmpty()) {
            int tmp = 0;
            Node node = priorityQueue.poll();
            while (tmp < n) {
                if (arr[tmp] >= node.num) {
                    ret += node.price;
                    arr[tmp] = -1;//标识当前桌子已经使用
                    break;
                }
                tmp++;
            }
        }
        System.out.println(ret);
    }
}
