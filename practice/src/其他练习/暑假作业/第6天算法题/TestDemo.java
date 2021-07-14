package 其他练习.暑假作业.第6天算法题;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-14
 * Time: 20:34
 */
public class TestDemo {
    //{1,2,3,2,2,2,5,4,2} 数组长度为9，超过数组长度一半的数字为2。 因为长度的一半为4，超过4次的数字为2
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] arr = {1,2,3,2,2,2,5,4,2};
//        for (int i = 0; i < arr.length; i++) {
//            if(!map.containsKey(arr[i])) {
//                //第一次存入
//                map.put(arr[i],1);
//            }else{
//                //多次存入
//                map.put(arr[i],map.get(arr[i]) + 1);
//            }
//        }
        for (int i = 0; i < arr.length; i++) {
            //如果已经存入返回该值，不存在返回0，然后加1存入当前key位置
            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
        }
        int norm = arr.length / 2;//以数组长度的一半为标准
        for(Integer key:map.keySet()) {
            if(map.get(key)>norm) {
                System.out.print(key+" ");
            }
        }
    }
}
