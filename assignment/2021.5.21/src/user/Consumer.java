package user;

import operation.*;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-22
 * Time: 21:15
 */
public class Consumer extends User {

    public Consumer(String name) {
        super(name);
        this.iOperations = new IOperation[]{
                new ExitOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation(),
                new DisplayOperation()};
    }
    public int menu () {
        System.out.println("用户菜单");
        System.out.println("hello "+this.name+" 欢迎使用图书管理系统");
        System.out.println("===================================");
        System.out.println("1.查找书籍");
        System.out.println("2.借阅书籍");
        System.out.println("3.归还书籍");
        System.out.println("4.展示书籍");
        System.out.println("5.切换用户");
        System.out.println("0.退出系统");
        System.out.println("===================================");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
