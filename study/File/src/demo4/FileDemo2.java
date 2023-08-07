package demo4;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/4
 * Time: 16:58
 */

public class FileDemo2 {
    //复制文件
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入要复制的普通文件路径(绝对路径): ");
        String srcPath = scanner.next();
        File srcFile = new File(srcPath);
        if (!srcFile.isFile()) {
            System.out.println("路径所对应文件,并非普通文件");
            return;
        }
        System.out.println("请输入要复制到的目标路径(绝对路径): ");
        String destPath = scanner.next();
        File destFile = new File(destPath);
        //判断目标路径是否存在相同文件
        if (destFile.exists()) {
            System.out.println("目标文件存在");
            return;
        }
        //判断父目录是否存在
        if (!destFile.getParentFile().exists()) {
            //不存在
            //1.程序直接退出
            System.out.println("父目录不存在,程序退出");
            return;
            //2.创建父目录
//            destFile.getParentFile().mkdirs();
        }
        try (InputStream inputStream = new FileInputStream(srcFile);

             OutputStream outputStream = new FileOutputStream(destFile)) {

            //进行读写,按字节
            while (true) {
                byte[] b = new byte[1024];
                int len = inputStream.read(b);
                //读取完毕,退出
                if (len == -1) {
                    break;
                }
                outputStream.write(b, 0, len);
            }

//            //暂时不可行,初步猜测时Scanner无法正确识别换行,无法确定是否需要添加换行
//            Scanner scan = new Scanner(inputStream, "utf-8");
//            PrintWriter writer = new PrintWriter(outputStream);
//            while (scan.hasNext()) {
//                String s = scan.nextLine();
//                writer.println(s);
//            }

            System.out.println("复制完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
