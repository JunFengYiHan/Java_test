import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-04-18
 * Time: 17:19
 */

/**
 * for 拷贝
 * Arrays.copyOf 拷贝 优先使用 2
 * Arrays.copyOfRange 拷贝    3
 * System.arraycopy 拷贝 优先使用 1
 * .clone 克隆
 * 都属于浅拷贝（Java属于面向对象的语言）
 */
public class TestDemo {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        //int[] ret = Arrays.copyOf(arr,arr.length);
        int[] ret = new int[2 * arr.length];
        //System.arraycopy(arr,0,ret,0,arr.length);
        //System.out.println(Arrays.toString(ret));
        //ret = arr.clone();
        ret = Arrays.copyOfRange(arr,0,16);
            
        System.out.println(Arrays.toString(ret));
    }
}
