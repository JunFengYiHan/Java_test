package 笔试练习.查找两个字符串ab中的最长公共子串;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-11-01
 * Time: 18:38
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();

        }

    }

    private static int[] getNext(String str) {
        char[] arr = str.toCharArray();
        int[] ret = new int[arr.length];
        ret[0] = -1;
        int j = 0;
        int k = -1;
        while (j < arr.length - 1                        ) {
            if (k == -1 || arr[j] == arr[k]) {
                ret[++j] = ++k;
            } else {
                k = ret[k];
            }
        }
        return ret;
    }
}
