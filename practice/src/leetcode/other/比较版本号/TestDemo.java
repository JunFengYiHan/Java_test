package leetcode.other.比较版本号;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-23
 * Time: 17:05
 */
public class TestDemo {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int index=0;
        while(index<s1.length||index<s2.length) {
            int num1 = index<s1.length?Integer.parseInt(s1[index]):0;
            int num2 = index<s2.length?Integer.parseInt(s2[index]):0;
            if(num1>num2) {
                return 1;
            }
            if (num1<num2) {
                return -1;
            }
            index++;
        }
        return 0;
    }
}
