package demo1;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/3
 * Time: 22:37
 */

public class FileDemo5 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("test/hello.txt");
        File file2 = new File("test/text.txt");
        File file3 = new File("test/a/text.txt");
        //file1.createNewFile();

        //修改file1的名字和位置为file2的名字和位置
        //System.out.println(file1.renameTo(file2));

        //修改file1的名字和位置为file3的名字和位置
        System.out.println(file1.renameTo(file3));
    }
}
