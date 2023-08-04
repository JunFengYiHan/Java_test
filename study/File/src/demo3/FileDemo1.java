package demo3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/4
 * Time: 1:23
 */

public class FileDemo1 {
    public static void main(String[] args) {
        //使用OutputStream写入新的数据,会覆盖旧的数据
        //文件不存在则会创建文件
        try (OutputStream outputStream = new FileOutputStream("./text.txt")) {
            //一次性写入一个字符
//            outputStream.write('a');
//            outputStream.write('b');
//            outputStream.write('c');
//            outputStream.write('d');
            //一次性写入一个byte数组
//            byte[] b = new byte[]{(byte) 'a', (byte) 'b', (byte) 'c', (byte) 'd'};
//            outputStream.write(b);
            String s = "z张三";
            outputStream.write(s.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
