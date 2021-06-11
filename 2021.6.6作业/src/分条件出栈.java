import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-08
 * Time: 12:16
 */
public class 分条件出栈 {
    public ArrayList<Integer> asylum(int[][] ope) {
        ArrayList<Integer> stack1 = new ArrayList<>();
        ArrayList<Integer> stack2 = new ArrayList<>();
        for(int[] data:ope){
            if(data[0]==1){
                stack1.add(data[1]);
            }
            if(data[0]==2){
                if(data[1]==0){
                    stack2.add(stack1.remove(0));
                }else if(data[1]==1){
                    for (int i = 0; i < stack1.size(); i++) {
                        if(stack1.get(i)>0){
                            stack2.add(stack1.remove(i));
                            break;
                        }
                    }
                }else if(data[1]==-1){
                    for (int i = 0; i < stack1.size(); i++) {
                        if(stack1.get(i)<0){
                            stack2.add(stack1.remove(i));
                            break;
                        }
                    }
                }
            }
        }
        return stack2;
    }
}
