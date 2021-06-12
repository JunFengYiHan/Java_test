import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-04-09
 * Time: 22:21
 */
public class TestDome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println("最大值是"+max3(a, b, c));
    }
    public static int max3(int x, int y, int z){
        return max2(max2(x, y), z);
    }
    public static int max2(int x, int y){
        return x > y ? x:y;
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fact(n));
    }
    public static int sumAddNumFact(int n){
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += fact(i);
        }
        return sum;
    }
    public static int fact(int n){
        int fact_sum = 1;
        for (int i = 1; i <= n; i++) {
            fact_sum*=i;
        }
        return fact_sum;
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fab(n));
    }
    public static int fab(int n){
        int n1 = 1;
        int n2 = 1;
        while(n > 2){
            n--;
            n2 = n1 + n2;
            n1 = n2 - n1;
        }
        return n2;
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("出现一次的数字是"+findNum(str));
    }
    public static int findNum(String str){
        int n = Integer.valueOf(str);
        int num = 0;
        while(n>0){
            num ^= n%10;
            n/=10;
        }
        return num;
    }
}
