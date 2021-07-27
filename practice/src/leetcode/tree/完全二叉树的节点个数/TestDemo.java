package leetcode.tree.完全二叉树的节点个数;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-25
 * Time: 10:56
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
    //求节点的个数
    public int countNodes(TreeNode root) {
        if (root==null) {
            return 0;
        }
//        if (root.left==null&&root.right==null) {
//            return 1;
//        }
        return  1 + countNodes(root.left) + countNodes(root.right);
    }
    //求叶子节点的个数
    public int getLeafSize(TreeNode root) {
        if (root==null) {
            return 0;
        }
        if (root.left==null&&root.right==null) {
            return 1;
        }
        return getLeafSize(root.left) + getLeafSize(root.right);
    }
    //查找节点
    public TreeNode find(TreeNode root,int val) {
        if (root==null||root.val==val) {
            return root;
        }
        TreeNode left = find(root.left,val);
        if (left!=null) {
            return left;
        }
        return find(root.right,val);
    }
}
