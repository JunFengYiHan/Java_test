package 笔试练习.Emacs计算器;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/8/11
 * Time: 23:50
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String str = scanner.nextLine();
            //str = str.replace(" ", "");
            int ret = emacs(str.toCharArray());
            System.out.println(ret);
        }
    }

    //暂时不考虑表达式有误情况
    private static int emacs(char[] arr) {
        Stack<Integer> stack = new Stack<>();
        int tmp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                tmp = tmp * 10 + arr[i] - '0';
                flag = true;
                continue;
            }
            if (flag) {
                stack.push(tmp);
                tmp = 0;
                flag = false;
            }
            if (arr[i] != ' ') {
                int n = stack.pop();
                int m = stack.pop();
                switch (arr[i]) {
                    case '+':
                        stack.push(m + n);
                        break;
                    case '-':
                        stack.push(m - n);
                        break;
                    case '*':
                        stack.push(m * n);
                        break;
                    case '/':
                        if (n == 0) return 0;
                        stack.push(m / n);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
