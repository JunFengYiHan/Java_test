package 笔试练习.连续最大和;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-15
 * Time: 18:31
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = arr[0];
        int maxSum = sum;//将第一个元素标记为最大值
        for (int i = 1; i < n; i++) {
            if (sum>0) {
                sum+=arr[i];
            }else {
                sum = arr[i];
            }
            if (sum>maxSum) {
                maxSum = sum;
            }
        }
        System.out.println(maxSum);
    }
}
