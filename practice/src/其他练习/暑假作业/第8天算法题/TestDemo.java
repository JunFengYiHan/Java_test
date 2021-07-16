package 其他练习.暑假作业.第8天算法题;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-16
 * Time: 20:58
 */
public class TestDemo {
    //一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,1,3,5,9};
        findOnceNum(arr);
    }

    private static void findOnceNum(int[] arr) {
        int bound = 0;
        for (int val:arr) {
            //得到两个数字的异或结果
            bound^=val;
        }
        int[] arr1 = new int[arr.length];
        int[] arr2 = new int[arr.length];
        int norm = 1;//表示bound二进制中的一个1所在，以其为标准
        for (int i = 0; i < 32; i++) {
            if((norm<<i & bound)!=0) {
                norm<<=i;
                break;
            }
        }
        //表示放入当前数组的那个位置
        int n1 = 0;
        int n2 = 0;
        //以当前norm为标准将数组分成两个，即将两个出现一次的数字分开
        for (int val:arr) {
            if((val&norm)!=0) {
                arr1[n1++] = val;
            }else{
                arr2[n2++] = val;
            }
        }
        //重置n1,n2让它们分别表示两个数组的异或结果，即分别表示这两个数字
        n1=0;
        n2=0;
        for (int val:arr1) {
            n1^=val;
        }
        for (int val:arr2) {
            n2^=val;
        }
        System.out.println(n1);
        System.out.println(n2);
    }
}
