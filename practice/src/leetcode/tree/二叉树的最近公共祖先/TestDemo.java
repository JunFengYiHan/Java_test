package leetcode.tree.二叉树的最近公共祖先;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-07
 * Time: 9:23
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class TestDemo {

//    //表示最近公共祖先
//    private TreeNode lca = null;
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        findNode(root,p,q);
//        return this.lca;
//    }
//
//    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
//        //空节点不存在公共祖先直接返回false
//        if(root==null) {
//            return false;
//        }
//        //公共祖先有三种情况，满足其中的情况才有公共祖先
//        //1.分布在左右子树
//        //2.根节点和左子树
//        //3.根节点和右子树
//        int left = findNode(root.left,p,q)?1:0;//左子树
//        int right = findNode(root.right,p,q)?1:0;//右子树
//        int mid = (root==p||root==q)?1:0;//当前根
//        //通过转换存在情况相加等于2说明找到了最近公共祖先
//        if(left+right+mid==2) {
//            this.lca = root;
//        }
//        //如果为0 说明不存在公共祖先
//        //如果为1 说明可能是p的祖先，或者q的祖先，或者 p q的公共祖先但不是最近公共祖先
//        return (left+right+mid) > 0;
//    }
}
