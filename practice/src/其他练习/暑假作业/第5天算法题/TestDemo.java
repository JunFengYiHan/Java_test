package 其他练习.暑假作业.第5天算法题;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-14
 * Time: 10:35
 */
public class TestDemo {
    //求一个数组中前k个最小的数字
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,2,5,4,2};
        int [] result = topK(arr,3);
        System.out.println(Arrays.toString(result));
    }

    private static int[] topK(int[] arr, int key) {
        int[] ret = new int[key];
        for (int i = 0; i < key; i++) {
            //每取出一个数组有效长度减 1
            buildHeap(arr,arr.length-i);
            //取堆顶元素
            ret[i] = arr[0];
            //覆盖堆顶元素，以待重新成堆
            arr[0] = arr[arr.length-1-i];
        }
        return ret;
    }

    private static void buildHeap(int[] arr,int size) {
        //从第一个非叶子节点开始
        for (int i = (arr.length-1-1)/2; i >=0 ; i--) {
            shiftDown(arr,size,i);
        }
    }

    private static void shiftDown(int[] arr,int size, int index) {
        int parent = index;
        int child = 2*index+1;
        while(child<size) {
            if(child+1<size && arr[child]>arr[child+1]) {
                child = child+1;
            }
            if(arr[child]<arr[parent]) {
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
            }
            parent = child;
            child = 2*parent+1;
        }
    }

}
