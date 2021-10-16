package 笔试练习.字符串转整数;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-16
 * Time: 19:26
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(StrToInt("+2147483647"));
    }
    public static int StrToInt(String str) {
        if (str==null||str.length()==0) {
            return 0;
        }
        int ret  = 0;//最终结果
        boolean flag = str.charAt(0)=='-';//标识是不是负数
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (tmp>='0'&&tmp<='9') {
                ret = ret*10 + tmp-'0';
            }else if (tmp=='+'||tmp=='-'){
                continue;
            }else {
                return 0;
            }
        }
        if (flag) {
            ret*=-1;
        }
        return ret;
    }
}
