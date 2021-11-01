package 笔试练习.汽水瓶;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-11-01
 * Time: 18:21
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int count = 0;//喝了多少瓶

            while (n > 2) {
                int tmp = n / 3;//当前空瓶子的个数
                count += tmp;
                n = n % 3 + tmp;
            }
            count += n == 2 ? 1 : 0;
            System.out.println(count);
        }
    }
}
