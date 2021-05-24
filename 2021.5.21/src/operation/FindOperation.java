package operation;

import book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-22
 * Time: 22:16
 */
public class FindOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查找的书名:");
        String name = scanner.nextLine();
        for (int i = 0; i < bookList.getUseSize(); i++) {
            if(name.equals(bookList.getBook(i).getBookName())){
                System.out.println("找到了此书");
                System.out.println(bookList.getBook(i));
                return;
            }
        }
        System.out.println("没有找到此书籍！");
    }
}
