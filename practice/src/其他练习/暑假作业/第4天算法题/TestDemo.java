package 其他练习.暑假作业.第4天算法题;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-14
 * Time: 9:52
 */
public class TestDemo {
    //求一个有序数组中，两个值相加为key的数字，返回这两个数字的下标。时间复杂度是O(n)【不限语言】
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,7,7,8};
        System.out.println(findSumIndex(array,8));;
    }

    private static String findSumIndex(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        while(left<right) {
            int sum = arr[left]+arr[right];
            if(sum== key) {
                return "下标为"+left+","+right;
            }else if(sum>key){
                right--;
            }else {
                left++;
            }
        }
        return "不存在两数之和等于"+key;
    }

//    private static String findSumIndex(int[] arr,int key) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = arr.length-1; j >= 0 ; j--) {
//                if(arr[i]+arr[j]==key) {
//                    //return sb.toString();
//                    return "下标为" + i +"，" +j;
//                }
//            }
//        }
//        return "不存在和为该数字的两数";
//    }
}
