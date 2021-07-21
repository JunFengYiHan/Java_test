package leetcode.tree.二叉树的中序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-09
 * Time: 1:23
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
public class 二叉树的中序遍历 {
    //迭代实现
    public void inorder(TreeNode root) {
        if(root==null) return;//为空直接返回
        //辅助栈模拟递归
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()) {
            while(cur!=null) {
                stack.push(cur.left);//不断放入放入左子树,模拟递归
                cur = cur.left;
            }
            //左子树已经全部放入栈中,当前栈顶元素就是最左边的节点
            TreeNode top = stack.pop();
            System.out.print(top.val);
            cur = top.right;//更新当前节点为当前元素的右子树，继续遍历
        }
    }
    //递归实现
    public void inorder(List<Integer> valArray,TreeNode root) {
        if(root==null) return;//为空直接返回
        inorder(valArray,root.left);//遍历左树
        valArray.add(root.val);//当前根
        inorder(valArray,root.right);//遍历右树
    }
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        inorder(result,root);
        return result;
    }

}
