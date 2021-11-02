package 其他练习.学校练习.Java实验.第7次作业;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-11-02
 * Time: 9:08
 */
public class Machine {
    private static Set<String> set = createSet();

    public void checkBag(Goods goods) throws DangerException {
        if (set.contains(goods.getName())) {
            throw new DangerException(goods.getName());
        }
    }

    private static Set<String> createSet() {
        String[] buffer = {"火药", "石油", "毒品", "化学物品", "管制刀具"};
        return new HashSet<>(Arrays.asList(buffer));
    }

    //增加危险物品
    public static void add(String str) {
        set.add(str);
    }

    //删除危险物品
    public static void remove(String str) {
        set.remove(str);
    }
}
