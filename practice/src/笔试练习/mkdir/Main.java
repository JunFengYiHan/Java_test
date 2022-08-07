package 笔试练习.mkdir;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/8/7
 * Time: 23:45
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<String> queue = new PriorityQueue<>();
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            scanner.nextLine();//去掉空格
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextLine();
            }
            Arrays.sort(arr, ((o1, o2) -> o1.length() - o2.length()));

            while (!queue.isEmpty()) {
                System.out.println("mkdir -p " + queue.poll());
            }
        }
    }
}
