package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-22
 * Time: 22:16
 */
public class AddOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入图书的名字:");
        String name = scanner.nextLine();
        System.out.println("请输入作者的名字:");
        String author = scanner.nextLine();
        System.out.println("请输入书的价格:");
        int price = scanner.nextInt();
        scanner.nextLine();//读取空行
        System.out.println("请输入图书的类型:");
        String type = scanner.nextLine();
        for (int i = 0; i < bookList.getUseSize(); i++) {
            if(name.equals(bookList.getBook(i).getBookName())){
                System.out.println("该图书已存在，请勿重复添加！");
                return;
            }
        }
        bookList.setBook(bookList.getUseSize(),new Book(name,author,price,type));
        bookList.setUseSize(bookList.getUseSize()+1);
        System.out.println("增加成功！");
    }
}
