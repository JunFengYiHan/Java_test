package 其他练习.学校练习.PTA.第4次作业;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-11-12
 * Time: 16:11
 */
public class Main {
    //判断是不是待处理的字符
    public static boolean isBracket(char ch) {
        return ch == '(' || ch == ')' || ch == '{' || ch == '}' || ch == '[' || ch == ']' || ch == '/' || ch == '*';
    }

    public static boolean isPair(String str,int index) {
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        while (sc.hasNext()) {
            String str = sc.nextLine();
            if (str.charAt(0) == '.') {
                break;
            }
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (isBracket(ch)) {
                    if (ch=='('||ch=='['||ch=='{') {

                    }else {

                    }
                }
            }
        }
    }
}
