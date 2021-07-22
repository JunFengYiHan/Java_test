package leetcode.tree.二叉树的最大深度;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-20
 * Time: 22:33
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
public class 二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        //空节点深度为0
        //叶子节点深度为1
        //当前节点不为空，记1，然后求左右子树深度的较大值
        return root==null ? 0 : 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
//    public int maxDepth(TreeNode root) {
//        //空节点深度为0
//        if(root==null) {
//            return 0;
//        }
//        //叶子节点深度为1
//        if(root.left==null&&root.right==null) {
//            return 1;
//        }
//        //当前节点不为空，记1，然后求左右子树深度的较大值
//        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
//    }
}
