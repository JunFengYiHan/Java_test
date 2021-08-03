package leetcode.other.有效的数独;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-08-03
 * Time: 20:59
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];//行
        int[][] col = new int[9][9];//列
        int[][] block = new int[9][9];//存放3*3的小方格是否有重复的数字出现
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                //当前元素不为空
                if (board[i][j]!='.') {
                    //判断当前行是否已经出现过该元素,数独中不存在0,所以减字符1利用0下标
                    if (++row[i][board[i][j]-'1']!=1) {
                        return false;
                    }
                    //判断当前列是否已经出现过该元素
                    if (++col[board[i][j]-'1'][j]!=1) {
                        return false;
                    }
                    //判断当前的3*3区域是否已经出现过该数字
                    if (++block[(i/3)*3+j/3][board[i][j]-'1']!=1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
//    public boolean isValidSudoku(char[][] board) {
//        boolean[][] row=new boolean[9][9];  //判断行
//        boolean[][] col=new boolean[9][9];  //判断列
//        boolean[][] region=new boolean[9][9];   //判断3×3区域
//        for(int i=0;i<9;i++){
//            for(int j=0;j<9;j++){
//                if(board[i][j]!='.'){
//                    int num=board[i][j]-'1';    //确定当前位置的数字
//                    int region_Index=i/3+j/3*3;   //确定当前子区域的索引
//                    if(row[i][num] || col[j][num] || region[region_Index][num]){
//                        return false;
//                    }
//                    else{
//                        row[i][num]=true;
//                        col[j][num]=true;
//                        region[region_Index][num]=true;
//                    }
//                }
//            }
//        }
//        return true;
//    }
}
