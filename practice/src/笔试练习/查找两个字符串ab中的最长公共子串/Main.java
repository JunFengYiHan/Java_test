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
            int[] next = getNext(str1);
            String ret = "";
            StringBuilder sb = new StringBuilder();
            int i = 0;
            int j = 0;
            while (i < str1.length() && j < str2.length()) {
                if (j==-1 || str1.charAt(i) == str2.charAt(j)) {
                    if(j!=-1) {
                        sb.append(str1.charAt(i));
                    }
                    i++;
                    j++;
                } else {
                    j = next[i++];
                    //sb = new StringBuilder();//没有清空方法,重新开辟
                    if (sb.length() > ret.length()) {
                        ret = sb.toString();
                    }
                    sb.delete(0, sb.length());//删除所有元素
                }
            }
            if (sb.length() > ret.length()) ret = sb.toString();
            System.out.println(ret);
        }

    }
    //感觉不太适合使用kmp算法
    private static int[] getNext(String str) {
        char[] arr = str.toCharArray();
        int[] ret = new int[arr.length];
        ret[0] = -1;
        int j = 0;
        int k = -1;
        while (j < arr.length - 1) {
            if (k == -1 || arr[j] == arr[k]) {
                ret[++j] = ++k;
            } else {
                k = ret[k];
            }
        }
        return ret;
    }
}
