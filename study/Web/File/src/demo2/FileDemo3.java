package demo2;

import java.io.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/4
 * Time: 0:50
 */

public class FileDemo3 {
    public static void main(String[] args) {
        //中英混合可以使用Java内置的Scanner
        //给Scanner指定输入流即可
        //标准输入流System.in不需要关闭,是操作系统默认打开的输入流
        try (InputStream inputStream = new FileInputStream("text.txt")) {

            Scanner scanner = new Scanner(inputStream, "UTF-8");
            while (scanner.hasNext()) {
                String s = scanner.next();
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
