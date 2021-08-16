package 数据结构.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-08-15
 * Time: 21:42
 */
public class MyQueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        //System.out.println(queue.poll());
        //System.out.println(queue.remove());
        MyQueue<String> myQueue = new MyQueue<>();
        System.out.println(myQueue.poll());
        System.out.println(myQueue.isEmpty());
        myQueue.add("1");
        System.out.println(myQueue.poll());
        myQueue.add("2");
        myQueue.add("3");
        myQueue.add("4");
        myQueue.offer("5");
        System.out.println(myQueue.peek());
        System.out.println(myQueue.size());
        System.out.println(myQueue.isEmpty());
    }
}
