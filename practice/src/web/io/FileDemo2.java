package web.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-04-16
 * Time: 21:26
 */
public class FileDemo2 {
    public static void main(String[] args) {
        try(InputStream inputStream = new FileInputStream(".\\src\\web\\io\\FileDemo.java")) {
            try(Scanner scanner = new Scanner(inputStream)){
                while(scanner.hasNext()) {
                    String s = scanner.nextLine();
                    System.out.println(s);
                }
            }

        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
