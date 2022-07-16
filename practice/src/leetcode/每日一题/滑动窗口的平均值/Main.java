package leetcode.每日一题.滑动窗口的平均值;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022/7/16
 * Time: 22:26
 */
public class Main {
    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        int[] arr = {1, 10, 3, 5};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(movingAverage.next(arr[i]));
        }
    }

    static class MovingAverage {
        private double[] arr;
        int head;
        int tail;
        int size;

        public MovingAverage(int size) {
            this.arr = new double[size];
            this.head = 0;
            this.tail = 0;
            this.size = 0;
        }

        public double next(int val) {
            if (size < this.arr.length) {
                size++;
            } else {
                head++;
            }
            arr[tail] = val;
            tail++;
            head %= arr.length;
            tail %= arr.length;
            double sum = 0;
            for (int i = head; i < head + size; i++) {
                sum += arr[i%arr.length];
            }
            return sum / size;
        }
    }
}
