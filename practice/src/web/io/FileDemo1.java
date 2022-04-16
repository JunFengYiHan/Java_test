package web.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-04-16
 * Time: 21:10
 */
public class FileDemo1 {
    public static void main(String[] args) {
        try(InputStream inputStream = new FileInputStream(".\\src\\web\\io\\FileDemo.java")) {
            while(true) {
                int b =  inputStream.read();
                if(b==-1) break;
                System.out.printf("%c",b);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }

    }
}
