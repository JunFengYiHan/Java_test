package demo2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/4
 * Time: 0:38
 */

public class FileDemo2 {
    public static void main(String[] args) {
        //一次性读取多个字节,较为节省性能,减少了io操作
        try (InputStream inputStream = new FileInputStream("text.txt")) {
            byte[] buff = new byte[1024];
            while (true) {

                int len = inputStream.read(buff);
                //判断是否读到末尾EOF
                if (len == -1) {
                    break;
                }
//                for (int i = 0; i < len; i++) {
//                    //格式化输出字符,ASCII编码值打印,无法准确打印中文
//                    System.out.printf("%c", buff[i]);
//                }
                //纯中文使用下面的写法可以满足,
                // 因为在UTF-8中使用三个字节描述中文
                //但是无法适用中英混合
                for (int i = 0; i < len; i+=3) {
                    String s = new String(buff,i,3,"UTF-8");
                    System.out.println(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
