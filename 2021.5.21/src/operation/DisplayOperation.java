package operation;

import book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-22
 * Time: 22:17
 */
public class DisplayOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
//        System.out.println("打印书籍");
        for (int i = 0; i < bookList.getUseSize(); i++) {
            System.out.println(bookList.getBook(i));
        }
    }
}
