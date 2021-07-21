package leetcode.tree.二叉树的后序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-09
 * Time: 1:29
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class 二叉树的后序遍历 {
    //迭代实现
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        TreeNode prev = null;//上一个打印的节点
        while(cur!=null||!stack.empty()) {
            while(cur!=null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();
            if(top.right==null || top.right == prev) {
                list.add(top.val);
                prev = stack.pop();
            }else {
                cur = top.right;
            }
        }
        return list;
    }

    //递归实现
//    public void postorder (List<Integer> valList, TreeNode root){
//        if(root==null) return;//为空直接返回
//        postorder(valList,root.left);//遍历左树
//        postorder(valList,root.right);//遍历右树
//        valList.add(root.val);//当前根
//    }
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        postorder(result,root);
//        return result;
//    }
}
