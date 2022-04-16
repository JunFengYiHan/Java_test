package web.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-04-16
 * Time: 22:17
 */
public class FileDemo4 {
    public static void main(String[] args) throws IOException {
        String path = ".\\test.txt";
        File file = new File(path);
        System.out.println(file.createNewFile());
        try (PrintStream printStream = new PrintStream(file)){
            printStream.println("lis");
            Thread.sleep(5000);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(file.delete());
    }
}
