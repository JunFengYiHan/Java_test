package demo4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/4
 * Time: 16:39
 */

public class FileDemo1 {
    //查找指定文件,并询问是否删除
    public static void main(String[] args) throws IOException {
        //1. 输入一个指定的根目录
        System.out.println("输入一个指定的根目录(绝对路径): ");
        Scanner scanner = new Scanner(System.in);
        String root = scanner.next();
        File rootDir = new File(root);
        //判断输入是不是一个目录
        if (!rootDir.isDirectory()) {
            System.out.println("输入错误,程序退出");
            return;
        }
        //输入关键字
        System.out.println("请输入要查找的文件(关键字): ");
        String token = scanner.next();
        //2.递归遍历目录
        //返回所有包含关键字的文件
        List<File> result = new ArrayList<>();
        scanDir(rootDir, token, result);
        //遍历结果集,给出提示,并根据输入判断是否删除
        for (File f : result) {
            System.out.println(f.getCanonicalPath() + "是否需要删除(Y/N)");
            String input = scanner.next();
            //输入Y执行删除
            if ("Y".equals(input)) {
                f.delete();
            }
        }

    }

    private static void scanDir(File rootDir, String token, List<File> result) {
        //获取当前路径下的所有文件的File对象
        File[] files = rootDir.listFiles();
        if (files == null || files.length == 0) {
            //目录为空,直接返回
            return;
        }
        for (File f : files) {
            //判断文件是否为目录文件
            if (f.isDirectory()) {
                //继续递归
                scanDir(f, token, result);
            } else if (f.isFile()) {
                //不是目录文件则判断是否包含关键字
                if (f.getName().contains(token)) {
                    //将目标文件加入结果队列
                    result.add(f);
                }

            } else {
                //非目录文件,非普通文件
            }
        }
    }
}
