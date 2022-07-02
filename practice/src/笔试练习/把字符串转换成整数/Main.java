package 笔试练习.把字符串转换成整数;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/7/2
 * Time: 14:14
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().StrToInt("+2147483647"));
    }

    static class Solution {
        public int StrToInt(String str) {
            if (str == null || str.length() == 0) return 0;
            char[] arr = str.toCharArray();
            boolean flag = false;
            int i = 0;
            if (arr[0] == '-' || arr[0] == '+') {
                flag = arr[0] == '-';
                i++;
            }
            int ret = 0;
            for (; i < arr.length; i++) {
                if (arr[i] < '0' || arr[i] > '9') {
                    return 0;
                }
                ret = ret * 10 + arr[i] - '0';
            }
            if (flag) ret = -ret;
            return ret;
        }
    }
}
