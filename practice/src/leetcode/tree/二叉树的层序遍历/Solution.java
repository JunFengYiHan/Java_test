package leetcode.tree.二叉树的层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-06
 * Time: 21:52
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
public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root!=null) {
            helper(root,0);
        }
        //result.remove(result.size()-1);方法1
        return result;
    }

    private void helper(TreeNode root, int tier) {
        //方法2
        if(tier==result.size()){
            result.add(new ArrayList<>());
        }
        if(root==null) return;
        result.get(tier).add(root.val);
        if(root.left!=null) {
            helper(root.left,tier+1);
        }
        if(root.right!=null) {
            helper(root.right,tier+1);
        }
        //方法1
//        if(tier==result.size()){
//            result.add(new ArrayList<>());
//        }
//        if(root==null) return;
//        result.get(tier).add(root.val);
//        helper(root.left,tier+1);
//        helper(root.right,tier+1);
    }
}
