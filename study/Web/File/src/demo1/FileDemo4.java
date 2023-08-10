package demo1;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/3
 * Time: 22:25
 */

public class FileDemo4 {
    public static void main(String[] args) {
        File file = new File("test/a/b");
        //File file = new File("test/a/b/c");
        //创建一个目录,不支持多级目录
        //System.out.println(file.mkdir());
        //创建一个目录,支持多级目录
        System.out.println(file.mkdirs());

        System.out.println(file.exists());

        System.out.println(file.isDirectory());
        //一次只能删除一个文件,无法直接删除多级目录文件
        System.out.println(file.delete());
    }
}
