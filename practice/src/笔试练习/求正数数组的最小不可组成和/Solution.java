package 笔试练习.求正数数组的最小不可组成和;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/7/28
 * Time: 23:31
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4};
        System.out.println(new Solution().getFirstUnFormedNum(arr));
    }

    public int getFirstUnFormedNum(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max += arr[i];
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        //枚举所有子集
        for (int i = 1; i < Math.pow(2, arr.length); i++) {
            int sum = 0;
            int j = 0;
            //计算每个子集的和
            while (j < arr.length) {
                if ((i & (1 << j)) != 0) {
                    sum += arr[j];
                }
                j++;
            }
            //保存每条记录
            set.add(sum);
        }
        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return max + 1;
    }
}
