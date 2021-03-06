package leetcode.heap.查找和最小的K对数字;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-08
 * Time: 10:34
 */
class Pair {
    int n1;
    int n2;
    int sum;

    public Pair(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
        this.sum = n1+n2;
    }
}
public class TestDemo {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = {3,5,7,9};
        TestDemo testDemo = new TestDemo();
        List<List<Integer>> lists= testDemo.kSmallestPairs(arr1,arr2,3);
        System.out.println(Arrays.toString(lists.toArray()));
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<Pair> heap = new ArrayList<>(k);
        //将所有可能组合起来放入一个数组中
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                heap.add(new Pair(nums1[i],nums2[j]));
            }
        }
        //buildHeap(heap,heap.size());//在原数组上构造一个堆
        List<List<Integer>> result = new ArrayList<>();
        buildHeap(heap,heap.size());//在原数组上构造一个小堆
        //取k和给定数组的较小值
        for (int i = 0; i < Math.min(k,heap.size()); i++) {
            //取出堆顶元素
            Pair cur = heap.get(0);
            //将当前的最后一个元素放到堆顶，已经取过的元素不算在堆内
            heap.set(0,heap.get(heap.size()-i-1));
            //将取得的最小元素放入目标数组中
            List<Integer> tmp = new ArrayList<>();
            tmp.add(cur.n1);
            tmp.add(cur.n2);
            result.add(tmp);
            //重新调整堆，已经取过的元素不算在堆内
            shiftDown(heap,heap.size()-1-i,0);
        }
        return result;
    }
//    private void buildHeap(List<Pair> heap,int size) {
//        for (int i = 0; i < size; i++) {
//            shiftUP(heap,i);
//        }
//    }
    //向上调整，不断向根节点靠近
    private void shiftUP(List<Pair> heap,  int index) {
        int child = index;
        int parent = (child-1)/2;
        while(child>0) {
            if(heap.get(child).sum<heap.get(parent).sum) {
                Pair tmp = heap.get(child);
                heap.set(child,heap.get(parent));
                heap.set(parent,tmp);
            }else{
                break;
            }
            child = parent;
            parent = (child-1)/2;
        }
    }
    private void buildHeap(List<Pair> heap,int size) {
        for (int i = (size -1 -1) / 2; i >= 0; i--) {
            shiftDown(heap,size,i);
        }
    }
    //向下调整，不断往最后一个节点靠近
    private void shiftDown(List<Pair> heap, int size, int index) {
        int parent = index;//以当下标为根节点下标
        int child = 2 * parent + 1;//找到它的左子树下标
        while (child < size) {//左子树下标有效进入循环
            //右子树存在，求得二者较小者的下标，不存在则左子树默认为较小者
            if (child + 1 < size && heap.get(child).sum > heap.get(child + 1).sum) {
                child = child + 1;
            }
            //如果根节点小于左右子树则不需要调整，满足小堆规则
            if (heap.get(child).sum < heap.get(parent).sum) {
                //交换根节点和左右子树较小者，形成堆
                Pair temp = heap.get(child);
                heap.set(child, heap.get(parent));
                heap.set(parent, temp);
            } else {
                break;
            }
            //将当前较小者当作父节点，继续调整
            parent = child;//以当前子树下标作为新的根节点下标
            child = 2 * parent + 1;//更新子树下标
        }
    }
//    private void shiftDown(List<Pair> heap, int size, int index) {
//        int child = 2*index+1;
//        while(child<size) {
//            int min = child;
//            //右子树存在，求得二者较小者的下标，不存在则左子树默认为较小者
//            if(child+1<size && heap.get(child).sum>heap.get(child+1).sum) {
//                min=child+1;
//            }
//            //如果根节点小于左右子树则不需要调整，满足小堆规则
//            if(heap.get(min).sum>=heap.get(index).sum) {
//                break;
//            }
//            //交换根节点和左右子树较小者，形成堆
//            Pair temp = heap.get(min);
//            heap.set(min,heap.get(index));
//            heap.set(index,temp);
//            //让index将当前较小者当作父节点，继续调整
//            index = min;
//            child = 2*index+1;
//        }
}
