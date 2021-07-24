package 数据结构.tree.binarysearchtree;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-24
 * Time: 15:07
 */
class Node{
    int key;
    //int value;
    Node left;
    Node right;

    public Node(int key) {
        this.key = key;
    }
}
class BinarySearchTree{
    public Node getRoot() {
        return root;
    }
    private Node root;
    //查找
    public Node find(int key) {
        //可以不写
//        if(root==null) {
//            return null;
//        }
        Node cur = root;
        while(cur!=null) {
            if (key<cur.key) {
                cur = cur.left;
            }else if (key>cur.key) {
                cur = cur.right;
            }else{
                return cur;
            }
        }
        return null;
    }
    //插入
    public boolean insert(int key) {
        if (root==null) {
            root = new Node(key);
            return true;
        }
        Node cur = root;
        Node parent = null;
        while(cur!=null) {
            while(cur!=null) {
                if (key<cur.key) {
                    parent = cur;
                    cur = cur.left;
                }else if (key>cur.key) {
                    parent = cur;
                    cur = cur.right;
                }else{
                    return false;
                }
            }
        }
        if (key<parent.key) {
            parent.left = new Node(key);
        }else{
            parent.right = new Node(key);
        }
        return true;
    }
    public boolean remove(int key) {
        Node cur = root;
        Node parent = null;
        while(cur!=null) {
            if (key<cur.key) {
                parent = cur;
                cur = cur.left;
            }else if(key>cur.key) {
                parent = cur;
                cur = cur.right;
            }else {
                removeNode(cur,parent);
                return true;
            }
        }
        return false;
    }
    //删除节点
    private void removeNode(Node cur, Node parent) {
        //要删除的节点左子树为空
        if (cur.left==null) {
            //删除根节点，直接指向根节点的右树
            if (cur==root) {
                root = cur.right;
            }else if(cur == parent.left){
                //要删除的节点是父节点的左子树
                //直接让父节点的left指向cur的right
                parent.left = cur.right;
            }else{
                //要删除的节点是父节点的右子树
                //直接让父节点的right指向cur的right
                parent.right = cur.right;
            }
        //要删除的节点右子树为空
        }else if(cur.right==null) {
            //要删除的是根节点
            if (cur==root) {
                root = cur.left;
            }else if (cur==parent.left) {
                //要删除的是父节点的左子树
                //直接让父节点的left指向cur的left
                parent.left = cur.left;
            }else{
                //要删除的节点是父节点的右子树
                //直接让父节点的right指向cur的left
                parent.right = cur.left;
            }
        //要删除的节点左右子树均不为空
        }else{
            Node scapegoat = cur.right;
            Node goatParent = cur;
            //找到当前右子树最左侧的节点，当作替罪羊，以保证中序遍历的结果依旧有序
            //也可以找左子树最右侧的节点，当作替罪羊，
            while (scapegoat.left!=null) {
                goatParent = scapegoat;
                scapegoat = scapegoat.left;
            }
            //将替罪羊的值赋给要删除的节点，形成删除
            cur.key = scapegoat.key;
            //删除替罪羊节点
            if (scapegoat==goatParent.left) {
                goatParent.left = scapegoat.right;
            } else {
                goatParent.right = scapegoat.right;
            }
        }
    }

}
public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(5);
        binarySearchTree.insert(6);
        binarySearchTree.insert(2);
        binarySearchTree.insert(4);
        binarySearchTree.insert(9);
        binarySearchTree.insert(0);
        binarySearchTree.insert(7);
        inorder(binarySearchTree.getRoot());
        System.out.println();
        preorder(binarySearchTree.getRoot());
    }
    public static void inorder(Node root) {
        if (root==null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.key+" ");
        inorder(root.right);
    }
    public static void preorder(Node root) {
        if (root==null) {
            return;
        }
        System.out.print(root.key+" ");
        preorder(root.left);
        preorder(root.right);
    }
}
