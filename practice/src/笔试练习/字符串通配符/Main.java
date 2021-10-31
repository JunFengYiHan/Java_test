package 笔试练习.字符串通配符;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-31
 * Time: 17:23
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //字母全部转换为小写
        String str1 = sc.nextLine().toLowerCase();
        String str2 = sc.nextLine().toLowerCase();
        int i = 0;
        int j = 0;
        while(i<str1.length()&&j<str2.length()) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(j);
            //相同字符往后走
            if (ch1==ch2) {
                i++;
                j++;
            }else if (ch1=='?'){
                if (!(ch2>='a'&&ch2<='z'||ch2>='0'&&ch2<='9')) {
                    break;
                }
                i++;
                j++;
            }else if(ch1=='*') {//还没写完...
                //找到下一个非*的字符
                i++;//跳过当前*
                while(ch1=='*'&&i<str1.length()) {
                    ch1 = str1.charAt(i++);
                }
                if (i>=str1.length()) {
                    break;
                }
                //相同直接往后走

                if (ch1==ch2) {
                    i++;
                    j++;
                    continue;
                }
                while(j<str2.length() && !(ch2>='a'&&ch2<='z'||ch2>='0'&&ch2<='9')) {
                    ch2 = str2.charAt(j++);
                }

            }else {
                break;
            }
        }
        //当i,j同时走到终点时,匹配成功
        System.out.println(i==str1.length()&&j==str2.length());
    }
}
