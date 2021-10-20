package 其他练习.学校练习;

import 其他练习.学校练习.第4次作业.TestString;
import 其他练习.学校练习.第5次作业.Circle;
import 其他练习.学校练习.第5次作业.Cylinder;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-09-18
 * Time: 17:13
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        double h = sc.nextDouble();
        Cylinder cylinder = new Cylinder(r,h);
        cylinder.dispVol();
//        Circle circle = new Circle(5);
//        System.out.println(circle.getRadius());
//        System.out.println(circle.getPerimeter());
//        System.out.println(circle.getArea());
//        circle.disp();
//        System.out.println(TestString.statistics("ddejidsEFALDFfnef2357 3ed"));

//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        System.out.println(str+" 加密之后为 "+TestString.encryption(str,3));
//        String str = "this is a test of java";
//        char ch = 's';
//        System.out.println("字母"+ch+"在"+str+"中出现的次数为"+TestString.statistics(str,ch));
//
//        String s = "is";
//        System.out.println("字串"+s+"在"+str+"中出现的次数为"+TestString.statistics(str,s));
//
//        System.out.println("单词"+s+"在"+str+"中出现的次数为"+TestString.statisticsWord(str,s));
//
//        System.out.println(str+"的倒序输出结果为"+TestString.reverse(str));

//        Account account = new Account("张三",100);
//        System.out.println("标识符: " + account.getFlag());
//        System.out.println("客户名称: " + account.getName());
//        System.out.println("初始余额: " + account.getBalance());
//        System.out.println("初始密码: " + account.getPassword());
//        System.out.println("开户日期: " + account.getDate());
//        System.out.println("=======================");
//        account.setName("李四");//修改账户名为李四
//        System.out.println("修改后客户名称: " + account.getName());
//        account.deposit(45);//存入45
//        System.out.println("存款后余额: " + account.getBalance());
//        account.withdrawal(50);//取出50
//        account.withdrawal(150);//取出150,会提示余额不足
//        System.out.println("取款后余额: " + account.getBalance());
//        account.setPassword("147258");//修改密码为147258
//        System.out.println("修改后的密码密码: " + account.getPassword());



//        Rectangle rectangle = new Rectangle(8,10,"红色");
//        System.out.println("初始宽为 " + rectangle.getWidth());
//        System.out.println("初始高为 " + rectangle.getHeight());
//        System.out.println("初始面积为: " + rectangle.getArea());
//        System.out.println("初始周长为 " + rectangle.getLength());
//        System.out.println("初始颜色为 " + rectangle.getColor());
//        System.out.println("===================================");
//        rectangle.setWidth(4);
//        rectangle.setHeight(5);
//        rectangle.setColor("白色");
//        System.out.println("修改后宽为 " + rectangle.getWidth());
//        System.out.println("修改后高为 " + rectangle.getHeight());
//        System.out.println("修改后面积为: " + rectangle.getArea());
//        System.out.println("修改后周长为 " + rectangle.getLength());
//        System.out.println("修改后颜色为 " + rectangle.getColor());


//        Student s1 = new Student("20208988","刘豪",88,69,95);
//        System.out.println("学号 " + s1.getId());
//        System.out.println("姓名 " + s1.getName());
//        System.out.println("总分: " + s1.sum());
//        System.out.println("平均分: " + s1.average());
//        System.out.println("最高分: " + s1.getMaxScore());
//        System.out.println("最低分: " + s1.getMinScore());

        //narNum(7);
        //func();
        //fact(20);
        //sum(8,10);
        //perfectNum(1000);
        //findMaxNum(8888);
        //print(5);
    }

}
