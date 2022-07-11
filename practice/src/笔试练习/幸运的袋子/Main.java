package 笔试练习.幸运的袋子;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-27
 * Time: 18:50
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(luckyBag(input()));
    }
    //暴力计算,列出所有子集,ac 20%
    public static int luckyBag(int[] arr) {
        Set<String> set = new HashSet<>();
        int count = 0;//最少有一个,取子集
        for (int i = 1; i < (1 << arr.length); i++) {
            int sum = 0;
            int pro = 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                if ((i & (1 << j)) != 0) {
                    //System.out.print(arr[j]);
                    sum += arr[j];
                    pro *= arr[j];
                    sb.append(arr[j]);//保存每个序列确保不同
                }
            }
            String str = sb.toString();
            if (sum > pro && !set.contains(str)){
                count++;
                set.add(str);
            }
            // System.out.println();
        }
        return count;
    }

    public static int[] input() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
