package 牛客.tree.JZ26二叉搜索树与双向链表;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-07
 * Time: 22:59
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

}
public class TestDemo {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null || pRootOfTree.left==null && pRootOfTree.right==null) return pRootOfTree;
        TreeNode left = Convert(pRootOfTree.left);//得到左子树
        TreeNode leftTail = left;
        //找到右子树
        while(leftTail!=null&&leftTail.right!=null) {
            leftTail = leftTail.right;
        }
        if(left!=null) {
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        TreeNode right = Convert(pRootOfTree.right);
        if(right!=null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left==null?pRootOfTree:left;
    }
}
