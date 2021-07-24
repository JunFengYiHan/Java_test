package leetcode.每日一题.替换隐藏数字得到的最晚时间;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-24
 * Time: 20:42
 */
public class TestDemo {
    public String maximumTime(String time) {
        //转换为字符数组，从高位往地位逐渐判断取值
        char[] arr = time.toCharArray();
        if (arr[0]=='?') {
            arr[0] = (arr[1]>='4' && arr[1]<='9')?'1':'2';
        }
        if (arr[1]=='?') {
            arr[1] = (arr[0]=='2')?'3':'9';
        }
        if (arr[3]=='?') {
            arr[3] = '5';
        }
        if (arr[4]=='?') {
            arr[4] = '9';
        }
        return new String(arr);
    }
}
