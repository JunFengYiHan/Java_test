import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-04-16
 * Time: 19:17
 */
public class TestDome {
    public static int[] copyOf(int[] arr, int n) {
        int[] ret = new int[arr.length];
        for (int i = 0; i < n; i++) {
            ret[i] = arr[i];
        }
        return ret;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int[] ret = copyOf(arr, arr.length);
        System.out.println(Arrays.toString(ret));
    }

    public static int binarySearch(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left+right)/2;
            if(arr[mid]==n){
                return mid;
            }else if(arr[mid]<n){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main3(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(binarySearch(arr, 5));
        System.out.println(binarySearch(arr, 10));
    }

    public static boolean isAscending(int[] arr) {

        if(arr == null) return false;

        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }
    public static void main2(String[] args) {
        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = {1,3,2,5,4,6};
        System.out.println(isAscending(arr1));
        System.out.println(isAscending(arr2));
    }

    public static String toString(int[] arr) {
        String str = "[";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
            if(i < arr.length - 1){
                str += ',';
            }else{
                str += ']';
            }
        }
        return str;
    }

    public static void main1(String[] args) {
        int [] arr = {1,2,3,4};
        System.out.println(toString(arr));
    }

}
