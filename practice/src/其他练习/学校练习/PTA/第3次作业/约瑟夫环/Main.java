package 其他练习.学校练习.PTA.第3次作业.约瑟夫环;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-29
 * Time: 11:21
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int count = 0;//出局人数
        int index = -1;//当前人下标
        int tmp = p;
        while (count<n) {
            while (tmp > 0) {
                index++;
                index %= list.size();
                if(list.get(index)!=null) {
                    tmp--;
                }
            }
            tmp = p;
            count++;//出局人数+1
            System.out.print(list.get(index));
            list.set(index,null);
            if(count<n) {
                System.out.print(' ');
            }
        }
        System.out.println();
    }
}

//public class TestDemo {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();//总人数
//        int p = sc.nextInt();//出局的编号
//        boolean[] arr = new boolean[n];//人是否出局的数组
//        int index = 0;//当前下标
//        int count = 0;//出局的人数
//        while (count != n) {
//            int tmp = p;//往后报p个
//            while (tmp != 0) {
//                index++;
//                index %= n;
//                if (!arr[index]) {
//                    tmp--;
//                }
//            }
//            //删除这个人
//            arr[index] = true;
//            count++;//出局人+1
//            System.out.print((index==0?n:index));//输出当前出局编号
//            if (count<n) {
//                System.out.print(' ');
//            }
//        }
//        System.out.println();
//    }
//}
