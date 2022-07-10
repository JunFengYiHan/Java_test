package 笔试练习.参数解析;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-26
 * Time: 18:17
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();//最终答案
        boolean flag = false;//标识是否为双引号中的空格
        int count = 0;//参数个数
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);//获取当前字符
            if (tmp=='\"'){
                flag = !flag;//出现一个就改变一次状态
                continue;
            }
            if (tmp!=' ') {
                sb.append(tmp);
            }else if(flag){
                sb.append(tmp);
            }else{
                count++;
                sb.append("\n");
            }
        }
        System.out.println(count+1);//最后一个字符串没有记录上
        System.out.println(sb.toString());
    }
}
