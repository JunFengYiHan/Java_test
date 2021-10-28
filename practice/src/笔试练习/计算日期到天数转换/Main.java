package 笔试练习.计算日期到天数转换;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-27
 * Time: 18:20
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        System.out.println(transition(year, month, day));
    }

    private static int transition(int year, int month, int day) {
        int[][] arr = help();//产生月份天数数组
        int flag = year%400==0||year%4==0&&year%100!=0?1:0;//判断是不是闰年
        int sum = 0;
        for (int i = 0; i < month-1; i++) {
            sum+=arr[flag][i];//叠加月,天数
        }
        return sum+day;
    }
    //产生一个月份天数数组,闰年和非闰年
    private static int[][] help() {
        int[][] arr = new int[2][12];
        for (int i = 0; i < 2; i++) {
            boolean flag = true;
            for (int j = 0; j < 12; j++) {
                if (j==1) {
                    arr[i][j] = 28 + i;
                    flag = true;
                    continue;
                }
                if (flag||j+1==7||j+1==8) {
                    arr[i][j] = 31;
                    flag = false;
                }else {
                    arr[i][j] = 30;
                    flag = true;
                }
            }
        }
        return arr;
    }
}
