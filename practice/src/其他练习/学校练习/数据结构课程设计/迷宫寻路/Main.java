package 其他练习.学校练习.数据结构课程设计.迷宫寻路;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-12-03
 * Time: 13:05
 */
class Node {
    int row;
    int col;
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        while (m != -1 && n != -1) {
            int[][] arr = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            m = sc.nextInt();
            n = sc.nextInt();
        }
    }
}
