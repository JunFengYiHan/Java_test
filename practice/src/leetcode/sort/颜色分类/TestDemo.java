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
    public static void sortColors(int[] nums) {
        //划分为 0  [zero,i)
        //      1  [i,tow)
        //      2  [tow,length)
        //不断向0区域尾插元素，2区域头插元素，1自动有序
        int zero = 0;
        int two = nums.length;
        //当i和tow相遇时说明已经排序好了
        for (int i = 0; i < two; i++) {
            if (nums[i]==0) {
                swap(nums,i,zero);
                zero++;
            }else if (nums[i]==2) {
                two--;
                swap(nums,i,two);
                i--;//因为for循环i一定会加，所以先减一，不然就会忽略调当前i位置的元素
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    private static void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    //计数排序
//    public static void sortColors(int[] nums) {
//        int[] arr = new int[3];
//        for (int index:nums) {
//            arr[index]++;
//        }
//        int useSize = 0;
//        for (int i = 0; i < 3; i++) {
//            while(arr[i]>0) {
//                nums[useSize++] = i;
//                arr[i]--;
//            }
//        }
//        System.out.println(Arrays.toString(nums));
//    }
}
