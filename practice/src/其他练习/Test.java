package 其他练习;

import java.io.*;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-11-09
 * Time: 8:36
 */
public class Test {
    public static void main(String[] args) {
        String path1 = "d:" + File.separator + "test";
        File file1 = new File(path1);
//        System.out.println(file1.isAbsolute());//是不是绝对路径
//        System.out.println(file1.isDirectory());//是不是目录
//        System.out.println(file1.isFile());//是不是文件
//        System.out.println(file1.isHidden());//是不是隐藏文件
        String path2 = path1 + File.separator + "demo1.txt";
        File file2 = new File(path2);
        if (!file1.isDirectory()) {//判断是不是目录
            if (file1.mkdir()) {//创建一个目录
                if (!file2.exists()) {//判断文件是否存在
                    try {
                        file2.createNewFile();//创建一个文件
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        String str = "hello world!!";
        try {
            OutputStream fos = new FileOutputStream(file2);
            fos.write(str.getBytes());
            InputStream fis = new FileInputStream(file2);
            byte[] b = new byte[fis.available()];
            fis.read(b);
//            for (int i = 0; i < b.length; i++) {
//                b[i] = (byte)fis.read();
//            }
            System.out.println(Arrays.toString(b));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
