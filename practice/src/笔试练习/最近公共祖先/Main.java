package 笔试练习.最近公共祖先;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/7/8
 * Time: 18:42
 */
public class Main {
    //根节点为1
    //2*n  2*n+1
    static class LCA {
        public int getLCA(int a, int b) {
            //if (a == b) return a;//防止直接相等
            a = a / 2 * 2;//整数除法,化奇数为偶数
            b = b / 2 * 2;//左右子树祖先节点相同
            //使用do while确保不会因为转换导致第一次出现误判
            do {
                if (a > b) {
                    a /= 2;
                } else {
                    b /= 2;
                }
            } while (a != b);
            return a;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LCA().getLCA(2, 3));
    }
}
