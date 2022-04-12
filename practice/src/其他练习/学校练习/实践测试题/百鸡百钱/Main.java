package 其他练习.学校练习.实践测试题.百鸡百钱;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-12-17
 * Time: 14:21
 */
public class Main {
    public static void main(String[] args) {
        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 100 - 5 * i; j++) {
                for (int k = 3; k <= 100 - i - j; k += 3) {
                    if (i + j + k == 100 && 5 * i + 3 * j + k / 3.0 == 100) {
                        System.out.println("公鸡" + i + "只" + "母鸡" + j + "只" + "小鸡" + k + "只");
                    }
                }
            }
        }
    }
}
