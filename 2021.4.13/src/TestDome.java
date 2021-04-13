import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-04-13
 * Time: 19:05
 */
public class TestDome {
    public static void transform(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        transform(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static int assignment(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        return sum;
    }
    public static void main4(String[] args) {
        int[] arr = new int[100];
        assignment(arr);
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for(int x: arr){
            System.out.print(x+" ");
        }
    }
    public static void main3(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        printArray(arr);
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for(int i: arr){
            sum+=i;
        }
        return sum;
    }
    public static void main2(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(sum(arr));
    }

    public static double avg(int [] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum * 1.0 / arr.length;
    }
    public static void main1(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(avg(arr));
    }
}
