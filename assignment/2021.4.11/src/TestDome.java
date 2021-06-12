import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-04-11
 * Time: 12:31
 */
public class TestDome {
    public static int factorial(int n) {
        if(n>1){
            return n*factorial(n-1);
        }else{
            return 1;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(factorial(n));
    }
    public static int addNum(int n) {
        if (n>1){
            return n+addNum(n-1);
        }else{
            return n;
        }
    }
    public static void main6(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(addNum(n));
    }

    public static void print(int n) {
        if(n>9){
            print(n/10);
        }
        System.out.print(n%10+" ");
    }
    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        print(n);
    }

    public static int add(int n){
        if(n>9){
            return add(n/10) + n%10;
        }
        return n;
    }
    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(add(n));
    }

    public static int fibo(int n){
        if(n<=2){
            return 1;
        }
        return fibo(n-1)+fibo(n-2);
    }
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fibo(n));
    }

    public static void move(char pos1,char pos3){
        System.out.print(pos1+"->"+pos3+" ");
    }
    /**
     * @param n 盘子的个数
     * @param pos1 第一根柱子 有 开始盘子所在柱子
     * @param pos2 第二根柱子 空
     * @param pos3 第三根柱子 空 最后盘子所在柱子
     */
    public static void hanoi(int n,char pos1,char pos2,char pos3){
        if(n==1){
            move(pos1,pos3);
        }else {
            hanoi(n - 1, pos1, pos3, pos2);
            move(pos1, pos3);
            hanoi(n - 1, pos2, pos1, pos3);
        }
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int n = scanner.nextInt();
        hanoi(1,'A','B','C');
        System.out.println();
        hanoi(2,'A','B','C');
        System.out.println();
        hanoi(3,'A','B','C');
        System.out.println();
        hanoi(4,'A','B','C');
        System.out.println();
        hanoi(5,'A','B','C');
    }

    public static int jumpFloor(int n){
        if(n<=2){
            return n;
        }
        return jumpFloor(n-1)+jumpFloor(n-2);
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int n = scanner.nextInt();
        System.out.println(jumpFloor(1));
        System.out.println(jumpFloor(2));
        System.out.println(jumpFloor(3));
        System.out.println(jumpFloor(4));
    }
}
