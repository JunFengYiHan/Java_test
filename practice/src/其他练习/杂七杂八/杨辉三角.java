package 其他练习.杂七杂八;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-07
 * Time: 19:38
 */
public class 杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        if(numRows==0) return null;

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);//添加第一行

        for (int i = 1; i < numRows; i++) {
            List<Integer> listRow = new ArrayList<>();
            result.add(listRow);
            List<Integer> prevRow = result.get(i-1);//得到上一行

            for (int j = 0; j <= i; j++) {
                if(j==0||i==j){//每一行的第一个和最后一个数字都是 1
                    listRow.add(1);
                }else{
                    listRow.add(prevRow.get(j)+prevRow.get(j-1));
                }
            }

        }
        return result;
    }
}
