package 排序算法;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-15
 * Time: 10:39
 */
public class TestDemo {
    public static void main(String[] args) {
        int[] arr = {4,58,2,7,93,39,6};
        //insertSort(arr);
        //shellSort(arr);
        //selectSort(arr);
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //堆排序
    private static void heapSort(int[] arr) {
        buildHeap(arr);//先建一个堆
        for (int i = 0; i < arr.length; i++) {
            //将堆顶元素和当前堆尾元素交换
            swap(arr,0,arr.length-i-1);
            //从堆顶开始重新调整堆，堆的大小为待排序的区间大小
            shiftDown(arr,arr.length-i-1,0);
        }
    }
    //交换两个元素
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    //建堆
    private static void buildHeap(int[] arr) {
        //从第一个非叶子结点开始
        for (int i = (arr.length-1-1)/2; i >=0 ; i--) {
            shiftDown(arr,arr.length,i);
        }
    }
    //向下调整，建一个大堆
    private static void shiftDown(int[] arr, int length, int index) {
        int parent = index;
        int child = 2*parent+1;
        while(child<length) {
            if(child + 1 < length && arr[child]<arr[child+1]) {
                child += 1;
            }
            if(arr[child]>arr[parent]) {
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    //选择排序
    private static void selectSort(int[] arr) {
        for (int bound = 0; bound < arr.length; bound++) {
            for (int cur = bound + 1; cur < arr.length; cur++) {
                //每次遇到小于当前位置的元素就进行交换，也可以先求得最小元素再交换
                if(arr[cur]<arr[bound]) {
                    int tmp = arr[cur];
                    arr[cur] = arr[bound];
                    arr[bound] = tmp;
                }
            }
        }
    }


    //希尔排序，分成多组的插入排序
    //因为插入排序 在元素较少时效率较高，在有序性高的时候效率较高
    //希尔排序的最好时间复杂度为O(N^1.3)，取决于gap的值，二分取复杂度为O(N^2)
    private static void shellSort(int[] arr) {
        int gap = arr.length / 2;//分为gap组，最少分为1组
        while(gap>=1) {
            shellSortGap(arr,gap);
            gap /= 2;//更新gap
        }
    }

    private static void shellSortGap(int[] arr, int gap) {
        for (int bound = gap; bound < arr.length; bound++) {
            int tmp = arr[bound];//拿到当前元素
            int cur = bound - gap;//拿到当前组以排序的最后一个元素
            //相邻元素相差一个gap
            for(;cur>=0;cur-=gap) {
                if(arr[cur]>tmp) {
                    arr[cur+gap] = arr[cur];
                } else{
                    break;
                }
            }
            //插入合适位置
            arr[cur+gap] = tmp;
        }
    }

    //插入排序
    private static void insertSort(int[] arr) {
        //将数组分为已排序和待排序两个区间，以bound分隔
        //1个元素默认有序，所以bound从第二个元素开始
        for (int bound = 1; bound < arr.length; bound++) {
            //先保留bound位置的元素
            int tmp = arr[bound];
            //拿到已排序区间的最后一个元素的下标
            int cur = bound - 1;
            //不断从后往前在数组中寻找插入的位置
            for (; cur >= 0; cur--) {
                //不合适就把当前元素往后搬一个
                if(arr[cur]>tmp) {
                    arr[cur+1] = arr[cur];
                }else{
                    //找到了就跳出循环，此时cur指向合适位置的前一个
                    break;
                }
            }
            //将当前元素插入，cur代表当前的元素小于tmp，所以放在他后面
            arr[cur+1] = tmp;
        }
    }
}
