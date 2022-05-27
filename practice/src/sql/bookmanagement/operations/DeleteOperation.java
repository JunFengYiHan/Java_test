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
public class DeleteOperation implements IOperation{
    @Override
    public void work() {
        //System.out.println("删除书籍");
        System.out.print("请输入要删除的书籍id:> ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        BookDAO bookDAO = new BookDAO();
        boolean ret = bookDAO.delete(input);
        if(ret) {
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }
}
