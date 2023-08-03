package demo1;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/8/3
 * Time: 19:00
 */

public class FileDemo1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        //./ 表示当前目录,idea的基准目录就是当前项目所在路径
        File file = new File("./test.txt");
        //创建文件
        System.out.println(file.createNewFile());
        //父级目录
        System.out.println(file.getParent());
        //文件名,不包含路径
        System.out.println(file.getName());
        //文件路径,与定义的路径保持一致
        System.out.println(file.getPath());
        //获取绝对目录,保持所有的 ./
        System.out.println(file.getAbsolutePath());
        //获取绝对目录,将包含的 ./ 去掉
        System.out.println(file.getCanonicalPath());
        //判断文件是否存在
        System.out.println(file.exists());
        //判断当前文件是不是一个普通文件
        System.out.println(file.isFile());
        //判断当前文件是不是一个目录文件
        System.out.println(file.isDirectory());
        //休眠 观察文件的创建和删除
        Thread.sleep(2000);
        //立即删除文件
        System.out.println(file.delete());
        //当程序退出时删除文件
        //file.deleteOnExit();
        //休眠 观察文件的创建和删除
        Thread.sleep(3000);
    }
}
