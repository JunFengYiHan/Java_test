package 其他练习.学校练习.Java课程设计;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-12-29
 * Time: 13:09
 */
public class Calculator {
    private JFrame jFrame;
    private JPanel jPanel1, jPanel2;
    private JTextField jTextField;
    private JButton one, two, three, four, five, six, seven, eight, nine, zero, add, sub, div, mul, rem, equal, dec, del, lb, rb, clear;
    private Font font;
    private JLabel jLabel;
    private JMenuBar jMenuBar;
    private JMenu jMenu;
    private StringBuilder infix;
    private boolean flag;

    public Calculator() {
        jFrame = new JFrame("计算器");
        jFrame.setLayout(new GridLayout(2, 1));
        font = new Font("黑体", Font.BOLD, 20);
        jPanel1 = new JPanel(new GridLayout(5, 4));
        jPanel2 = new JPanel(new GridLayout(2, 1));
        jTextField = new JTextField();
        jMenu = new JMenu("≡");
        //jLabel = new JLabel("标准");
        jMenuBar = new JMenuBar();
        jMenuBar.add(jMenu);
        jMenuBar.add(new JMenu("标准"));
        //jLabel.setFont(font);
        jTextField.setFont(font);
        jTextField.setBounds(0, 0, 10, 500);
        //创建按钮
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        zero = new JButton("0");
        add = new JButton("+");
        sub = new JButton("-");
        div = new JButton("/");
        mul = new JButton("*");
        rem = new JButton("%");
        equal = new JButton("=");
        dec = new JButton(".");
        del = new JButton("delete");
        lb = new JButton("(");
        rb = new JButton(")");
        clear = new JButton("C");
        //设置按钮字体
        one.setFont(font);
        two.setFont(font);
        three.setFont(font);
        four.setFont(font);
        five.setFont(font);
        six.setFont(font);
        seven.setFont(font);
        eight.setFont(font);
        nine.setFont(font);
        zero.setFont(font);
        add.setFont(font);
        sub.setFont(font);
        mul.setFont(font);
        div.setFont(font);
        rem.setFont(font);
        equal.setFont(font);
        dec.setFont(font);
        del.setFont(font);
        lb.setFont(font);
        rb.setFont(font);
        clear.setFont(font);
        //默认含0
        infix = new StringBuilder("0");
        flag = true;
        //加入监听,使用lamda表达式
        one.addActionListener(e -> {
            if (flag) {
                infix.deleteCharAt(0);
                flag = false;
            }
            infix.append(1);
            jTextField.setText(infix.toString());
        });
        two.addActionListener(e -> {
            if (flag) {
                infix.deleteCharAt(0);
                flag = false;
            }
            infix.append(2);
            jTextField.setText(infix.toString());
        });
        three.addActionListener(e -> {
            if (flag) {
                infix.deleteCharAt(0);
                flag = false;
            }
            infix.append(3);
            jTextField.setText(infix.toString());
        });
        four.addActionListener(e -> {
            if (flag) {
                infix.deleteCharAt(0);
                flag = false;
            }
            infix.append(4);
            jTextField.setText(infix.toString());
        });
        five.addActionListener(e -> {
            if (flag) {
                infix.deleteCharAt(0);
                flag = false;
            }
            infix.append(5);
            jTextField.setText(infix.toString());
        });
        six.addActionListener(e -> {
            if (flag) {
                infix.deleteCharAt(0);
                flag = false;
            }
            infix.append(6);
            jTextField.setText(infix.toString());
        });
        seven.addActionListener(e -> {
            if (flag) {
                infix.deleteCharAt(0);
                flag = false;
            }
            infix.append(7);
            jTextField.setText(infix.toString());
        });
        eight.addActionListener(e -> {
            if (flag) {
                infix.deleteCharAt(0);
                flag = false;
            }
            infix.append(8);
            jTextField.setText(infix.toString());
        });
        nine.addActionListener(e -> {
            if (flag) {
                infix.deleteCharAt(0);
                flag = false;
            }
            infix.append(9);
            jTextField.setText(infix.toString());
        });
        zero.addActionListener(e -> {
            if (flag) {
                infix.deleteCharAt(0);
                flag = false;
            }
            infix.append(0);
            jTextField.setText(infix.toString());
        });
        add.addActionListener(e -> {
            if (!flag) {
                infix.append("+");
                jTextField.setText(infix.toString());
            }
        });
        sub.addActionListener(e -> {
            if (!flag) {
                infix.append("-");
                jTextField.setText(infix.toString());
            }
        });
        mul.addActionListener(e -> {
            if (!flag) {
                infix.append("*");
                jTextField.setText(infix.toString());
            }
        });
        div.addActionListener(e -> {
            if (!flag) {
                infix.append("/");
                jTextField.setText(infix.toString());
            }
        });
        rem.addActionListener(e -> {
            if (!flag) {
                infix.append("%");
                jTextField.setText(infix.toString());
            }
        });
        lb.addActionListener(e -> {
            if (flag) {
                infix.deleteCharAt(0);
                flag = false;
            }
            infix.append("(");
            jTextField.setText(infix.toString());
        });
        rb.addActionListener(e -> {
            if (!flag) {
                infix.append(")");
                jTextField.setText(infix.toString());
            }
            jTextField.setText(infix.toString());
        });
        equal.addActionListener(e -> {
            infix.append("=");
            jTextField.setText(infix.toString() + transition(infix.toString()));
            infix = new StringBuilder("0");
            flag = true;
        });
        del.addActionListener(e -> {
            if (infix.length() > 0)
                infix.deleteCharAt(infix.length() - 1);
            jTextField.setText(infix.toString());
        });
        dec.addActionListener(e -> {
            infix.append('.');
            flag = false;
            jTextField.setText(infix.toString());
        });
        clear.addActionListener(e -> infix = new StringBuilder("0"));

        jPanel1.add(rem);
        jPanel1.add(div);
        jPanel1.add(mul);
        jPanel1.add(del);
        jPanel1.add(seven);
        jPanel1.add(eight);
        jPanel1.add(nine);
        jPanel1.add(add);
        jPanel1.add(four);
        jPanel1.add(five);
        jPanel1.add(six);
        jPanel1.add(sub);
        jPanel1.add(one);
        jPanel1.add(two);
        jPanel1.add(three);
        jPanel1.add(equal);
        jPanel1.add(zero);
        jPanel1.add(dec);
        jPanel1.add(lb);
        jPanel1.add(rb);
        //jPanel2.add(jLabel);
        jPanel2.add(jTextField);
        jTextField.setText(infix.toString());

        jFrame.setBounds(0, 0, 500, 700);
        jFrame.setJMenuBar(jMenuBar);
        jFrame.setLocation(500, 100);
        jFrame.add(jPanel2);
        jFrame.add(jPanel1);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    //计算后缀表达式
    private static String evaluation(String str) {
        Stack<Double> stack = new Stack<>();
        StringBuilder sum = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (tmp >= '0' && tmp <= '9' || tmp == '.') {
                sum.append(tmp);
                flag = true;
                continue;
            }
            if (tmp == ' ') {
                if (flag) {
                    stack.push(Double.parseDouble(sum.toString()));//当前值入栈
                    flag = false;
                }
                sum = new StringBuilder();//置空
            } else {
                if (stack.size() <= 1) {
                    stack.push(stack.peek());
                }
                switch (tmp) {
                    case '+':
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case '*':
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case '-':
                        double n = stack.pop();
                        double m = stack.pop();
                        stack.push(m - n);
                        break;
                    case '/':
                        n = stack.pop();
                        m = stack.pop();
                        if (n == 0) {
                            return "ILLEGAL";
                        }
                        stack.push(m / n);
                        break;
                    case '%':
                        n = stack.pop();
                        m = stack.pop();
                        if (n == 0) {
                            return "ILLEGAL";
                        }
                        stack.push(m % n);
                        break;
                }
            }

        }
        return stack.pop() + "";
    }

    //将中缀表达式转换为后缀表达式
    private static String transition(String str) {
        Stack<Character> stack = new Stack<>();//操作符栈
        StringBuilder sb = new StringBuilder();//最终后缀表达式
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9' || ch == '.') {
                sb.append(ch);
            } else {
                sb.append(' ');//区分每个数字
                //栈为空直接入栈
                if (stack.empty() || ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    //假设输入的表达式合法,将左右括号直接的操作符全部出栈
                    while (!stack.empty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();//去掉栈顶左括号
                } else {
                    //ch为+或-直接出栈
                    if (ch == '+' || ch == '-') {
                        while (!stack.empty() && stack.peek() != '(') {
                            sb.append(stack.pop());
                        }
                        stack.push(ch);
                    } else {
                        //栈顶为+ -直接入栈,* / %出栈
                        while (!stack.empty() && (stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '%')) {
                            sb.append(stack.pop());
                        }
                        stack.push(ch);
                    }
                }
            }
        }
        sb.append(' ');
        //将剩余操作符加入最终表达式
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return evaluation(sb.toString());
    }

}
