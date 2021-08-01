package leetcode.sort.车队;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-28
 * Time: 21:30
 */
public class TestDemo {
    //方法一
//    static class Cur{
//        int distance;
//        double time;
//
//        public Cur(int distance, double time) {
//            this.distance = distance;
//            this.time = time;
//        }
//    }
//
//    public int carFleet(int target, int[] position, int[] speed) {
//        Cur[] arr = new Cur[position.length];//一个车一格
//        for (int i = 0; i < position.length; i++) {
//            double time = (target-1.0*position[i])/speed[i];//算出距离
//            arr[i] = new Cur(target - position[i],time);//放入车辆
//        }
//        //将位置信息转换成距离,将距离终点近的的放到前面,然后判断时间快慢
//        Arrays.sort(arr,(o1,o2) -> Integer.compare(o1.distance,o2.distance));
//        int motorcade = 0;
//        for (int i = 0; i < arr.length - 1; i++) {
//            if (arr[i].time < arr[i+1].time) {
//                motorcade++;
//            }else{
//                arr[i+1] = arr[i];
//            }
//        }
//        return motorcade + 1;
//    }
    //方法二
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] arr = new double[position.length][2];//存储两个属性,距离和时间
        for (int i = 0; i < position.length; i++) {
            arr[i][0] = target - position[i];
            arr[i][1] = (target - position[i])*1.0/speed[i];
        }
        Arrays.sort(arr,(o1, o2) -> Double.compare(o1[0],o2[0]));
        int motorcade = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i][1]<arr[i+1][1]) {
                motorcade++;
            }else {
                arr[i+1] = arr[i];
            }
        }
        return motorcade+1;
    }
}
