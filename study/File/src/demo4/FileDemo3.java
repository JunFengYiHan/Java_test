package demo4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/4
 * Time: 17:42
 */

public class FileDemo3 {
    //查询指定目录中的文件名和文件内容中是否包含关键字
    public static void main(String[] args) throws IOException {
        //1. 指定输入路径
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查询的根目录: ");
        String rootDir = scanner.next();
        File rootFile = new File(rootDir);
        if (!rootFile.isDirectory()) {
            System.out.println("目录不存在,或者不是目录文件");
            return;
        }
        //2.输入关键字
        System.out.println("输入要查询的关键字: ");
        String token = scanner.next();
        //3.扫描目录文件和普通文件内容
        List<File> result = new ArrayList<>();
        scanDirWithContent(rootFile, token, result);
        //打印遍历结果
        for (File f : result) {
            System.out.println(f.getCanonicalPath());
        }
    }

    private static void scanDirWithContent(File rootFile, String token, List<File> result) {
        //获取当前目录下的所有文件
        File[] files = rootFile.listFiles();
        //不存在文件
        if (files == null || files.length == 0) {
            return;
        }
        for (File f : files) {
            //目录文件,继续递归
            if (f.isDirectory()) {
                scanDirWithContent(f, token, result);
            } else if (f.isFile()) {
                //判断名字和内容是否包含关键字
                if (f.getName().contains(token) || isContains(f, token)) {
                    result.add(f);
                }
            }
        }
    }
    //判断文件内容中是否包含关键字
    private static boolean isContains(File f, String token) {
        StringBuilder sb = new StringBuilder();
        try (InputStream inputStream = new FileInputStream(f)) {
            Scanner scanner = new Scanner(inputStream, "utf-8");
            //获取文件的所有内容,判断是否包含token
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                sb.append(s + '\n');
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //存在则会返回开始下标,不存在则会返回负一
        return sb.indexOf(token) != -1;
    }
}
