package leetcode.tree.二叉树的后序遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-09
 * Time: 1:29
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class 二叉树的后序遍历 {
    public void postorder(List<Integer> valList, TreeNode root){
        if(root==null) return;//为空直接返回
        postorder(valList,root.left);//遍历左树
        postorder(valList,root.right);//遍历右树
        valList.add(root.val);//当前根
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(result,root);
        return result;
    }
}
