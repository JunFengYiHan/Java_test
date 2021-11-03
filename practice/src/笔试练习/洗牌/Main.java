package 笔试练习.洗牌;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-11-03
 * Time: 18:26
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = 0;//每组牌数
        int k = 0;//洗牌次数
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            k = sc.nextInt();
            int[] arr = new int[2 * n];
            for (int j = 0; j < 2 * n; j++) {
                arr[j] = sc.nextInt();
            }
            for (int j = 0; j < k; j++) {
                shuffle(arr, n);
            }
            for (int j = 0; j < 2 * n; j++) {
                System.out.print(arr[j]);
                if (j < 2 * n - 1) {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
        sc.close();
    }

    public static void shuffle(int[] arr, int n) {
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = arr[i];
            right[i] = arr[i + n];
        }
        int j = 0;
        for (int i = 0; i < 2 * n; i += 2) {
            arr[i] = left[j];
            arr[i + 1] = right[j++];
        }
    }
}
