package 笔试练习.进制转换;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-14
 * Time: 18:36
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(transition(m, n));
    }
    //任意进制转换
    public static String transition(int val,int n) {
        StringBuilder sb = new StringBuilder();
        boolean flag = val<0;//val可能是负数
        val = val<0?-val:val;//转换成正数
        //转换进制
        while(val!=0) {
            int tmp =  val%n;
            //判断余数类型
            if (tmp>=10) {
                tmp+='A'-10;
            }else {
                tmp+='0';
            }
            sb.append((char)tmp);
            val/=n;
        }
        //确定符号
        if (flag) {
            sb.append('-');
        }
        //翻转余数,返回结果
        return sb.reverse().toString();
    }
}
