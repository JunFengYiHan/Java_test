package 笔试练习.密码强度;

import java.util.Scanner;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-21
 * Time: 19:14
 */
public class Main {
    static boolean nu = false;
    static boolean sy = false;
    static boolean up = false;
    static boolean lo = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            System.out.println(grade(str));
        }
        sc.close();
    }

    public static String grade(String str) {
        int score = lengthGrade(str) + wordGrade(str) + numGrade(str) + symbolGrade(str);
        int tmp = 0;
        if (nu&&(lo||up)) {
            tmp = 2;
        }
        if (nu&&(lo||up)&&sy) {
            tmp = 3;
        }
        if (nu&&lo&&up&&sy) {
            tmp = 5;
        }
        nu=false;
        lo=false;
        up=false;
        sy=false;
        score+=tmp;
        System.out.println(score);
        if (score>=90) {
            return "VERY_SECURE";
        }else if (score>=80) {
            return "SECURE";
        }else if (score>=70) {
            return "VERY_STRONG";
        }else if (score>=60) {
            return "STRONG";
        }else if(score>=50) {
            return "AVERAGE";
        }else if (score>=25) {
            return "WEAK";
        }else {
            return "VERY_WEAL";
        }
    }
    //长度得分
    public static int lengthGrade(String s) {
        if (s.length()<=4) {
            return 5;
        }else if (s.length()<=7) {
            return 10;
        }else{
            return 25;
        }
    }
    //字母得分
    public static int wordGrade(String s) {
        int lower = 0;
        int upper = 0;
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp>='A'&&tmp<='Z') {
                upper = 1;
                up = true;
            }else if (tmp>='a'&&tmp<='z') {
                lower = 1;
                lo = true;
            }
            if (lower+upper==2) {
                break;
            }
        }
        return 10*(lower+upper);
    }
    //数字得分
    public static int numGrade(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp>='0'&&tmp<='9') {
                num++;
                nu = true;
            }
            if (num == 2) {
                break;
            }
        }
        return 10*num;
    }
    //符号得分
    public static int symbolGrade(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp>=0x21&&tmp<=0x2F || tmp>=0x3A&&tmp<=0x40 || tmp>=0x5B&&tmp<=0x60 || tmp>=0x7B&&tmp<=0x7E) {
                count++;
                sy = true;
            }
            if (count>1) {
                return 25;
            }
        }
        return 10*count;
    }
}
