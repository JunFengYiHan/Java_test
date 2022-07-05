package 笔试练习.两种排序方法;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-26
 * Time: 11:10
 */
public class Main {
    //AC 80%
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strings = new String[n];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }
        System.out.println(estimateSort(strings));
    }

    public static String estimateSort(String[] strings) {
        String[] arr = {"none", "lexicographically", "lengths", "both"};
        int ret = 0;
        boolean flag1 = isLexicographically(strings);
        boolean flag2 = isLengths(strings);
        if (flag1) ret = 1;
        if (flag2) ret = 2;
        if (flag1 && flag2) ret = 3;
        return arr[ret];
    }

    public static boolean isLexicographically(String[] strings) {
        int flag = 0;//0初始,-1升序,1降序
        for (int i = 1; i < strings.length; i++) {
            if (strings[i - 1].compareTo(strings[i]) > 0) {
                if(flag!=-1){
                    flag = 1;
                }else {
                    return false;
                }
            }
            if (strings[i - 1].compareTo(strings[i]) > 0) {
                if(flag!=1){
                    flag = -1;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isLengths(String[] strings) {
        int flag = 0;//0初始,-1升序,1降序
        for (int i = 1; i < strings.length; i++) {
            if (strings[i - 1].length() > strings[i].length()) {
                if (flag != -1) {
                    flag = 1;
                } else {
                    return false;
                }
            }
            if (strings[i - 1].length() < strings[i].length()) {
                if(flag!=1) {
                    flag = -1;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
