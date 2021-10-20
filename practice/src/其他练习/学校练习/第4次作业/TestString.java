package 其他练习.学校练习.第4次作业;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-18
 * Time: 15:57
 */
public class TestString {

    //统计字符
    public static String statistics(String source) {
        int capital = 0;//大写字母
        int lowercase = 0;//小写字母
        int other = 0;//其他字符
        for (int i = 0; i < source.length(); i++) {
            char tmp = source.charAt(i);
            if (tmp>'A'&&tmp<'Z') {
                capital++;
            }else if (tmp>'a'&&tmp<'z') {
                lowercase++;
            }else {
                other++;
            }
        }

        return source+"中大写字母"+capital+"个"+"小写字母"+lowercase+"个"
                +"非英文字母"+other+"个";
    }
    private static void  reverse(char[] arr,int left,int right){
        while(left<right) {
            char tmp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = tmp;
        }
    }
    //字符向后移动n位
    public static String encryption(String str,int n) {
        char[] arr = str.toCharArray();
        reverse(arr,0,arr.length-n-1);
        reverse(arr,arr.length-n,arr.length-1);
        reverse(arr,0,arr.length-1);
        return new String(arr);
    }
    //统计字符
    public static int statistics(String source,char target) {
        int count = 0;//计数器
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i)==target) {
                count++;//累加
            }
        }
        return count;
    }
    //统计字串
    public static int statistics(String source,String target) {
        int count = 0;//计数器
        String[] s = source.split(" ");//拆分
        for (int i = 0; i < s.length; i++) {
            if (s[i].contains(target)) {//判断是否为子串
                count++;//累加
            }
        }
        return count;
    }
    //统计单词
    public static int statisticsWord(String source,String target) {
        int count = 0;//计数器
        String[] s = source.split(" ");//拆分
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals(target)) {//判断是否为单词
                count++;//累加
            }
        }
        return count;
    }
    //倒序输出
    public static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        String[] strings = str.split(" ");//拆分
        for (int i = strings.length-1; i >= 0 ; i--) {
            sb.append(strings[i]+" ");//倒序拼接字符串
        }
        return sb.toString();
    }
}
