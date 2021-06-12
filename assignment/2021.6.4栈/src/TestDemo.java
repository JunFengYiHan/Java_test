/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-04
 * Time: 21:21
 */
public class TestDemo {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.poll());
    }
}
