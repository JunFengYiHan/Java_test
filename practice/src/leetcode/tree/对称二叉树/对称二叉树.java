package leetcode.tree.对称二叉树;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-20
 * Time: 23:07
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
public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        //根节点为空，直接返回true
        if(root==null) {
            return true;
        }
        return isMirror(root.left,root.right);
    }
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        //左右都为空，说明对称
        if(t1==null&&t2==null) {
            return true;
        }
        //一个为空一个不为空说明不对称
        if(t1==null||t2==null) {
            return false;
        }
        //对应节点的值不相等，也不对称
        if(t1.val!=t2.val) {
            return false;
        }
        //左右子树是否为镜像
        return isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }
}
