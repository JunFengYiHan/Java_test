package 笔试练习.统计回文;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-15
 * Time: 18:29
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        int count = 0;
        //暴力求解,构造所有可能,逐个判断
        for (int i = 0; i <= str1.length(); i++) {
            StringBuilder sb = new StringBuilder(str1);
            sb.insert(i,str2);
            int left = 0;
            int right = sb.length() - 1;
            char[] arr = sb.toString().toCharArray();
            boolean flag = true;
            while(left<right) {
                if(arr[left]!=arr[right]) {
                    flag = false;
                    break;
                }
                left++;
                right--;
            }
            if(flag) count++;
        }
        System.out.println(count);
    }
}
