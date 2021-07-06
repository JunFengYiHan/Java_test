package leetcode.linkedlist.BiNode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-26
 * Time: 22:17
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class BiNode {
    TreeNode result;
    TreeNode prev;
    public TreeNode convertBiNode(TreeNode root) {
        preorder(root);
        return this.result;
    }
    public void preorder(TreeNode root) {
        if(root==null) {
            return;
        }
        preorder(root.left);
        //将中序遍历的第一个值作为结果
        if(this.result==null) this.result = root;
        //让prev一直指向root的前一个节点之后才串联成链表
        if(this.prev!=null) this.prev.right = root;//右子树指向当前节点
        this.prev=root;//指向当前节点
        this.prev.left=null;//左子树置为空
        preorder(root.right);
    }
}
