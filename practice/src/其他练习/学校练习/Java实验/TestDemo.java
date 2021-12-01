package 其他练习.学校练习.Java实验;

import 其他练习.学校练习.Java实验.第6次作业.*;
import 其他练习.学校练习.Java实验.第7次作业.DangerException;
import 其他练习.学校练习.Java实验.第7次作业.Goods;
import 其他练习.学校练习.Java实验.第7次作业.Machine;
import 其他练习.学校练习.Java实验.第8次作业.*;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-09-18
 * Time: 17:13
 */
public class TestDemo {
    public static void main(String[] args) {
        Info info = new Info();
        MyThread4 m4 = new MyThread4(info);
        MyThread5 m5 = new MyThread5(info);
        new Thread(m4).start();
        new Thread(m5).start();

//        MyThread3 m1 = new MyThread3(1,25);
//        MyThread3 m2 = new MyThread3(26,50);
//        MyThread3 m3 = new MyThread3(51,75);
//        MyThread3 m4 = new MyThread3(76,100);
//        new Thread(m1).start();
//        new Thread(m2).start();
//        new Thread(m3).start();
//        new Thread(m4).start();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(m1.getSum()+m2.getSum()+m3.getSum()+m4.getSum());


//        Windows w = new Windows();
//
//        new Thread(w,"窗口A").start();
//        new Thread(w,"窗口B").start();
//        new Thread(w,"窗口C").start();

//        MyThread1 mt1 = new MyThread1();
//        MyThread2 mt2 = new MyThread2();
//        new Thread(mt1).start();
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        new Thread(mt2).start();

//        Goods g1 = new Goods("矿泉水");
//        Goods g2 = new Goods("毒品");
//        Goods g3 = new Goods("管制刀具");
//        Machine machine = new Machine();
//        try {
//            machine.checkBag(g1);
//            machine.checkBag(g2);
//            machine.checkBag(g3);
//        } catch (DangerException e) {
//            e.toShow();
//            System.out.println("危险物品已处理");
//        }


//        Shape s1 = new Straight(10);
//        Shape s2 = new Circle(10);
//        System.out.println("直线的大小为 "+s1.size());
//        System.out.println("圆的大小为 "+s2.size());
//        Shapes s1 = new Triangle(6,8,10);
//        Shapes s2 = new Rectangle(4,5);
//        Shapes s3 = new Circle(5);
//        System.out.println("三角形的面积为: "+s1.getArea());
//        System.out.println("矩形的面积为 "+s2.getArea());
//        System.out.println("圆形的面积为: "+s3.getArea());


//        Scanner sc = new Scanner(System.in);
//        double r = sc.nextDouble();
//        double h = sc.nextDouble();
//        Cylinder cylinder = new Cylinder(r,h);
//        cylinder.dispVol();
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


//        Rectangle s2 = new Rectangle(8,10,"红色");
//        System.out.println("初始宽为 " + s2.getWidth());
//        System.out.println("初始高为 " + s2.getHeight());
//        System.out.println("初始面积为: " + s2.getArea());
//        System.out.println("初始周长为 " + s2.getLength());
//        System.out.println("初始颜色为 " + s2.getColor());
//        System.out.println("===================================");
//        s2.setWidth(4);
//        s2.setHeight(5);
//        s2.setColor("白色");
//        System.out.println("修改后宽为 " + s2.getWidth());
//        System.out.println("修改后高为 " + s2.getHeight());
//        System.out.println("修改后面积为: " + s2.getArea());
//        System.out.println("修改后周长为 " + s2.getLength());
//        System.out.println("修改后颜色为 " + s2.getColor());


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
