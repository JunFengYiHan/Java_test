package 其他练习.暑假作业.第1天算法题;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-12
 * Time: 10:51
 */
public class TestDemo {
    //在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个
    //函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。时间复杂度小于O(n) ,空间复杂度O(1)
    public static void main(String[] args) {
        int [][]array = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };
        System.out.println(findNum(array, 5));
    }
    private static boolean findNum(int[][]arr, int findNum) {
        //从左上角开始查找，左上角是一行中最大的，一列中最小的，每次比较都能去掉一行或者一列
        //右下角同理，其他则不行
        int i = 0;
        int j = arr.length - 1;
        //i最多到最后一行，j最多到第一列
        while(i<arr.length && j>=0) {
            if(arr[i][j]==findNum) {
                System.out.println("下标为i："+ i +" j："+j);//可以不要
                return true;
            } else if(arr[i][j]<findNum) {
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
}
