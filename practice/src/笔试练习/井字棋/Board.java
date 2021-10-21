package 笔试练习.井字棋;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-21
 * Time: 19:02
 */
public class Board {
    public boolean checkWon(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0]==board[i][1]&&board[i][1]==board[i][2]&&board[i][1]==1) {
                return true;
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j]==board[1][j]&&board[1][j]==board[2][j]&&board[1][j]==1) {
                return true;
            }
        }
        if (board[0][0]==board[1][1]&&board[1][1]==board[2][2]&&board[1][1]==1) {
            return true;
        }
        if (board[0][2]==board[1][1]&&board[1][1]==board[2][0]&&board[1][1]==1) {
            return true;
        }
        return false;
    }
}
