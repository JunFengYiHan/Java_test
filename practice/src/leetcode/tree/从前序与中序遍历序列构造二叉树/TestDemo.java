package leetcode.tree.从前序与中序遍历序列构造二叉树;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-26
 * Time: 20:45
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
    static int index;//表示已经遍历到了先序结果的第几个元素
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        return buildTreeHelper(preorder,inorder,0,preorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int left, int right) {
        //没有元素了，直接返回null
        if (left>=right) {
            return null;
        }
//        元素已经遍历完了
        if (index>=preorder.length) {
            return null;
        }
//        创建一个节点
        TreeNode root = new TreeNode(preorder[index]);
        index++;//每创建一个节点index++，指向下一个节点
        //找到中序遍历中的位置，划分左右子树
        int pos = findIndex(inorder,left,right,root.val);
        root.left = buildTreeHelper(preorder,inorder,left,pos);
        root.right = buildTreeHelper(preorder,inorder,pos+1,right);
        return root;
    }
    //找到根节点所在位置，找到返回下标，找不到返回-1
    private int findIndex(int[] inorder, int left, int right, int val) {
        for (int i = left; i < right; i++) {
            if (inorder[i]==val) {
                return i;
            }
        }
        return -1;
    }
}
