package 笔试练习.统计每个月兔子的总数;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-31
 * Time: 17:15
 */
public class Main {
    //获取三十一个月的兔子情况,类似于fibonacci数列
    public static int[] getBuffer() {
        int[] arr = new int[31];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < 31; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = getBuffer();
        while (sc.hasNext()) {
            int index = sc.nextInt() - 1;//转换为下标
            System.out.println(arr[index]);
        }
    }
}
