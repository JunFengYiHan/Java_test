package operation;

import book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-22
 * Time: 22:18
 */
public class ExitOperation implements IOperation {

    @Override
    public void work(BookList bookList) {
        System.out.println("退出系统！");
        System.exit(0);
    }
}
