package web.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-04-16
 * Time: 15:57
 */
public class FileDemo {
    public static List<String> result = new ArrayList<>();

    public static void getAllFile(String basePath) {
        File file = new File(basePath);
        if (file.isFile()) {
            result.add(basePath);
            //return;
        } else if (file.isDirectory()) {

            String[] files = file.list();
            //if(files==null) return;

            for (String path : files) {
                getAllFile(basePath + File.separator + path);
            }
        } else {
            //不是普通文件,也不是目录文件,而是socket,管道,设备块文件
        }
    }

    public static void main(String[] args) {
//        String path = "." + File.separator;
//        getAllFile(path);
//        for(String s:result) {
//            System.out.println(s);
//        }

        System.out.println(File.separator);
        System.out.println(File.pathSeparator);
    }


}
