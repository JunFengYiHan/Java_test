package 其他练习.学校练习.数据结构课程设计.扫雷游戏;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-12-03
 * Time: 21:02
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    static int m;//行数
    static int n;//列数
    static int mine;//雷的个数
    static int count;//点击次数
    static int num;//已经点/展开了多少格子

    public static void main(String[] args) {
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] showBoard = new int[m + 2][n + 2];//展示的雷盘信息
        boolean[][] mineBoard = new boolean[m + 2][n + 2];//实际的雷盘信息
        mine = sc.nextInt();
        count = sc.nextInt();
        init(showBoard, mineBoard);
        play(showBoard, mineBoard);
        //show(showBoard);
        //show(mineBoard);
        sc.close();
    }

    private static void play(int[][] showBoard, boolean[][] mineBoard) {
        while (m * n - num != mine) {
            int i = sc.nextInt() + 1;
            int j = sc.nextInt() + 1;
            if (mineBoard[i][j]) {
                System.out.print("You lose");
                System.exit(0);
            } else if (showBoard[i][j] == -1) {
                showBoard[i][j] = getMineNum(showBoard, mineBoard, i, j);
                num++;
                spread(showBoard, mineBoard, i, j);
                show(showBoard);
            }
        }
        System.out.print("You win");
    }

    private static void show(int[][] showBoard) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(showBoard[i][j] + " ");
            }
            System.out.println();
        }
        if (m * n - num != mine) {
            System.out.println();
        }
    }

    private static void spread(int[][] showBoard, boolean[][] mineBoard, int row, int col) {
        if (row < 1 || row > m || col < 1 || col > n || showBoard[row][col] > 0) {
            return;
        }
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 1 && i <= m && j >= 1 && j <= n && !mineBoard[i][j] && showBoard[i][j] == -1) {
                    showBoard[i][j] = getMineNum(showBoard, mineBoard, i, j);
                    num++;
                    if (showBoard[i][j] == 0) {
                        spread(showBoard, mineBoard, i, j);
                    }
                }
            }
        }
    }

    private static int getMineNum(int[][] showBoard, boolean[][] mineBoard, int row, int col) {
        int ret = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 1 && i <= m && j >= 1 && j <= n && mineBoard[i][j]) {
                    ret++;
                }
            }
        }
        return ret;
    }


    private static void init(int[][] showBoard, boolean[][] mineBoard) {
        //将所以没打开的格子都置为-1
        for (int i = 0; i < showBoard.length; i++) {
            for (int j = 0; j < showBoard[i].length; j++) {
                showBoard[i][j] = -1;
            }
        }
        //将有雷的地方置为true
        for (int i = 0; i < mine; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            mineBoard[m + 1][n + 1] = true;
        }
    }
}
