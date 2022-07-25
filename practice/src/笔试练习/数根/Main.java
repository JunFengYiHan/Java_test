package 笔试练习.数根;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/7/24
 * Time: 23:33
 */


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String n = scanner.next();
            char ret = func(n);
            System.out.println(ret);
        }
    }

    //计算一个数的数根
    private static char func(String str) {
        Stack<Character> stack = new Stack<>();
        char[] arr = str.toCharArray();
        List<Integer> list = new LinkedList<>();
        int val = 0;//相加的值
        int carry = 0;//进位
        for (int i = arr.length - 1; i >= 0; i--) {
            //数值不变,类型转换
            val = arr[i] - '0' + arr[i-1] - '0' + carry;
            list.add(val);
        }
        return '0';
    }

}
