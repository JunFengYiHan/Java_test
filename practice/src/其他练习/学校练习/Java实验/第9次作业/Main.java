package 其他练习.学校练习.Java实验.第9次作业;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-12-15
 * Time: 21:38
 */



class User {

    public JFrame frame;

    //用户标签，密码标签，性别标签，专业标签，兴趣标签，个人介绍标签
    public JLabel labelUser,labelPassword,labelGender,labelMajor,labelInterest,labelIntroduction;
    public JTextField textUser;//用户文本框
    public JPasswordField Password;//密码框
    public JTextArea areaIntroduction;//文本域
    public JRadioButton rbtnMen,rbtnWomen;//男女性别圆按钮
    //public JList list;//专业列表框
    public JComboBox cboxMajor;
    public JCheckBox boxProgramming,boxAI,boxNetwork,boxSystem;//兴趣复选框
    public JButton btnRegistration,btnCancel;//注册按钮，取消按钮

    public User(){
        frame=new JFrame("用户注册");

        labelUser=new JLabel("用户名：");
        labelPassword=new JLabel("密码：");
        labelGender=new JLabel("性别：");
        labelMajor=new JLabel("专业：");
        labelInterest=new JLabel("兴趣：");
        labelIntroduction=new JLabel("个人简介：");

        textUser=new JTextField();
        Password=new JPasswordField();
        areaIntroduction=new JTextArea(3,20);
        areaIntroduction.setLineWrap(true);

        rbtnMen=new JRadioButton("男");
        rbtnWomen=new JRadioButton("女");

        //st=new JList(new String[]{"计算机科学与技术","电子信息工程"});
        cboxMajor=new JComboBox(new String[]{"计算机科学与技术","电子信息工程"});

        boxProgramming=new JCheckBox("程序设计");
        boxAI=new JCheckBox("人工智能");
        boxNetwork=new JCheckBox("计算机网络");
        boxSystem=new JCheckBox("嵌入式系统");

        btnRegistration=new JButton("注册");
        btnCancel=new JButton("取消");

        frame.setLayout(null);//绝对定位

        labelUser.setBounds(5,10,70,30);//标签
        labelPassword.setBounds(5,40,70,30);
        labelGender.setBounds(5,70,70,30);
        labelMajor.setBounds(5,100,70,30);
        labelInterest.setBounds(5,130,70,30);
        labelIntroduction.setBounds(5,160,70,30);

        textUser.setBounds(75,10,180,30);//文本框
        Password.setBounds(75,40,180,30);

        rbtnMen.setBounds(75,70,80,30);//男女性别按钮
        rbtnWomen.setBounds(155,70,80,30);

        //st.setBounds(75,100,120,30);//专业列表框
        cboxMajor.setBounds(75,100,120,30);

        boxProgramming.setBounds(75,130,80,30);//兴趣复选框
        boxAI.setBounds(155,130,80,30);
        boxNetwork.setBounds(235,130,100,30);
        boxSystem.setBounds(335,130,100,30);

        areaIntroduction.setBounds(70,180,250,200);

        btnRegistration.setBounds(70,450,70,30);//注册，取消按钮
        btnCancel.setBounds(160,450,70,30);

        frame.add(labelUser);
        frame.add(labelPassword);
        frame.add(labelGender);
        frame.add(labelMajor);
        frame.add(labelInterest);
        frame.add(labelIntroduction);

        //frame.add(list);
        frame.add(cboxMajor);
        frame.add(boxProgramming);
        frame.add(boxAI);
        frame.add(boxNetwork);
        frame.add(boxSystem);

        frame.add(textUser);
        frame.add(Password);

        frame.add(rbtnMen);
        frame.add(rbtnWomen);

        frame.add(areaIntroduction);

        frame.add(btnRegistration);
        frame.add(btnCancel);

        frame.setSize(600,600);

        frame.setVisible(true);
    }
}

public class Main {
    public static void main(String[] args){
        new User();
    }
}
