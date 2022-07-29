package 笔试练习.因子个数;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/7/29
 * Time: 23:54
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.print(func(n) + " ");
        }
    }

    public static List<Integer> arr = new ArrayList<>();
    static int in = 0;

    //求不同因数的个数,
    public static int func(int n) {
        int tmp = n;
        int k = 2;
        int count = 0;
        int flag = -1;

        while (true) {
            //k和flag不相等时计数器+1并更新flag
            if (k != flag && tmp % k == 0) {
                count++;
                flag = k;
            }
            while (tmp % k == 0) {
                tmp /= k;
            }
            if (tmp == 1) break;
            k = nextNum(k);
        }
        in = 0;//重置i的值
        return count;
    }

    //求下一个因数
    public static int nextNum(int n) {
        //取出存好的数据
        for (int j = in; j < arr.size(); j++) {
            if(arr.get(j)>n) {
                return arr.get(j);
            }
        }
        n += 1;//跳过当前n
        for (int i = 2; i <= Math.sqrt(n); i++) {
            //当前n不是质数n+1往后走
            //i从新从2开始判断
            if (n % i == 0) {
                n++;
                i = 1;
            }
        }
        arr.add(n);//添加素数备用
        return n;
    }
}
