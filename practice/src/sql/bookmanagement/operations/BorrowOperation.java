package sql.bookmanagement.operations;

import sql.bookmanagement.BookDAO;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-05-17
 * Time: 10:26
 */
public class BorrowOperation implements IOperation{
    @Override
    public void work() {
        //System.out.println("借阅书籍");
        System.out.print("请输入要借阅的书籍id:> ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        BookDAO bookDAO = new BookDAO();
        boolean ret = bookDAO.borrowBook(input);
        if(ret) {
            System.out.println("借阅成功");
        }else{
            System.out.println("借阅失败");
        }
    }
}
