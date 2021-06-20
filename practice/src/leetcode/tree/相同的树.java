//package leetcode.tree;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-20
// * Time: 20:06
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
//public class 相同的树 {
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        //都为空树，true
//        if(p==null&&q==null) {
//            return true;
//        }
//        //一棵空树，一颗非空树，false
//        if(p==null||q==null) {
//            return false;
//        }
//        //判断当前两个节点的值是否相等
//        //不相等返回false
//        if (p.val!=q.val) {
//            return false;
//        }
//        //判断左右子树，类似于前序遍历
//        return isSameTree(p.left,q.left) && isSameTree(q.right,p.right);
//    }
//}
