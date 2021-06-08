/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-04
 * Time: 21:04
 */
class Node {
    protected int val;
    protected Node next;
    public Node(int val) {
        this.val = val;
    }
}
public class MyQueue {
    private Node first;
    private Node last;
    //入队
    public void offer(int val) {
        Node node = new Node(val);
        if(first==null){
            this.first = node;
            this.last = node;
            return;
        }
        this.last.next = node;
        this.last = this.last.next;
//尾插法 需要判断是不是第一次插入
    }
    //出队
    public int poll() {
        if(this.first==null){
            //System.out.println("队列为空！");
            throw new RuntimeException("队列为空!");
        }
        int val = this.first.val;
        this.first = this.first.next;
        return val;
//1判断是否为空的
    }
    //得到队头元素但是不删除
    public int peek() {
        if(this.first==null){
            //System.out.println("队列为空！");
            throw new RuntimeException("队列为空!");
        }
        return this.first.val;
//不要移动first
    }
    //队列是否为空
    public boolean isEmpty() {
        return this.first==null;
    }
}