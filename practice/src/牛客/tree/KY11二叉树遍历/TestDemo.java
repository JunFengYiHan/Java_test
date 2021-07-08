package 牛客.tree.KY11二叉树遍历;


import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-06
 * Time: 21:02
 */
class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(char val) { this.val = val; }
    TreeNode(char val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String str = scanner.next();
            TreeNode root = build(str);//根据输入，创建一棵树
            inorder(root);//中序遍历打印
            System.out.println();
        }
    }

    private static void inorder(TreeNode root) {

        if(root==null) return;

        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    //本身就是先序遍历的结果，所以可以不考虑会index过大的情况
    private static int index=0;//用于表示已经遍历到了第几个字符
    private static TreeNode build(String str) {
        index=0;//每次开始都将index置为0
        return helper(str);//当前树的根节点
    }
    //辅助构造方法
    private static TreeNode helper(String str) {
        char cur = str.charAt(index);
        if(cur=='#') {
            return null;
        }
        TreeNode root = new TreeNode(cur);//以当前字符创建一个节点
        index++;//指向下一个字符，以下一个字符为当前root的左子树
        root.left = helper(str);//
        index++;//指向下一个字符，以下一个字符为当前root的右子树
        root.right = helper(str);//
        return root;//返回当前根节点
    }
}
