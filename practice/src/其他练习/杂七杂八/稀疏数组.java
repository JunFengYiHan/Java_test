package 其他练习.杂七杂八;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-10
 * Time: 16:23
 */
public class 稀疏数组 {
    public static void main(String[] args) {
        int[][] array1 = new int[10][10];
        array1[1][1] = 3;
        array1[2][3] = 5;
        array1[3][2] = 6;
        for (int[] ints : array1) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
        int sum = 0;//有效数据个数
        for (int[] ints : array1) {
            for (int anInt : ints) {
                if(anInt!=0){
                    sum++;
                }
            }
        }
        //创建一个稀疏数组
        int[][] sparse = new int[sum+1][3];
        //第一行为转换前的数组的行数列数和不一样元素的个数
        sparse[0][0] = array1.length;//原行
        sparse[0][1] = array1[0].length;//原列
        sparse[0][2] = sum;//有效数据个数
        int count = 0;//已存几个元素
        //转换成稀疏数组
        for (int i = 0; i < array1.length; i++) {
            for (int i1 = 0; i1 < array1[i].length; i1++) {
                if(array1[i][i1]!=0){
                    count++;
                    //相对应的数据
                    sparse[count][0] = i;//行
                    sparse[count][1] = i1;//列
                    sparse[count][2] = array1[i][i1];//数据
                }
            }
        }
        //打印稀疏数组
        System.out.println("行 列 数据");
        for (int i = 0; i < sparse.length; i++) {
            for (int i1 = 0; i1 < sparse[i].length; i1++) {
                System.out.print(sparse[i][i1]+" ");
            }
            System.out.println();
        }
        //还原数组
        int[][] array2 = new int[sparse[0][0]][sparse[0][1]];
        for (int i = 1; i < sparse.length; i++) {
            array2[sparse[i][0]][sparse[i][1]] = sparse[i][2];
        }
        for (int[] ints : array2) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }
}
