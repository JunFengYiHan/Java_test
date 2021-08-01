package 其他练习.杂七杂八.下厨房;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-31
 * Time: 9:30
 */
public class Main {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            set.add(sc.next());
        }
        System.out.println(set.size());
    }
}
