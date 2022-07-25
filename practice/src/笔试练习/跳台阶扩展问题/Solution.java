package 笔试练习.跳台阶扩展问题;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/7/25
 * Time: 23:32
 */
public class Solution {
    public int jumpFloorII(int number) {
        int ret = 0;
        //记录不同n的跳跃次数,累加起来
        for (int i = 1; i < number; i++) {
            ret += jumpFloorII(number - i);
        }
        //一次性跳n,次数+1
        return ret + 1;
    }
}
