//package leetcode;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-02
// * Time: 13:15
// */
////class Solution {
////    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
////        for (; k > 0; k--) {
////               还可以记录前一个数据进行逐个替换
////            int[][] newGrid = new int[grid.length][grid[0].length];
////            for (int row = 0; row < grid.length; row++) {
////                for (int col = 0; col < grid[row].length - 1; col++) {
////                    newGrid[row][col] = grid[row][col + 1];
////                }
////            }
////            for (int row = 0; row < grid.length - 1; row++) {
////                newGrid[row + 1][0] = grid[row][0];
////            }
////            newGrid[0][0] = grid[grid.length - 1][grid[0].length - 1];
////            grid = newGrid;
////        }
////        List<List<Integer>> lists = new ArrayList<>();
////        for (int[] row : grid) {
////            List<Integer> col = new ArrayList<>();
////            lists.add(col);
////            for (int data : row) {
////                col.add(data);
////            }
////        }
////        return lists;
////    }
////}
//public class 二维网格迁移 {
//    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
//        k%=grid.length*grid[0].length;//防止k过大重复移动
//        int[][] newGrid = new int[grid.length][grid[0].length];
//        for(int i=0;i<grid.length;i++){
//            for(int j=0;j<grid[0].length;j++){
//                //求取新的行和列，只移动一次
//                int row = (i+(k+j)/grid[0].length)%grid.length;
//                int col = (k+j)%grid[0].length;
//                //int prev = grid[row][col];
//                newGrid[row][col] = grid[i][j];
//                //grid[i][j] = prev;
//            }
//        }
//        List<List<Integer>> result = new ArrayList();
//        for(int[] row:grid){
//            List<Integer> listRow = new ArrayList();
//            result.add(listRow);
//            for(int col:row){
//                listRow.add(col);
//            }
//        }
//        return result;
//    }
//}
