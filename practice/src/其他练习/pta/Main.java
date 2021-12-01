package 其他练习.pta;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-11-27
 * Time: 9:04
 */
public class Main {
    //7-5
    public static double isSafety(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int count = 0;
        double s = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                double tmp =  isSafety(arr[i][0],arr[j][0],arr[i][1],arr[j][1]);
                if (tmp>=100) {
                    count++;
                }else {
                    s+=tmp;
                }
            }
        }
        if (count>0) {
            System.out.println(count+" persons are safe!");
        }else {
            System.out.println("Warning! All persons are in Danger! Virus will infect everyone in "+s+" seconds!");
        }
    }
//    //7-2
//    static class Node{
//        int val;
//        Node left;
//        Node right;
//        public Node(int val) {
//            this.val = val;
//        }
//    }
//    static int j;
//    public static Node prevCreate(String[] arr) {
//        if(j < arr.length - 1 && Integer.parseInt(arr[j])==0) {
//            return null;
//        }
//        Node root = new Node(Integer.parseInt(arr[j]));
//        j++;
//        root.left = prevCreate(arr);
//        j++;
//        root.right = prevCreate(arr);
//        return root;
//    }
//    static int k;
//    private static void func(Node root,StringBuilder ret) {
//        if (root==null || k <= 0) {
//            return;
//        }
//        func(root.right,ret);
//        if (root.val<=k) {
//            ret.append(' ').append(root.val);
//            k-=root.val;
//        }
//        if (k<=0) {
//            return;
//        }
//        func(root.left,ret);
//
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        sc.nextLine();
//        for (int i = 0; i < n; i++) {
//            String[] str = sc.nextLine().split(" ");
//            j = 0;
//            Node root = prevCreate(str);
//            k = Integer.parseInt(str[str.length-1]);
//            StringBuilder ret = new StringBuilder();
//            func(root,ret);
////            ret.deleteCharAt(ret.length()-1);
//            if (k==0) {
//                System.out.println(ret.reverse().toString());
//            }else {
//                System.out.println("no available path");
//            }
//        }
//    }

    //7-1
//    public static boolean isAlien(int a, int b) {
//        int[] arr = new int[10];
//        while (a != 0) {
//            arr[a % 10]++;
//            arr[b % 10]--;
//            a /= 10;
//            b /= 10;
//        }
//        for (int i = 0; i < 10; i++) {
//            if(arr[i]!=0) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        if (a == b) {
//            System.out.println("Equal");
//        } else if (isAlien(a, b)) {
//            System.out.println("ALIEN");
//        } else {
//            System.out.println("Different");
//        }
//    }
}
