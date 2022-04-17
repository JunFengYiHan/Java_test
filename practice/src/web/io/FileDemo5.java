package web.io;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-04-17
 * Time: 19:17
 */
public class FileDemo5 {
    private static List<File> list = new LinkedList<>();

    public static void getRootAllFile(File rootFIle, String token) {
        File[] files = rootFIle.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        for (File f : files) {
            if (f.isDirectory()) {
                getRootAllFile(f, token);
            } else {
                if (f.getName().contains(token)) {
                    list.add(f);
                } else if (isContains(f, token)) {
                    list.add(f);
                }
            }
        }
    }

    private static boolean isContains(File file, String token) {
        StringBuilder sb = new StringBuilder();
        try (InputStream input = new FileInputStream(file);
             Scanner scanner = new Scanner(input,"UTF-8")) {
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                sb.append(str + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.indexOf(token) != -1;//找不到为-1
    }

    public static void main(String[] args) throws IOException {
        System.out.print("请输入一个绝对路径:");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        File file = new File(path);
        if(!file.isDirectory()) {
            System.out.println("输入错误,程序退出");
            return;
        }
        System.out.print("请输入关键字: ");
        String token = scanner.nextLine();
        getRootAllFile(file,token);
        for(File f:list) {
            System.out.println("是否要删除(Y/N):"+f.getCanonicalPath());
            String input = scanner.nextLine();
            if("Y".equalsIgnoreCase(input)) {
                f.delete();
            }
        }
    }
}
