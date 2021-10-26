package 笔试练习.求最大连续bit数;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-26
 * Time: 10:52
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int maxCount = 0;//记录最大值
            int count = 0;//记录当前值
            for (int i = 0; i < 32; i++) {
                //判断是否为1
                if ((n & (1<<i)) !=0) {
                    count++;
                }else{
                    count = 0;
                }
                //更新最大值
                if (maxCount<count) {
                    maxCount = count;
                }
            }
            System.out.println(maxCount);
        }
    }
}
