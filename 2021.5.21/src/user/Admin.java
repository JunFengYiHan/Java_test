package user;

import operation.*;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-22
 * Time: 21:14
 */
public class Admin extends User {

    public Admin(String name) {
        super(name);
        this.iOperations = new IOperation[]{
                new ExitOperation(),
                new FindOperation(),
                new AddOperation(),
                new DelOperation(),
                new DisplayOperation()};
    }
    public int menu () {
        System.out.println("管理员菜单");
        System.out.println("hello "+this.name+" 欢迎使用图书管理系统");
        System.out.println("===================================");
        System.out.println("1.查找书籍");
        System.out.println("2.增加书籍");
        System.out.println("3.删除书籍");
        System.out.println("4.显示书籍");
        System.out.println("5.切换用户");
        System.out.println("0.退出系统");
        System.out.println("===================================");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


}
