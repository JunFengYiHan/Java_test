package 笔试练习.二进制插入;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-24
 * Time: 13:48
 */
public class BinInsert {
    public int binInsert(int n, int m, int j, int i) {
        //m有效位数只有i-j+1,且n的j到i位全为0,所以整体移动插入即可
        return n ^ (m<<j);
        //return n | (m<<j);
        //return n + (m<<j);
    }
}
