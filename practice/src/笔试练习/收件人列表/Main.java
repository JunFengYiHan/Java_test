package 笔试练习.收件人列表;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/8/3
 * Time: 23:39
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            StringBuilder sb = new StringBuilder();
            int n = scanner.nextInt();
            scanner.nextLine();//读掉换行
            for (int i = 0; i < n; i++) {
                String str = scanner.nextLine();
                if (str.contains(" ") || str.contains(",")) {
                    sb.append("\"");
                    sb.append(str);
                    sb.append("\", ");
                } else {
                    sb.append(str + ", ");
                }
            }
            sb.delete(sb.length() - 2, sb.length());
            System.out.println(sb.toString());
        }
    }
}
