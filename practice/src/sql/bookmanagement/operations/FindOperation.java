package sql.bookmanagement.operations;

import sql.bookmanagement.Book;
import sql.bookmanagement.BookDAO;

import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-05-17
 * Time: 10:26
 */
public class FindOperation implements IOperation{
    @Override
    public void work() {
        System.out.print("请输入要查找的书的书名:> ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        BookDAO bookDAO = new BookDAO();
        List<Book> books = bookDAO.selectByName(name);
        for(Book book:books){
            System.out.println(book);
        }
    }
}
