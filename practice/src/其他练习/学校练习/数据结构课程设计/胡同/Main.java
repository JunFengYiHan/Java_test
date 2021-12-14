package 其他练习.学校练习.数据结构课程设计.胡同;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-12-01
 * Time: 23:51
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt();
        int n = 0;
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            input(a);
            input(b);
            System.out.print(isRight(a, b) ? "Yes\n" : "No\n");
        }
        sc.close();
    }

    private static boolean isRight(int[] a, int[] b) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while(i<a.length && j<b.length) {
            stack.push(a[i]);
            i++;
            while(!stack.empty() && stack.peek()==b[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }

    private static void input(int[] b) {
        for (int i = 0; i < b.length; i++) {
            b[i] = sc.nextInt();
        }
    }
}
