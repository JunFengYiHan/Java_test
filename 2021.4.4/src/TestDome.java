import sun.java2d.SurfaceDataProxy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-04-04
 * Time: 15:10
 */
public class TestDome {
    public static void main(String[] args) {
        int n=-10;
        System.out.println(n>>>1);
    }
    public static void main8(String[] args) {
        float n1=1.1f;
        long n2=2;
        float n3=n1*n2;
        System.out.println(n3);
    }
    public static void main7(String[] args) {
        byte n1=10;//0000 1010
        byte n2=6; //0000 0110
        //n1&n2的结果0000 0010->2
        System.out.println(n1&n2);
        //n1|n2的结果0000 1110->14
        System.out.println(n1|n2);
        //n1^n2的结果0000 1100->12
        System.out.println(n1^n2);
        //~n1  的结果1111 0101->1000 1011->-11
        System.out.println(~n1);
        //~n2  的结果1111 1001->1000 0111->-7
        System.out.println(~n2);
    }
    public static void main6(String[] args) {
        double n1=12.5;
        double n2=2.0;
        System.out.println(n1%n2);
    }
    public static void main5(String[] args) {
        int a=1;
        int b=2;
        int c=3;
        System.out.println(a<b&b<c);
    }
    public static void main4(String[] args) {
        byte n1=1;
        byte n2=1;
        //byte n3=n1+n2;
        byte n3=(byte)(n1+n2);
    }
    public static void main3(String[] args) {
        //float n=1.1;
        float n=1.1f;
    }
    public static void main2(String[] args) {
        int n=0;
        //boolean b=(boolean)n;
    }
    public static void main1(String[] args) {
        double n=1.1;
        System.out.println(n*n);
    }
}
