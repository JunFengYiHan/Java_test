package 数据结构.map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-08-04
 * Time: 16:39
 */

public class MyHashMap<T> {
    static class Node <T>{
        T val;
        Node next;

        public Node(T val) {
            this.val = val;
        }
    }
    Node[] elem;

    public MyHashMap() {
        this.elem = new Node[10];
    }
}
