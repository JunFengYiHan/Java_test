package 其他练习.学校练习.实践测试题.素数问题;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-12-14
 * Time: 16:16
 */
public class Main {
    public static void main(String[] args) {
        primeNum(101,200);
    }

    private static void primeNum(int start, int end) {
        int count = 0;
        int[] arr = new int[100];
        for (int i = start; i <= end; i++) {
            if(isPrime(i)) {
                arr[count] = i;
                count++;
            }
        }
        System.out.println("一共有:"+count+"个,如下");
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    private static boolean isPrime(int n) {
        if(n==2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }
}
