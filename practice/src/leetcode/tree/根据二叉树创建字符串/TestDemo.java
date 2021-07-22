package leetcode.tree.根据二叉树创建字符串;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-22
 * Time: 20:50
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
    //方法二
    StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode root) {
        preorder(root);
        return sb.toString();
    }

    private void preorder(TreeNode root) {
        if(root==null) {
            return;
        }

        sb.append(root.val);
        if (root.left!=null) {
            sb.append("(");
            preorder(root.left);
            sb.append(")");
        }else{
            if(root.right!=null) {
                sb.append("()");
            }else{
                return;
            }
        }
        if (root.right!=null) {
            sb.append("(");
            preorder(root.right);
            sb.append(")");
        }else{
            return;
        }
    }

    //方法一
//    public String tree2str(TreeNode root) {
//        //空树对应空字符串
//        if(root==null) return "";
//        //左右子树都为空，以字符串形式返回当前值
//        if(root.right==null&&root.left==null) return root.val+"";
//        //右树为空，不要添加括号,继续构造左树
//        if(root.right==null) {
//            return root.val+"("+tree2str(root.left)+")";
//        }
//        //递归下去，如果左孩子为空，只会添加一对括号
//        return root.val+ "("+tree2str(root.left)+")" + "("+tree2str(root.right)+")";
//    }
}
