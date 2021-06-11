//package leetcode.tree;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-09
// * Time: 1:23
// */
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode() {
//    }
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}
//public class 二叉树的中序遍历 {
//
//    public void inorder(List<Integer> valArray,TreeNode root) {
//        if(root==null) return;//为空直接返回
//        inorder(valArray,root.left);//遍历左树
//        valArray.add(root.val);//当前根
//        inorder(valArray,root.right);//遍历右树
//    }
//    public List<Integer> inorderTraversal(TreeNode root) {
//
//        List<Integer> result = new ArrayList<>();
//        inorder(result,root);
//        return result;
//    }
//
//}
