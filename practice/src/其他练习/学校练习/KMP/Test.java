package 其他练习.学校练习.KMP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-11-05
 * Time: 13:54
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int[] next1 = getNext(str1);
        int[] next2 = getNext(str2);
        System.out.println("目标串next数组: " + Arrays.toString(next1));
        System.out.println("模式串next数组: " + Arrays.toString(next2));
    }

    public static int[] getNext(String str) {
        char[] arr = str.toCharArray();
        int[] ret = new int[arr.length];
        ret[0] = -1;
//        ret[1] = 0;
        int j = 0;
        int k = -1;
        while (j < ret.length - 1) {
            if (k == -1 || arr[j] == arr[k]) {
                ret[++j] = ++k;
            } else {
                k = ret[k];
            }
        }
        return ret;
    }
}
