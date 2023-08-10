package demo2;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/3
 * Time: 22:52
 */

public class FileDemo1 {

    public static void main(String[] args) {

        try (InputStream inputStream = new FileInputStream("text.txt")) {
            while (true) {
                int b = inputStream.read();
                if (b == -1) {
                    break;
                }
                System.out.print((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        File file = new File("./text.txt");
//        //创建文件
//        System.out.println(file.createNewFile());
        //创建实例,相当于打开文件
//        InputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream("text.txt");
//            while (true) {
//                //默认读取一个字节
//                int b = inputStream.read();
//                //文件结束标志EOF,值为-1
//                if (b == -1) {
//                    break;
//                }
//            }
//            //需要关闭资源,否则会造成资源泄露
//            //举个例子,每个文件都有一个文件描述符(一个较小的整数值)
//            //但是每个PCB的文件描述符表的大小有限
//            //如果一直不释放的话可能导致符表占满,占满之后就无法打开文件了
//            //文件符表的大小可以自定义大小(Linux使用ulimit指令)
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
