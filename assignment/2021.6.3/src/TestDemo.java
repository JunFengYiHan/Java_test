import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-03
 * Time: 19:59
 */
public class TestDemo {
    public static void main(String[ ]ages){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(0));
            for(int i = 1;i<str.length();i++){
                if(!sb.toString().contains(str.charAt(i)+"")){
                    sb.append(str.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
