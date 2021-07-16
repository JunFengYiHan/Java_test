package 其他练习.暑假作业.第7天算法题;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-16
 * Time: 20:02
 */
public class TestDemo {
//    输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的
//    最大值。要求时间复杂度为O(n)
    //例如输入的数组为{1,-2,3,10,-4,7,2,-5}，和最大的子数组为{3,10,-4,7,2}，因此输出为该子数组的和18
    //题目似乎并没有让我们求得当前子数组
    public static void main(String[] args) {
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        System.out.println(findBigSum(arr));
    }
    private static int findBigSum(int[] arr) {
        if(arr==null||arr.length==0){
            return 0;
        }
        int sum = arr[0];//和标记为第一个元素
        int sumMax = sum;//最大和暂时为第一个元素
        for (int i = 1; i < arr.length; i++) {
            //如果和大于0继续累加
            if(sum>0) {
                sum+=arr[i];
            } else{
                //小于0则去掉前面的和，从当前元素重新开始累加
                sum = arr[i];
            }
            //得到一个最大和
            if(sum>sumMax) {
                sumMax = sum;
            }
        }
        return sumMax;
    }
}
