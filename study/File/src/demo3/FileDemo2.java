package demo3;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/4
 * Time: 16:13
 */

public class FileDemo2 {
    public static void main(String[] args) {
        try (OutputStream outputStream = new FileOutputStream("./text.txt")) {
            try (PrintWriter printWriter = new PrintWriter(outputStream)) {
                printWriter.println("hello world");
            }
            //需要注意刷新缓冲区
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
