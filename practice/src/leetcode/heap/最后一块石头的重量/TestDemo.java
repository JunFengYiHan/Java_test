package leetcode.heap.最后一块石头的重量;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-24
 * Time: 14:49
 */
public class TestDemo {
    public static void main(String[] args) {
        int[]arr = {9,10,1,7,3};
        lastStoneWeight(arr);
    }
    //方法二
//    public static int lastStoneWeight(int[] stones) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2-o1));
//        for (int data:stones) {
//            pq.offer(data);
//        }
//        while(pq.size()>1) {
//            int w1 = pq.poll();
//            int w2 = pq.poll();
//            if (w1>w2) {
//                pq.offer(w1-w2);
//            }
//        }
//        return pq.isEmpty()?0:pq.poll();
//    }
    //方法一
    public static int lastStoneWeight(int[] stones) {
        //建一个大堆

        buildHeap(stones,stones.length);
        //标识已经取了几次
        int count = 0;
          while(count<stones.length-1) {
            int w1 = stones[0];//取堆顶元素
            stones[0] = stones[stones.length-1-count];//删除堆顶元素
            count++;//已经取走了一个元素
            shiftDown(stones,stones.length-count,0);//调整堆
            int w2 = stones[0];//再次取出堆顶元素
            stones[0] = w1-w2;//两者相减之后，放入堆顶，元素个数不变，继续调整堆
            shiftDown(stones,stones.length-count,0);
        }
        //返回堆顶元素
        return stones[0];
    }
    //向下调整，建一个大堆
    private static void buildHeap(int[] arr,int size) {
        for (int parent = (size-1-1)/2; parent >=0; parent--) {
            shiftDown(arr,size,parent);
        }
    }
    private static void shiftDown(int[] arr, int size, int index) {
        int parent = index;
        int child = 2*parent+1;
        while(child<size) {
            if (child+1<size && arr[child]<arr[child+1]) {
                child+=1;
            }
            if (arr[child]>arr[parent]) {
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
            }else {
                break;
            }
            parent = child;
            child = 2*parent+1;
        }
    }
}
