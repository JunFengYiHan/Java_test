package 其他练习.学校练习.PTA.第2次作业;

import java.util.Date;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-27
 * Time: 21:29
 */
public class Main {
    //表达式求值
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            long s1=System.currentTimeMillis();
            long d1=new Date().getTime();
            String str = sc.nextLine();
            str = transition(str);
            System.out.println(evaluation(str));
            long s2=System.currentTimeMillis();
            long d2=new Date().getTime();
            System.out.println(d2-d1+"ms");
            System.out.println(s2-s1+"ms");
        }
    }
    //后缀表达式求值
    private static String evaluation(String str) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (tmp>='0'&&tmp<='9') {
                sum = sum*10 + tmp-'0';
                flag = true;
                continue;
            }
            if (tmp==' ') {
                if (flag) {
                    stack.push(sum);//当前值入栈
                    flag = false;
                }
                sum = 0;//置空
            }else {
                switch(tmp) {
                    case '+':stack.push(stack.pop()+stack.pop());break;
                    case '*':stack.push(stack.pop()*stack.pop());break;
                    case '-':
                        int n = stack.pop();
                        int m = stack.pop();
                        stack.push(m-n);
                        break;
                    case '/':
                        n = stack.pop();
                        m = stack.pop();
                        if (n==0) {
                            return "ILLEGAL";
                        }
                        stack.push(m/n);
                        break;
                }
            }

        }
        return stack.pop()+"";
    }
    //将中缀表达式转换为后缀表达式
    private static String transition(String str) {
        Stack<Character> stack = new Stack<>();//操作符栈
        StringBuilder sb = new StringBuilder();//最终后缀表达式
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch>='0' && ch<='9') {
                sb.append(ch);
            }else {
                sb.append(' ');//区分每个数字
                //栈为空直接入栈
                if (stack.empty()||ch=='(') {
                    stack.push(ch);
                }else if (ch==')'){
                    //假设输入的表达式合法,将左右括号直接的操作符全部出栈
                    while (!stack.empty() && stack.peek()!='(') {
                        sb.append(stack.pop());
//                        sb.append(' ');
                    }
                    stack.pop();//去掉栈顶左括号
                }else {
                    //ch为+或-直接出栈
                    if (ch == '+'||ch == '-') {
                        while (!stack.empty()&&stack.peek()!='(') {
                            sb.append(stack.pop());
                        }
                        stack.push(ch);
                    }else {
                        //栈顶为+ -直接入栈,* /出栈
//                        if (stack.peek() != '+' && stack.peek() != '-' && stack.peek() != '(') {
                            while (!stack.empty() && (stack.peek() == '*' || stack.peek() == '/')) {
                                sb.append(stack.pop());
                            }
//                        }
                        stack.push(ch);
                    }
                }
            }
        }
        sb.append(' ');
        while(!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
