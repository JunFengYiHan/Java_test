package test;

import java.io.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/7
 * Time: 22:47
 */

public class Test2 {
    //进行普通文件的复制
    public static void main(String[] args) {
        System.out.println("请输入要复制的文件路径: ");
        Scanner scan = new Scanner(System.in);
        String srcPath = scan.next();
        File srcFile = new File(srcPath);
        if (!srcFile.isFile()) {
            System.out.println("路径出错");
            return;
        }
        System.out.println("请输入要复制到的目标路径: ");
        String buffPath = scan.next();
        File buffFile = new File(buffPath);
        try (InputStream inputStream = new FileInputStream(srcFile);
             OutputStream outputStream = new FileOutputStream(buffFile)) {
            while (true) {
                byte[] b = new byte[1024];
                int len = inputStream.read(b);
                if (len == -1) {
                    break;
                }
                outputStream.write(b, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("复制完成");
    }
}
