package demo1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/3
 * Time: 22:00
 */

public class FileDemo3 {
    public static List<String> result = new ArrayList<>();

    public static void getAllFile(String basePath) {
        File file = new File(basePath);
        //先罗列第一个文件夹,再往下
        if (file.isFile()) {
            result.add(basePath);
        } else if (file.isDirectory()) {
            String[] list = file.list();
            for (int i = 0; i < list.length; i++) {
                getAllFile(basePath + File.separator + list[i]);
            }
        } else {
            //既不是目录文件,也不是普通文件
            //如 socket文件,管道文件,设备块文件等
        }
    }

    public static void main(String[] args) {
        getAllFile(".");
        for (String s : result) {
            System.out.println(s);
        }
//        System.out.println(File.pathSeparator);
//        System.out.println(File.separator);
    }
}
