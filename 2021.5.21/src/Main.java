import book.BookList;
import user.Admin;
import user.Consumer;
import user.User;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-21
 * Time: 20:21
 */
public class Main {
    public static User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名");
        String name = scanner.nextLine();
        System.out.println("请选择身份 1->管理员，2->普通用户");
        int choice = scanner.nextInt();
        if(choice == 1){
            return new Admin(name);
        }else{
            return new Consumer(name);
        }
    }
    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login();
        while(true){
            int choice = user.menu();
            user.doOperation(choice,bookList);
        }
    }
}
