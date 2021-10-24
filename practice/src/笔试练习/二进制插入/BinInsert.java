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
        return n ^ (m<<j);
        //return n | (m<<j);
        //return n + (m<<j);
    }
}
