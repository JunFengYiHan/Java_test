package leetcode.tree.二叉树最大宽度;


import java.util.LinkedList;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-25
 * Time: 21:05
 */
class TreeNode {
    int val;
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
//方法二的辅助类
class AnnotatedNode {
    TreeNode node;//当前节点
    int depth;//当前节点的深度
    int pos;//当前节点的对应下标
    AnnotatedNode(TreeNode n, int d, int p) {
        node = n;
        depth = d;
        pos = p;
    }
}
//方法三的辅助类
class ANode {
    TreeNode node;
    int pos;//记录当前节点对应下标
    public ANode(TreeNode node, int pos) {
        this.node = node;
        this.pos = pos;
    }
}
public class TestDemo {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<ANode> q = new LinkedList<>();
        q.offer(new ANode(root,0));
        int maxWidth = 0;
        while(!q.isEmpty()) {
            int size = q.size();//当前这一层的大小
            maxWidth = Math.max(maxWidth,q.getLast().pos-q.getFirst().pos+1);//获取当前一层的的大小
            while(size-- > 0){
                ANode top = q.poll();//弹出当前队首元素
                if (top.node.left!=null) {
                    q.offer(new ANode(top.node.left,top.pos*2+1));
                }
                if (top.node.right!=null) {
                    q.offer(new ANode(top.node.right,top.pos*2+2));
                }
            }
        }
        return maxWidth;
    }
    //方法二,创建一个新类描述depth,pos
//    public int widthOfBinaryTree(TreeNode root) {
//        Deque<AnnotatedNode> q = new LinkedList<>();
//        q.add(new AnnotatedNode(root,0,0));
//        int maxWidth = 0;
//        int left = 0;//保留最近一层,最左侧的下标
//        int curDepth = 0;
//        while(!q.isEmpty()) {
//            AnnotatedNode  top = q.poll();//获取队首元素
//            if (top.node!=null) {
//                q.offer(new AnnotatedNode(top.node.left,top.depth+1,top.pos*2+1));
//                q.offer(new AnnotatedNode(top.node.right,top.depth+1,top.pos*2+2));
//                //每到达下一层,更新curDepth和left
//                if(curDepth!=top.depth) {
//                    curDepth = top.depth;
//                    left = top.pos;
//                }
//                //求上一次和当前一层,节点数的较多者
//                maxWidth = Math.max(maxWidth,top.pos-left+1);
//            }
//            //不能放到下面,因为只有两个非null的节点之间的才算宽度
//            //maxWidth = Math.max(maxWidth,top.pos-left+1);
//        }
//        return maxWidth;
//    }

    //方法一,将树中节点的值修改为数组下标的形式，不建议
//    public int widthOfBinaryTree(TreeNode root) {
//        Deque<TreeNode> q = new LinkedList<>();
//        q.add(root);
//        root.val=0;
//        int maxWidth = 0;
//        while(!q.isEmpty()) {
//            int size = q.size();//获取当前一层的个数
//            maxWidth = Math.max(maxWidth,q.getLast().val-q.getFirst().val+1);
//            //遍历当前一层，放入下一层
//            while(size-- > 0) {
//                TreeNode top = q.poll();
//                if (top==null) continue;
//                if (top.left!=null) {
//                    q.offer(top.left);
//                    top.left.val = 2 * top.val+1;
//                }
//                if (top.right!=null) {
//                    q.offer(top.right);
//                    top.right.val = 2 * top.val + 2;
//                }
//            }
//        }
//        return maxWidth;
//    }
}
