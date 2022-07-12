package leetcode.每日一题.奇数值单元格的数目;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/7/12
 * Time: 23:41
 */
public class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] arr = new int[m][n];
        int count = 0;
        for (int i = 0; i < indices.length; i++) {
            int row = indices[i][0];
            int col = indices[i][1];
            for (int j = 0; j < n; j++) {
                arr[row][j] += 1;
            }
            for (int j = 0; j < m; j++) {
                arr[j][col] += 1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] % 2 != 0){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1}, {1, 1}};
        System.out.println(new Solution().oddCells(2, 3, arr));
    }
}
