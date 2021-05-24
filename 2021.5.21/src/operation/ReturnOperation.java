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
public class ReturnOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要归还的书籍");
        String name = scanner.nextLine();
        for (int i = 0; i < bookList.getUseSize(); i++) {
            if(name.equals(bookList.getBook(i).getBookName())){
                bookList.getBook(i).setBorrowed(false);
                System.out.println("归还成功！");
                return;
            }
        }
        System.out.println("归还失败，书架中没有此书记录");
    }
}
