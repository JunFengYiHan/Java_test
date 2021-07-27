package 排序算法;


import java.util.Arrays;
import java.util.Stack;

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
        //int[] arr = {9,10,1,7,3};
        //insertSort(arr);
        //shellSort(arr);
        //selectSort(arr);
        //bubbleSort(arr);
        //heapSort(arr);
        quickSort(arr);
        //quickSortByLoop(arr);
        //mergerSort(arr);
        //mergerSortByLoop(arr);
        System.out.println(Arrays.toString(arr));
    }


    //归并排序，非递归实现
    private static void mergerSortByLoop(int[] arr) {
        //以gap个元素分组
        //第一次划分为[0,1) [1,2) [2,3) [3,4)..
        //第二次划分为[0,2) [2,4) [4,6) [6,8)..
        //...
        //划分为2组，合并完成，排序完成
        for (int gap = 1; gap < arr.length; gap *= 2) {
            for (int i = 0; i < arr.length; i += 2*gap) {
                int low = i;
                int mid = i + gap;
                int high = i + 2*gap;
                //防止下标越界
                if(mid>arr.length) {
                    mid = arr.length;
                }
                if (high>arr.length) {
                    high = arr.length;
                }
                merger(arr,low,mid,high);
            }
        }
    }
    //归并排序，递归实现,时间复杂度O(N*logN)，空间复杂度O(N)
    private static void mergerSort(int[] arr) {
        mergerSortHelper(arr,0,arr.length);
    }

    private static void mergerSortHelper(int[] arr, int low, int high) {
        //1个或0个元素不需要排序，直接返回
        if(high-low<=1) {
            return;
        }
        //不断划分区间
        int mid = (high-low)/2 + low;
        //划分足够小的时候就有序了，然后合并往上，逐渐有序
        mergerSortHelper(arr,low,mid);
        mergerSortHelper(arr,mid,high);
        //合并两个区间
        merger(arr,low,mid,high);
    }
    //合并方法,归并核心代码
    private static void merger(int[] arr,int low,int mid,int high) {
        int[] tmp = new int[high-low];
        int useSize = 0;
        int cur1 = low;
        int cur2 = mid;
        //将两个有序数组合并在一起
        while(cur1<mid&&cur2<high) {
            //取等可以保证稳定性
            if (arr[cur1]<=arr[cur2]) {
                tmp[useSize++] = arr[cur1++];
            } else{
                tmp[useSize++] = arr[cur2++];
            }
        }
        //上面循环结束说明有一个数组已经合并完了，直接将另外一个尾插到后面
        while(cur1<mid) {
            tmp[useSize++] = arr[cur1++];
        }
        while(cur2<high) {
            tmp[useSize++] = arr[cur2++];
        }
        //将数据拷贝回原数组，合并完成
        for (int i = 0; i < high-low; i++) {
            arr[low+i] = tmp[i];
        }
    }


    private static void quickSortByLoop(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        //放入待排序区间
        stack.push(0);
        stack.push(arr.length-1);
        while(!stack.empty()) {
            int end = stack.pop();
            int start = stack.pop();
            int pivot =  partition(arr,start,end);
            if (pivot-start>1) {
               stack.push(0);
               stack.push(pivot-1);
            }
            if (end-pivot>1) {
                stack.push(pivot+1);
                stack.push(end);
            }
        }
    }

    //快速排序，递归实现，时间复杂度O(N*logN),最坏O(N^2)，时间复杂度O(logN)，最坏O(N)，不稳定
    private static void quickSort(int[] arr) {
        quickSortHelper(arr,0,arr.length-1);//闭区间
    }
    //辅助方法，划分排序区间
    private static void quickSortHelper(int[] arr, int left, int right) {
        if(left>=right) {
            //没有或者一个元素，不需要排序直接返回
            return;
        }
        int index = partition(arr,left,right);
        quickSortHelper(arr,left,index-1);
        quickSortHelper(arr,index+1,right);
    }
    //三数取中作为基准
    private static void selectPivotMiddleOfThree(int[] arr,int start,int end,int mid) {
        if (arr[end]<arr[mid]) {
            swap(arr,end,mid);
        }
        if (arr[start]<arr[mid]) {
            swap(arr,start,mid);
        }
        if (arr[end]>arr[start]) {
            swap(arr,end,start);
        }
    }
    //真正的排序
    private static int partition(int[] arr, int left, int right) {
        int bgn = left;//从最左侧开始
        int end = right;//
        selectPivotMiddleOfThree(arr,left,right,(left+right)/2);//将中间那个数放到，待取的标准下标
        int norm = arr[right];//直接以最右侧元素为基准
        while(bgn<end) {
            //从左往右找到一个比基准大的
            while(bgn < end && arr[bgn] <= norm) {
                bgn++;
            }
            //从右往左找到一个比基准小的
            while(bgn < end && arr[end] >= norm) {
                end--;
            }
            //交换两个元素
            swap(arr,bgn,end);
        }
        //交换当前元素和基准值
        swap(arr,end,right);
        return end;
    }

    //堆排序，时间复杂度(N*logN)，空间复杂度O(1)，不稳定
    private static void heapSort(int[] arr) {
        buildHeap(arr);//先建一个大堆
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
    //向上调整，在堆中插入元素时，插在尾部，向上调整
    private static void shiftUp(int[] arr,int index) {
        int child = index;
        int parent = (child-1)/2;
        while(child>0) {
            if(arr[child]>arr[parent]) {
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
            }
            child = index;
            parent = (child-1)/2;
        }
    }
    //冒泡排序，时间复杂度O(N^2)，空间复杂度N(1)，稳定
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length -1 -i; j++) {
                if(arr[j]>arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }


    //选择排序，时间复杂度O(N^2),空间复杂度N(1)，不稳定
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
    //希尔排序的最好时间复杂度为O(N^1.3)，取决于gap的值，二分取复杂度为O(N^2)，空间复杂度O(1),不稳定
    private static void shellSort(int[] arr) {
        int gap = arr.length / 2;//分为gap组，最少分为1组
        while(gap>=1) {
            shellSortGap(arr,gap);
            gap /= 2;//更新gap
        }
    }

    private static void shellSortGap(int[] arr, int gap) {
        for (int bound = gap; bound < arr.length; bound+=gap) {
            int tmp = arr[bound];//拿到当前元素
            int cur = bound - gap;//拿到当前组已排序的最后一个元素
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

    //插入排序，时间复杂度O(N^2),空间复杂度O(1),稳定排序
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
