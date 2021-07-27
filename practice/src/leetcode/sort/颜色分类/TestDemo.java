package leetcode.sort.颜色分类;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-25
 * Time: 21:23
 */
public class TestDemo {
    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);
    }
    //计数排序
    public static void sortColors(int[] nums) {
        int[] arr = new int[3];
        for (int index:nums) {
            arr[index]++;
        }
        int useSize = 0;
        for (int i = 0; i < 3; i++) {
            while(arr[i]>0) {
                nums[useSize++] = i;
                arr[i]--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
