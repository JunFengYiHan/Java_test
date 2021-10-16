package 笔试练习.连续最长数字串;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-13
 * Time: 18:34
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String str = sc.nextLine();
        String ret = "";
        for (int i = 0; i < str.length(); i++) {
            StringBuilder sb = new StringBuilder();
            char ch;
            do{
                ch = str.charAt(i);
                if (ch>='0' && ch<='9') {
                    sb.append(ch);
                }
                i++;
            }while(ch>='0' && ch<='9' && i < str.length());
            if (ret.length()<sb.length()) {
                ret = sb.toString();
            }
        }
        System.out.println(ret);
        sc.close();
    }
//    public static void main(String[] args) {
//        Scanner sc  = new Scanner(System.in);
//        String str = sc.nextLine();
//        String ret = "";
//        for (int i = 0; i < str.length(); ) {
//            StringBuilder sb = new StringBuilder();
//            char ch = str.charAt(i++);
//            while(ch>='0' && ch<='9' && i < str.length()) {
//                sb.append(ch);
//                ch = str.charAt(i++);
//            }
//            if (ch>='0' && ch<='9') {
//                sb.append(ch);
//            }
//            if (ret.length()<sb.length()) {
//                ret = sb.toString();
//            }
//        }
//        System.out.println(ret);
//        sc.close();
//    }
}
