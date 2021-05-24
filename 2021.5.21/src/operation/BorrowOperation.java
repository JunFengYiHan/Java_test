package operation;

import book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-22
 * Time: 22:18
 */
public class BorrowOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入你要借阅的书名:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        for (int i = 0; i < bookList.getUseSize(); i++) {
            if(!bookList.getBook(i).isBorrowed() && name.equals(bookList.getBook(i).getBookName())){
                bookList.getBook(i).setBorrowed(true);
                System.out.println("借阅成功");
                return;
            }
        }
        System.out.println("借阅失败，该书已被借出或不存在该书！");
    }
}
