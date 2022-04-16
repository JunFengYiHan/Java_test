package web.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-04-16
 * Time: 21:50
 */
public class FileDemo3 {

    public static void main(String[] args) throws IOException {
        System.out.println("请输入根目录");
        Scanner scanner = new Scanner(System.in);
        String rootPath = scanner.nextLine();
        File rootDir = new File(rootPath);
        if (!rootDir.isDirectory()) {
            System.out.println("输入错误,程序退出");
        } else {
            System.out.println("请输入关键字");
            String token = scanner.nextLine();
            List<File> list = new ArrayList<>();
            getRootAllFile(rootDir, list, token);
            for (File f : list) {
                System.out.println(f.getCanonicalFile() + "是否删除(Y/N)");
                String input = scanner.nextLine();
                if ("Y".equalsIgnoreCase(input)) {
                    f.delete();
                }
            }
        }
    }

    private static void getRootAllFile(File rootDir, List<File> list, String token) {
        File[] files = rootDir.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        for (File f : files) {
            if (f.isDirectory()) {
                getRootAllFile(f, list, token);
            } else {
                list.add(f);
            }
        }
    }

}
