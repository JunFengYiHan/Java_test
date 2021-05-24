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
public class DelOperation implements IOperation{

    @Override
    public void work(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入图书的名字:");
        String name = scanner.nextLine();
        int index = -1;
        for (int i = 0; i < bookList.getUseSize(); i++) {
            if(name.equals(bookList.getBook(i).getBookName())){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("不存在要删除的书籍！");
            return;
        }
        for (int i = index; i < bookList.getUseSize() - 1; i++) {
            bookList.setBook(i,bookList.getBook(i+1));
        }
        bookList.setUseSize(bookList.getUseSize() - 1);
        System.out.println("删除成功！");
    }
}
