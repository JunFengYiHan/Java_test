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
public class ReturnOperation implements IOperation{
    @Override
    public void work() {
        //System.out.println("归还书籍");
        System.out.println("请输入要归还的书籍id:> ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        BookDAO bookDAO = new BookDAO();
        boolean ret = bookDAO.returnBook(input);
        if(ret) {
            System.out.println("归还成功");
        }else{
            System.out.println("归还失败");
        }
    }
}
