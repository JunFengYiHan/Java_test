//package leetcode.tree;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-27
// * Time: 21:44
// */
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}
//public class 二叉树的镜像 {
//    public TreeNode mirrorTree(TreeNode root) {
//        //自上而下交换
//        if (root==null) return null;
//        TreeNode tmp = root.left;
//        root.left = root.right;
//        root.right = tmp;
//        mirrorTree(root.left);
//        mirrorTree(root.right);
//        return root;
//    }
////    public TreeNode mirrorTree(TreeNode root) {
////        //自下而上交换
////        if (root==null) return null;
////        //保存左右子树
////        TreeNode left = mirrorTree(root.left);
////        TreeNode right = mirrorTree(root.right);
////        //交换左右子树
////        root.left = right;
////        root.right = left;
////        return root;
////    }
//}
