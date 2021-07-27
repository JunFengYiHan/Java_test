package leetcode.tree.二叉树的完全性检验;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-25
 * Time: 16:13
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class TestDemo {
    class ANode {
        TreeNode node;
        int code;
        public ANode(TreeNode node, int code) {
            this.node = node;
            this.code = code;
        }
    }
    public boolean isCompleteTree(TreeNode root) {
        List<ANode> arrList = new ArrayList<>();
        arrList.add(new ANode(root,0));
        int i = 0;
        while(i<arrList.size()) {
            ANode aNode = arrList.get(i++);
            if (aNode.node!=null) {
                //左右孩子
                arrList.add(new ANode(aNode.node.left,2*aNode.code+1));
                arrList.add(new ANode(aNode.node.right,2*aNode.code+2));
            }
        }
        return arrList.get(i-1).code == arrList.size() - 1;
    }
//    public boolean isCompleteTree(TreeNode root) {
//        //方法一，层序遍历
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        boolean flag = false;//标记是否出现null
//        while(!queue.isEmpty()) {
//            TreeNode top = queue.poll();
//            //flag为false时继续层序遍历，为true时判断树是否已经遍历完了
//            //如果是完全二叉树说明此时队列中应该全部是null
//            if (flag && top!=null) {
//                return false;
//            }
//            //出现null，标记已经到了完全二叉树的尾部
//            if (top==null) {
//                flag = true;
//                continue;
//            }
//            queue.offer(top.left);
//            queue.offer(top.right);
//        }
//        //遍历完还没有返回，说明是完全二叉树
//        return true;
//    }
}
