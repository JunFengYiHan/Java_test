package 其他练习.学校练习.Java实验.第7次作业;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-11-02
 * Time: 8:49
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[3];
        try{
            arr[4] = 4;
        }catch(ArrayIndexOutOfBoundsException e) {
            //throw e;
            System.out.println("数组越界");
        }finally {
            System.out.println("执行了finally语句");
        }
    }
}
