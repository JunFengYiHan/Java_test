import java.util.Random;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-04-06
 * Time: 19:51
 */
public class TestDome {
    public static void num(int n){
        if(n>9){
            num(n/10);
        }
        System.out.print(n%10+" ");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        num(n);
    }
    public static void main11(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 3;
        String possword;
        while(count != 0){
            possword = scanner.nextLine();
            if(possword.equals("123456")){
                System.out.println("密码正确，登录成功！");
                break;
            }else{
                count--;
                if(count != 0){
                    System.out.println("密码错误，你还有"+count+"次机会");
                }else{
                    System.out.println("密码错误，程序退出！");
                }

            }
        }
    }
    public static void main10(String[] args) {
        System.out.print("请输入你猜测的数字（0-100）：");
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int randNum = rand.nextInt(100);
        while(true){
            int n = scan.nextInt();
            if(n == randNum){
                System.out.println("恭喜你，猜对了");
                break;
            }else if(n > randNum){
                System.out.println("猜大了");
            }else{
                System.out.println("猜小了");
            }
        }
    }
    public static void main9(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入要打印的乘法表的阶数：");
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%2d*%2d=%-3d", j, i, i * j);
            }
            System.out.println();
        }

    }
    public static void main8(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.print(n + "的偶数位：");
        for (int i = 31; i >= 0; i -= 2) {
            if((n&(1<<i))!=0){
                System.out.print(1);
            }else{
                System.out.print(0);
            }
        }
        System.out.println();
        System.out.print(n + "的奇数位：");
        for (int i = 30; i >= 0; i -= 2) {
            if((n&(1<<i))!=0){
                System.out.print(1);
            }else{
                System.out.print(0);
            }
        }
    }
    public static void main7(String[] args) {
        int count = 0;
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 31; i >= 0; i--) {
            if((n & (1<<i)) != 0){
                count++;
            }
        }
        System.out.println(count);
    }
    public static void main6(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        while(n % m != 0){
            int tmp = n % m;
            n = m;
            m = tmp;
        }
        System.out.println(m + "是m和n的最大公约数");
    }
    public static void main5(String[] args) {
        int flag = 1;
        double sum = 0.0;
        for (int i = 1; i <= 100; i++) {
            sum += (double)flag / i;
            flag = -flag;
        }
        System.out.println(sum);
    }
    public static void main4(String[] args) {
        for (int i = 100;  i <= 999;  i++) {
            int sum = 0;
            int n = i;
            while(n > 0){
                sum += Math.pow(n % 10, 3);
                n /= 10;
            }
            if(sum == i){
                System.out.println(i+"是水仙花数");
            }
        }
    }
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n = scanner.nextInt();
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j < n; j++) {
                    if(i == j || i + j == n - 1){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
                System.out.println("");
        }
        }
    }
    public static void main2(String[] args) {
        int fac=1;
        int num=5;
        int sum=0;
        for(int i=1;i<=num; i++){
            fac*=i;
            sum+=fac;
        }
        System.out.println(sum);
    }
    public static void main1(String[] args) {
        int sum1 = 0;
        int sum2 = 0;
        int i = 0;
        for(i=1;i<=100;i++){
            if(i%2==0){
                sum1+=i;//偶数
            }else{
                sum2+=i;//奇数
            }
        }
        System.out.println("偶数和"+sum1);
        System.out.println("奇数和"+sum2);
    }
}
