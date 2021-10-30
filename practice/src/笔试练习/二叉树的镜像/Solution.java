package 笔试练习.二叉树的镜像;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-30
 * Time: 17:42
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public void Mirror(TreeNode root) {
        if (root==null) {
            return;
        }
        //从下往上交换
        Mirror(root.left);
        Mirror(root.right);
        //交换
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        //从上往下交换
//        Mirror(root.left);
//        Mirror(root.right);
    }
}
