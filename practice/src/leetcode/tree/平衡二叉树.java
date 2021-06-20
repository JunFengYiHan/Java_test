//package leetcode.tree;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-20
// * Time: 22:42
// */
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}
//public class 平衡二叉树 {
//    public boolean isBalanced(TreeNode root) {
//        //本题中，一棵高度平衡二叉树定义为：
//        //一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
//        //空树是平衡 二叉树
//        if(root==null) {
//            return true;
//        }
//        //一个节点也是
//        if(root.left==null&&root.right==null) {
//            return true;
//        }
//        //求出左右子树深度进行判断
//        if(maxDepth(root.left) - maxDepth(root.right)>1||maxDepth(root.left) - maxDepth(root.right)<-1) {
//            return false;
//        }
//        return isBalanced(root.left) && isBalanced(root.right);
//    }
//
//    public int maxDepth(TreeNode root) {
//        //空节点深度为0
//        if (root == null) {
//            return 0;
//        }
//        //叶子节点深度为1
//        if (root.left == null && root.right == null) {
//            return 1;
//        }
//        //当前节点不为空，记1，然后求左右子树深度的较大值
//        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
//    }
//}
