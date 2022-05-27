package sql.bookmanagement.operations;

import sql.bookmanagement.Book;
import sql.bookmanagement.BookDAO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-05-17
 * Time: 10:29
 */
public class DisplayOperation implements IOperation{
    @Override
    public void work() {
        //System.out.println("显示所有书籍");
        BookDAO bookDAO = new BookDAO();
        List<Book> books = bookDAO.selectALL();
        for(Book book:books) {
            System.out.println(book);
        }
    }
}
