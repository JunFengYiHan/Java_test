package 其他练习.学校练习.数据结构课程设计.哈夫曼编码;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-12-09
 * Time: 10:03
 */
class Node {
    char val;
    int weight;
    int parent;
    int left;
    int right;

    public Node() {
    }

    public Node(int weight) {
        this.weight = weight;
    }

    public Node(char val, int weight) {
        this.val = val;
        this.weight = weight;
    }
}

public class Main {
    //static int wpl;//记录带权路径

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node[] arr = new Node[52];//哈夫曼树顺序储存
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            sb.append(sc.nextLine());
        }
        //去掉:
        String str = sb.toString().replace(":", "");
        init(arr, str);
        createTree(arr);
//        System.out.println("带权路径长度为: " + wpl);
//        System.out.println("哈夫曼编码为:");
        huffman(arr);
        sc.close();
    }

    //求取路径
    private static void huffman(Node[] arr) {
        for (int i = 1; i <= arr[0].weight; i++) {
            Node tmp = arr[i];
            int cur = i;
            char val = tmp.val;
            StringBuilder sb = new StringBuilder();
            while (tmp.parent != 0) {
                sb.append(arr[tmp.parent].left == cur ? 0 : 1);//判断是左还是右
                cur = tmp.parent;//更新当前节点下标
                tmp = arr[tmp.parent];//更新当前节点
            }
            sb.append(':').append(val);
            System.out.println(sb.reverse());
        }
    }

    //创建树
    private static void createTree(Node[] arr) {
        int count = 0;//新建节点个数
        //遍历节点数减一次
        for (int i = 0; i < arr[0].weight - 1; i++) {
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;//int的最大值
            int i1 = 0;
            int i2 = 0;//min1,min2对应的下标
            int j = 1;
            for (; j <= arr[0].weight + count; j++) {
                if (arr[j].parent == 0) {
                    if (arr[j].weight < min1) {
                        min2 = min1;
                        i2 = i1;
                        min1 = arr[j].weight;
                        i1 = j;
                    } else if (arr[j].weight < min2) {
                        i2 = j;
                        min2 = arr[j].weight;
                    }
                }
            }
            arr[j] = new Node(arr[i1].weight + arr[i2].weight);
            //wpl += arr[j].weight;
            arr[j].left = i1;
            arr[j].right = i2;
            arr[i1].parent = j;
            arr[i2].parent = j;
            count++;
        }
        //arr[0].weight += count;//记录当前元素个数
    }

    //对数据进行初始化
    private static void init(Node[] arr, String str) {
        int n = str.length();
        int weight = 0;
        int len = 0;
        arr[0] = new Node();
        String[] num = str.split("[A-Z]+");//以字母将权重划分,第一个会空出来,因为字母开头
        int j = 0;//遍历权重
        for (int i = 0; i < n; i++) {
            char tmp = str.charAt(i);
            if (tmp >= 'A' && tmp <= 'Z') {
                arr[0].weight++;//用第一个来标识有多少元素
                arr[++j] = new Node(tmp, Integer.parseInt(num[j]));
            }
        }
        //return len;
    }
}
