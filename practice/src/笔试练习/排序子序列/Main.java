package 笔试练习.排序子序列;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-12
 * Time: 19:04
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int count = 0;
        for (int i = 1; i < n-1; i++) {
            if (arr[i-1]<arr[i] && arr[i+1]>arr[i] || arr[i-1]>arr[i] && arr[i+1]<arr[i]) {
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
