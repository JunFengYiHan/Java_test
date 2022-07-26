package 笔试练习.不用加减乘除做加法;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/7/26
 * Time: 23:25
 */
public class Solution {
    //迭代
    public int Add(int num1, int num2) {
        //1相同位,进位
        int carry = num1 & num2;
        //carry为0不需要进位
        while (carry != 0) {
            //二进位保持对齐;
            carry <<= 1;
            //合并并去掉相同位,即置为0
            num1 ^= num2;
            num2 = carry;
            //更新carry
            carry = num1 & num2;
        }
        //最后返回二进制合并结果
        return num1 ^ num2;
    }
    //1.递归
//    public int Add(int num1, int num2) {
//        //1相同位,进位
//        int carry = num1 & num2;
//        //carry为0不需要进位
//        if (carry == 0) {
//            return num1 ^ num2;
//        }
//        //左移一位进位
//        carry <<= 1;
//        //相同位保持为0
//        num1 ^= num2;
//        return Add(num1, carry);
//    }
}