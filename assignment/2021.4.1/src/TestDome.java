/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-04-01
 * Time: 20:33
 */
public class TestDome {
    public static void main(String[] args) {
        int n=123456;
        String str=String.valueOf(n);//方法转换整型为字符串
        System.out.println(str);
    }
    public static void main2(String[] args) {
        String str="12345";
        int n=Integer.valueOf(str);//方法转换字符串为整型
        System.out.println(n);
    }
    public static void main1(String[] args) {
        double n=1.1;
        System.out.println(n * n);//显示的最低为多出一个非零数，验证了浮点数并不准确的说法
    }
}
    