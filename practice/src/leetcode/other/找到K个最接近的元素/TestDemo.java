package leetcode.other.找到K个最接近的元素;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-23
 * Time: 23:22
 */
public class TestDemo {
    //方法二，需要研究一下，
    //链接：https://leetcode-cn.com/problems/find-k-closest-elements/solution/pai-chu-fa-shuang-zhi-zhen-er-fen-fa-python-dai-ma/
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int size = arr.length;
        int left = 0;
        int right = size - k;
        while (left < right) {
            // int mid = left + (right - left) / 2;
            int mid = (left + right) >>> 1;
            // 尝试从长度为 k + 1 的连续子区间删除一个元素
            // 从而定位左区间端点的边界值
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
    //方法一
//    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        int left = 0;
//        int right = arr.length-1;
//        int removerNums = arr.length-k;
//        //从数组中删除removerNums个，最后保留k个
//        while(removerNums>0) {
//            if (x-arr[left]>arr[right]-x) {
//                left++;
//            }else {
//                right--;
//            }
//            removerNums--;
//        }
//        List<Integer> ret = new ArrayList<>();
//        for (int i = left; i <= right; i++) {
//            ret.add(arr[i]);
//        }
//        return ret;
//    }
}
