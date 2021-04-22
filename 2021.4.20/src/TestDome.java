import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-04-20
 * Time: 22:11
 */

public class TestDome{
    public static void swap(int[] arr1,int[] arr2){
        int tmp = 0;
        for (int i = 0; i < arr1.length; i++) {
            tmp = arr1[i];
            arr1[i] = arr2[i];
            arr2[i] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7,9};
        int[] arr2 = {2,4,6,8,10};
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println("=====交换前后=====");
        swap(arr1,arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static int[] exchange(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while(left<right) {
            while(arr[left]%2==0&&left<right){
                left++;
            }
            while(arr[right]%2!=0&&left<right){
                right--;
            }
            if(left<right){
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        return arr;
    }
    public static void main1(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(exchange(arr)));
    }
}