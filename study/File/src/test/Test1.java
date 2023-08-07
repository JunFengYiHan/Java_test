package test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/7
 * Time: 22:21
 */

public class Test1 {
    //扫描指定目录，并找到名称中包含指定字符的所有普通文件（不包含目录），并且后续询问用户是否要删除该文件
    public static void main(String[] args) throws IOException {
        //1. 处理根目录和关键字
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入根目录: ");
        String rootPath = scanner.next();
        File rootFile = new File(rootPath);
        if (!rootFile.isDirectory()) {
            System.out.println("根目录输入有误!");
            return;
        }
        System.out.println("请输入关键字: ");
        String keywords = scanner.next();
        //2. 开始扫描
        List<File> result = new ArrayList<>();
        scanFileWithRootPath(rootFile, result, keywords);
        //3. 呈现结果并判断是否删除
        for (File f : result) {
            System.out.println(f.getCanonicalPath() + " 是否删除(Y/N): ");
            String input = scanner.next();
            if ("Y".equals(input)) {
                f.delete();
            }
        }
    }

    private static void scanFileWithRootPath(File rootFile, List<File> result, String keywords) {
        File[] files = rootFile.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                scanFileWithRootPath(files[i], result, keywords);
            } else if (files[i].isFile()) {
                //判断名字和内容是否包含关键字
                if (files[i].getName().contains(keywords) || isContains(files[i], keywords)) {
                    result.add(files[i]);
                }

            } else {
                //非目录文件和普通文件暂时不做处理
            }
        }
    }

    private static boolean isContains(File file, String keywords) {
        StringBuilder sb = new StringBuilder();
        try (InputStream inputStream = new FileInputStream(file);
             Scanner scanner = new Scanner(inputStream)) {

            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                sb.append(s + '\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.indexOf(keywords) != -1;
    }

}
