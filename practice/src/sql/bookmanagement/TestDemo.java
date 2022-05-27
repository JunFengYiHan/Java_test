package sql.bookmanagement;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-05-16
 * Time: 23:07
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            User user = login();
            while (true) {
                int choice = user.menu();
                if (choice == 0) {
                    break;
                }
                user.doOperation(choice);
            }
            System.out.println("任意键继续,再次输入0退出系统");
            int input = scanner.nextInt();
            if(input==0) {
                user.doOperation(input);
            }
        }
    }

    private static User login() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("请输入账户:> ");
            String userName = scanner.next();
            System.out.print("请输入密码:> ");
            String password = scanner.next();
            UserDAO userDAO = new UserDAO();
            User user = userDAO.selectByName(userName);
            if (user == null || !user.getPassword().equals(password)) {
                System.out.println("账号或密码错误,请重新输入");
                continue;
            }
            return user;
        }
    }
}
