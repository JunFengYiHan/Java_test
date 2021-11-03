package 笔试练习.字符串反转;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-11-02
 * Time: 17:48
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String str = sc.nextLine();
        str = reversal(str);
        System.out.println(str);
    }

    private static String reversal(String str) {
        char[] arr = str.toCharArray();
        int i = 0;
        int j = arr.length-1;
        while(i<j) {
            char tmp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = tmp;
        }
        return new String(arr);
    }
}
