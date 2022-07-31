package 笔试练习.美国节日;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/7/31
 * Time: 22:45
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int year = scanner.nextInt();
            System.out.println(getHoliday(year));
        }
    }

    //元旦
    static String str1 = "-01-01\n";
    //美国国庆
    static String str2 = "-07-04\n";
    //圣诞节
    static String str3 = "-12-25\n";
    static String[][] arr = {{"-01-20", "-02-17", "-05-26", "-09-01", "-11-27"},
            {"-01-21", "-02-18", "-05-27", "-09-02", "-11-28"}};
    //并非简单的闰年非闰年判断
    public static String getHoliday(int year) {
        StringBuilder sb = new StringBuilder(year + str1);
        int index = (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) ? 0 : 1;
        int i = 0;
        for (; i < 3; i++) {
            sb.append(year + arr[index][i] + "\n");
        }
        sb.append(year + str2);
        for (; i < 5; i++) {
            sb.append(year + arr[index][i] + "\n");
        }
        sb.append(year + str3);
        return sb.toString();
    }
}
