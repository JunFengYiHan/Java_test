package 其他练习.杂七杂八.求第k层的节点个数;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-25
 * Time: 16:08
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
    //求第k层的节点个数
    public int getKLevelSize(TreeNode root, int k) {
        if (root==null) {
            return 0;
        }
        if (k==1) {
            return 1;
        }
        return getKLevelSize(root.left,k-1) + getKLevelSize(root.right,k-1);
    }
}
