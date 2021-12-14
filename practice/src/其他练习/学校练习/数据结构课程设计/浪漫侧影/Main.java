package 其他练习.学校练习.数据结构课程设计.浪漫侧影;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-12-01
 * Time: 23:51
 */
class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {//侧影即层序遍历的第一个和最后一个
        int n = 0;
        n = sc.nextInt();
        int[] inorder = new int[n];
        int[] postorder = new int[n];
        inputDate(inorder, postorder);//输入数据
        Node root = createTree(inorder, postorder);//创建树
        ArrayList<ArrayList<Node>> arr = sequence(root);//获取层序遍历结果
        display(arr);//打印所需结果
        sc.close();
    }

    private static void display(ArrayList<ArrayList<Node>> arr) {
        System.out.print("R:");
        for (int i = 0; i < arr.size(); i++) {
            ArrayList<Node> tmp = arr.get(i);
            System.out.printf(" %d",tmp.get(tmp.size()-1).val);
        }
        System.out.print("\nL:");
        for (int i = 0; i < arr.size(); i++) {
            ArrayList<Node> tmp = arr.get(i);
            System.out.printf(" %d",tmp.get(0).val);
        }
    }

    private static ArrayList<ArrayList<Node>> sequence(Node root) {
        ArrayList<ArrayList<Node>> ret = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);//手动加入根节点启动
        while(!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Node> arr = new ArrayList<>();
            while(size>0) {
                size--;
                Node tmp = queue.poll();
                arr.add(tmp);
                if (tmp.left!=null) {
                    queue.add(tmp.left);
                }
                if(tmp.right!=null) {
                    queue.add(tmp.right);
                }
            }
            ret.add(arr);
        }
        return ret;
    }

    static int index;

    private static Node createTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        return create(inorder, postorder, 0, postorder.length - 1);
    }

    private static Node create(int[] inorder, int[] postorder, int left, int right) {
        if (index < 0 || left > right) {
            return null;
        }
        Node root = new Node(postorder[index]);
        int pos = find(inorder, left, right, postorder[index]);
        index--;
        root.right = create(inorder, postorder, pos + 1, right);
        root.left = create(inorder, postorder, left, pos - 1);
        return root;
    }

    private static int find(int[] inorder, int left, int right, int k) {
        for (int i = left; i <= right; i++) {
            if (inorder[i] == k) {
                return i;
            }
        }
        return -1;
    }

    private static void inputDate(int[] inorder, int[] postorder) {
        //Scanner sc = new Scanner(System.in);
        for (int i = 0; i < inorder.length; i++) {
            inorder[i] = sc.nextInt();
        }
        for (int i = 0; i < postorder.length; i++) {
            postorder[i] = sc.nextInt();
        }
        //sc.close();
    }
}
