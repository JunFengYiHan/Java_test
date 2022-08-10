package 笔试练习.最长上升子序列;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/8/10
 * Time: 22:35
 */
public class Main {//没有ac
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();//存放下标
        while (scanner.hasNext()) {
            int count = 0;//最小为1
            int n = scanner.nextInt();
            int[] arr = new int[n];
            int[] ret = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                //栈为空,或当前元素大于栈顶元素,符合升序入栈
                if (stack.isEmpty() || arr[i] > arr[stack.peek()]) {
                    ret[i] = stack.size();//记录当前元素前有多少比他小的
                    stack.push(i);
                    continue;
                }
                //当前元素小于等于栈顶元素,出栈.
                while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                    int tmp = stack.pop();
                    count = Math.max(count, ret[tmp]);
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                count = Math.max(count, ret[stack.pop()]);
            }
            //加上本身
            System.out.println(count + 1);
        }
    }
}
