import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-05
 * Time: 17:34
 */
class RecentCounter {
    Queue<Integer> queue;
    public RecentCounter() {
        this.queue = new LinkedList<>();
    }

    public int ping(int t) {
        this.queue.add(t);
        while(t-this.queue.peek()>3000){
            this.queue.poll();
        }
        return this.queue.size();
    }
}
