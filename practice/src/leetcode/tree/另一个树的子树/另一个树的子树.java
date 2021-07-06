package leetcode.tree.另一个树的子树;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-20
 * Time: 21:59
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
public class 另一个树的子树 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //都为空树，相同也为子树
        if(root==null && subRoot==null) {
            return true;
        }
        //一颗空树，一颗非空树
        if(root==null||subRoot==null) {
            return false;
        }
        //加上这个ret只是为了减少不必要的递归，
        boolean ret = false;
        if(root.val==subRoot.val) {
            ret = isSameTree(root,subRoot);
        }
        //这里的ret改成调用isSameTree也可以
        return ret||isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
    }
        public boolean isSameTree(TreeNode p, TreeNode q) {
        //都为空树，true
        if(p==null&&q==null) {
            return true;
        }
        //一棵空树，一颗非空树，false
        if(p==null||q==null) {
            return false;
        }
        //判断当前两个节点的值是否相等
        //不相等返回false
        if (p.val!=q.val) {
            return false;
        }
        //判断左右子树，类似于前序遍历
        return isSameTree(p.left,q.left) && isSameTree(q.right,p.right);
    }
}
