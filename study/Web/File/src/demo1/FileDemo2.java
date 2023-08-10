package demo1;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/3
 * Time: 21:51
 */

public class FileDemo2 {
    public static void main(String[] args) throws InterruptedException, IOException {
        File file = new File(".");
        //创建文件
        System.out.println(file.createNewFile());
        //返回当前目录下的所有文件名
        String[] files = file.list();
        System.out.println(Arrays.toString(files));

    }
}
