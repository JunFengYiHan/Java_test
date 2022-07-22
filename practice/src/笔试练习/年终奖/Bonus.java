package 笔试练习.年终奖;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/7/22
 * Time: 23:25
 */
public class Bonus {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36},};
        System.out.println(new Bonus().getMost(arr));
    }

    public int getMost(int[][] board) {
        return getMax(0, 0, board);
    }

    //只能向下或者右走
    private int getMax(int i, int j, int[][] board) {
        //到了右下
        if (i == 5 && j == 5) {
            return board[i][j];
        }
        //到了最下一行
        if (i == 5) {
            return board[i][j] + getMax(i, j + 1, board);
        }
        //到了最右一列
        if (j == 5) {
            return board[i][j] + getMax(i + 1, j, board);
        }
        //左右取大的一个
        return board[i][j] + Math.max(getMax(i + 1, j, board), getMax(i, j + 1, board));
    }
}
