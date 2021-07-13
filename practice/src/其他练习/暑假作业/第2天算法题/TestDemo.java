package 其他练习.暑假作业.第2天算法题;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-13
 * Time: 9:03
 */
public class TestDemo {
    //将奇数放在偶数前面，无序关心变化后的数据是否有序。
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        Move(array);
        System.out.println(Arrays.toString(array));
    }

    private static void Move(int[] array) {
        int i = 0;
        int j = array.length-1;
        while(i<j) {
            if(array[i]%2!=0) {
                i++;
                continue;
            }
            if (array[j]%2==0) {
                j--;
                continue;
            }
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
    }
}
