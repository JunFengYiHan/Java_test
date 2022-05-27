package sql.bookmanagement;

import sql.bookmanagement.operations.*;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-05-17
 * Time: 10:21
 */
public class Normal extends User {
    public Normal() {
        this.iOperations = new IOperation[]{
                new ExitOperation(),
                new DisplayOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation(),
        };
    }

    @Override
    public int menu() {
        System.out.println("================================");
        System.out.println("欢迎使用," + this.getUserName());
        System.out.println("1.查看书籍列表");
        System.out.println("2.查找指定书籍");
        System.out.println("3.借阅书籍");
        System.out.println("4.归还书籍");
        System.out.println("0.退出系统/切换账户");
        System.out.println("================================");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int input = scanner.nextInt();
            if (input < 0 || input > 4) {
                System.out.println("输入错误,请重新输入");
                continue;
            }
            return input;
        }
    }

}
