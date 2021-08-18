package 数据结构.queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-08-15
 * Time: 21:42
 */
class Node<T>{
    T val;
    Node<T> next;
    Node<T> prev;
    public Node(T val) {
        this.val = val;
    }
}
public class MyQueue<E> {

    private Node<E> head;
    private Node<E> last;
    private int size;
    public MyQueue() {

    }
    //添加元素
    public boolean add(E val) {
        Node<E> node = new Node<>(val);
        this.size++;
        if (this.head==null) {
            this.head = node;
            this.last = node;
            return true;
        }
        this.last.next = node;
        node.prev = this.last;
        last = last.next;
        return true;
    }

    public boolean offer(E val) {
        return this.add(val);
    }
    //弹出队首元素
    public E poll() {
        if (this.isEmpty()) {
            return null;
        }

        Node<E> tmp = this.head;
        this.size--;
        if (this.head == this.last) {
            this.head = null;
            this.last = null;
            return tmp.val;
        }

        this.head = this.head.next;
        this.head.prev = null;
        return tmp.val;
    }
    //获取队首元素
    public E peek() {
        return this.head==null?null:this.head.val;
    }
    //判断队列是否为空
    public boolean isEmpty() {
        return this.size == 0;
    }
    //队列当前大小
    public int size() {
        return this.size;
    }
}
