package 笔试练习.MP3光标位置;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-11-03
 * Time: 19:27
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            String str = sc.nextLine();
            int cur = 1;
            int up = 1;
            int down = 4;
            for (int i = 0; i < str.length(); i++) {
                cur = str.charAt(i) == 'U' ? cur - 1 : cur + 1;
                //窗口之内移动
                if (cur > down) {
                    up++;
                    down++;
                }
                if (cur < up) {
                    up--;
                    down--;
                }
                //最后一首歌后面
                if (cur > n) {
                    cur = 1;
                    up = 1;
                    down = 4;
                }
                //第一首歌前面
                if (cur <= 0) {
                    cur = n;
                    up = n - 3;
                    down = n;
                }
            }
            //窗口大小小于4
            if (n <= 4) {
                for (int i = 1; i <= n; i++) {
                    System.out.print(i);
                    System.out.print(i < n ? ' ' : "\n" + cur + "\n");
                }
                continue;
            }
            System.out.print(up + " " + (up + 1) + " " + (up + 2) + " " + (up + 3) + "\n" + cur + "\n");
        }
    }
}
