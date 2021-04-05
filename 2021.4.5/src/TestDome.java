/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-04-05
 * Time: 19:46
 */
import java.util.Scanner;
public class TestDome {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        for(i = 1;i <= 9;i++){
            for(j = 1;j <= 9;j++){
                System.out.printf("%2d*%2d=%-3d", j, i, i*j);
            }
            System.out.println("");
        }
    }
    public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        int age = scan.nextInt();
        if(age<=18){
            System.out.println("少年");
        }else if(age<=28){
            System.out.println("青年");
        }else if(age<=55){
            System.out.println("中年");
        }else{
            System.out.println("老年");
        }
    }
    public static void main1(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
        int i=0;
        for (i = 2; i < n; i++) {
           if(n%i==0){
               break;
           }
        }
        if(n==2 || i==n){
            System.out.println(n+"是素数");
        }else{
            System.out.println(n + "不是素数");
        }
    }
}
