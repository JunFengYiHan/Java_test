package leetcode.tree.求根节点到叶节点数字之和;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-25
 * Time: 11:10
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
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    private int dfs(TreeNode root,int prevSum) {
        if(root==null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left==null&&root.right==null) {
            return sum;
        }
        return dfs(root.left,sum) + dfs(root.right,sum);
    }
}
