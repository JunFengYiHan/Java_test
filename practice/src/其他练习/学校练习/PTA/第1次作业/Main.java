package 其他练习.学校练习.PTA.第1次作业;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-18
 * Time: 18:00
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int data = sc.nextInt();
        int i = n-1;
        for (; i >= 0 ; i--) {
            if (data>arr[i]) {
                arr[i+1] = arr[i];
            }else{
                break;
            }
        }
        arr[i+1] = data;
        for (i = 0; i < n+1; i++) {
            System.out.print(arr[i]);
            if (i<n) {
                System.out.print(" ");
            }
        }
    }
}
