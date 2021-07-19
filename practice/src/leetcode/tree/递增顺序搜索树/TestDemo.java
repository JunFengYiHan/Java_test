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
    TreeNode ret = null;
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return ret;
    }
    private TreeNode inorder(TreeNode root) {
        //空树或者只有根节点直接返回
        if(root==null||root.left==null&&root.right==null) return root;
        TreeNode left = inorder(root.left);//得到左子树
        if(ret==null) {
            ret = left;
        }
        left.right = root;
        increasingBST(root.right);
        return
    }
}
