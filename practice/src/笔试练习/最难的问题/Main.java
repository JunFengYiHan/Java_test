package 笔试练习.最难的问题;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/7/29
 * Time: 23:55
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char[] arr = str.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 'A' && arr[i] <= 'Z') {
                    //相对于A的偏移量,往前移动5变回原来的值,+26形成字母环路
                    int tmp = arr[i] - 'A' - 5 + 26;
                    arr[i] = (char) ('A' + tmp % 26);
                }
                System.out.print(arr[i]);
            }
            System.out.println();
        }
    }
}
