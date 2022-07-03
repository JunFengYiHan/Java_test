package 模拟面试.在字符串中找出连续最长的数字串;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/7/3
 * Time: 19:38
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(findMaxLongNum(str));
    }

    public static String findMaxLongNum(String str) {
        char[] arr = str.toCharArray();
        String ret = "";
        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder();
            while (i < arr.length && arr[i] >= '0' && arr[i] <= '9') {
                sb.append(arr[i]);
                i++;
            }
            if (sb.length() > ret.length()) {
                ret = sb.toString();
            }
        }
        return ret;
    }
}
