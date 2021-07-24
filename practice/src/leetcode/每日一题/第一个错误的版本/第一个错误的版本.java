package leetcode.每日一题.第一个错误的版本;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-13
 * Time: 21:45
 */
public class 第一个错误的版本 {
    boolean isBadVersion(int version){
        //oj实现了,判断是不是错误版本
        //错误版本返回true，正确版本返回false
        return false;
    }
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while(left<right){
            int mid = left + (right-left)>>2;
            //是错误版本则后面都是错误版本
            if(isBadVersion(mid)){
                right = mid;
            }else{
                //不是错误版本则前面都不是错误版本
                left = mid + 1;
            }
        }
        //当left和right相遇的时候说明找到了第一个错误版本
        return left;
    }
}
