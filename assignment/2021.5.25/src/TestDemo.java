import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-25
 * Time: 13:35
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String str1 = "";
        String[] strs = str.split(" ");
        for (String s:strs) {
            str1+=s;
        }
        System.out.println(str1);
    }
    public static void main1(String[] args) {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
//        String str1 = "hello";
//        String str2 = new String("hello");
//        //str2.intern();
//        String str3 = "he" +"llo";
//        System.out.println(str2);
//
//
//        System.out.println(str1 == str2);
//        System.out.println(str1 == str3);
//        String s1="abc"+"def";//1
//        String s2=new String(s1);//2
//        if(s1.equals(s2))//3
//            System.out.println(".equals succeeded");//4
//        if(s1==s2)//5
//            System.out.println("==succeeded");//6
    }
}
