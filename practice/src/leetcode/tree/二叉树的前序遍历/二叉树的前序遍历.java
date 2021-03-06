package leetcode.tree.二叉树的前序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-08
 * Time: 22:04
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

public class 二叉树的前序遍历 {
    //迭代实现
    public List<Integer> preorderTraversal(TreeNode root) {
        //创建一个list存储数据
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null || !stack.empty()) {
            while(cur!=null) {
                result.add(cur.val);//先访问根节点
                stack.push(cur);
                cur = cur.left;//遍历左子树，一直往左走
            }
            cur = stack.pop().right;//遍历右子树
        }
        return result;
    }
    //递归实现
//    public List<Integer> preorderTraversal(TreeNode root) {
//        //创建一个list存储数据
//        List<Integer> result = new ArrayList<>();
//        preorder(result,root);
//        return result;
//    }
//    public void preorder(List<Integer> valList,TreeNode root){
//        if(root==null){//为空直接返回
//            return;
//            //return null;
//        }
//        //将数据填入list
//        valList.add(root.val);//当前根
//        preorder(valList,root.left);//遍历左树
//        preorder(valList,root.right);//遍历右树
//        //return valList;
//    }
}
