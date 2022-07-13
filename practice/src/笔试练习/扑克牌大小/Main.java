package 笔试练习.扑克牌大小;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/7/13
 * Time: 21:14
 */
public class Main {
    static class Poker {
        public String pokers;
        private int value;//定义不同牌的值
        private int type;//1个子,2对子,3三个,4炸弹,5顺子,10王炸
        //输入确保只会出现一种情况
        private static Map<String, Integer> map = new HashMap<>();

        static {
            String[] arr = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2", "joker", "JOKER"};
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], i);
            }

        }

        public Poker(String pokers) {
            this.pokers = pokers;
            String[] strings = pokers.split(" ");
            //去掉空格的影响
            type = strings.length;
            if (type == 2 && "joker".equals(strings[0]) && "JOKER".equals(strings[1])){
                type = 10;
            }
            if (strings.length == 1 && ("10".equals(strings[0]) || "joker".equals(strings[0]) || "Joker".equals(strings[0]))) {
                type = 1;
            }
            value = map.get(strings[0]);
//            switch () {
//                case 1:
//                    type = 1;
//                    value = map.get(pokers);
//                    break;
//                case 2:
//                    type = 2;
//                    value = map.get(pokers.charAt(0) + "");
//                    break;
//                case 3:
//                    type = 3;
//                    value = map.get(pokers.charAt(0) + "");
//                    break;
//                case 4:
//                    type = 4;
//                    value = map.get(pokers.charAt(0) + "");
//                    break;
//                case 5:
//                    type = 5;
//                    value = map.get(pokers.charAt(0) + "");
//                    //合法的顺子最大10开头
//                    if (value == 8 || value == 13) {
//                        type = 1;
//                    }
//                    break;
//                case 10:
//                    type = 6;
//                    //value不考虑
//                    break;
//                default:
//                    System.out.println("error");
//                    break;
//            }
        }
    }

    public static void main(String[] args) {//AC 72%
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strings = str.split("-");
        Poker p1 = new Poker(strings[0]);
        Poker p2 = new Poker(strings[1]);
        String ret = compare(p1, p2);
        System.out.println(ret);
    }

    private static String compare(Poker p1, Poker p2) {
        //出现王炸
        if (p1.type == 10 || p2.type == 10) {
            return p1.type == 5 ? p1.pokers : p2.pokers;
        }
        //一个为炸弹
        if (p1.type != p2.type && (p1.type == 4 || p2.type == 4)) {
            return p1.type == 4 ? p1.pokers : p2.pokers;
        }
        //相同比较
        if (p1.type == p2.type) {
            return p1.value > p2.value ? p1.pokers : p2.pokers;
        }
        //不同error
        return "ERROR";
    }
}
