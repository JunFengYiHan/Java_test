//package leetcode.linkedlist;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-25
// * Time: 22:03
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
//public class 二叉树展开为链表 {
//    public void flatten(TreeNode root) {
//        if(root==null) return;
//        TreeNode cur = root;
//        while(cur!=null) {
//            //左子树不为空
//            if(cur.left!=null) {
//                TreeNode next = cur.left;
//                TreeNode prev = next;
//                while(prev.right!=null) {
//                    prev = prev.right;
//                }
//                //将右子树，串在左子树的右子树后面
//                prev.right = cur.right;
//                cur.left = null;//断开左子树的链接
//                cur.right = next;//将左子树变成右子树
//            }
//            cur = cur.right;
//        }
//    }
////    public void flatten(TreeNode root) {
////        if(root==null) return;
////        List<TreeNode> array = new ArrayList<>();
////        preorder(root,array);
////        //串联起来
////        for (int i = 1; i < array.size(); i++) {
////            //考虑使用临时变量，减少时间
////            array.get(i-1).left = null;
////            array.get(i-1).right = array.get(i);
////        }
////    }
////    //前序遍历
////    public void preorder(TreeNode root,List<TreeNode> arr) {
////        if(root==null) return;
////        arr.add(root);
////        preorder(root.left,arr);
////        preorder(root.right,arr);
////    }
//}
