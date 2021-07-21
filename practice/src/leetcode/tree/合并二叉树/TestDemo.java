package leetcode.tree.合并二叉树;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-21
 * Time: 14:54
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
    //在原树上修改
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //一个为空直接返回另外一个
        if(root1==null) return root2;
        if(root2==null) return root1;
        root1.val+=root2.val;
        root1.left = mergeTrees(root1.left,root2.left);
        root1.right = mergeTrees(root1.right,root2.right);
        return root1;
    }
//    //完全创建一颗新树
//    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//        //一个为空直接返回另外一个
//        if(root1==null) return root2;
//        if(root2==null) return root1;
//        //都不为空，值合并
//        TreeNode root = new TreeNode(root1.val+root2.val);
//        //分别找到左右子树
//        root.left = mergeTrees(root1.left,root2.left);
//        root.right = mergeTrees(root1.right,root2.right);
//       return root;
//    }
}
