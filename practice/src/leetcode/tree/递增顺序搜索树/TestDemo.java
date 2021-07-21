package leetcode.tree.递增顺序搜索树;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-19
 * Time: 20:32
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
    //给一个傀儡节点
    TreeNode dummy = new TreeNode(-1);
    TreeNode cur = dummy;
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return dummy.right;
    }
    private void inorder(TreeNode root) {
        if(root==null) return;
        inorder(root.left);

        cur.right = root;
        cur = cur.right;
        root.left = null;

        inorder(root.right);
    }
}
