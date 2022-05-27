package sql.bookmanagement.operations;

import sql.bookmanagement.Book;
import sql.bookmanagement.BookDAO;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-05-17
 * Time: 10:26
 */
public class AddOperation implements IOperation{
    @Override
    public void work() {
        //System.out.println("增加");
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入书籍名称:> ");
        String name = scanner.next();
        System.out.print("请输入书籍作者:> ");
        String author = scanner.next();
        System.out.print("请输入书籍价格:> ");
        int price = scanner.nextInt();
        System.out.print("请输入书籍类型:> ");
        String type = scanner.next();
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setPrice(price);
        book.setType(type);
        BookDAO bookDAO = new BookDAO();

        boolean ret = bookDAO.add(book);
        if(ret) {
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }
}
