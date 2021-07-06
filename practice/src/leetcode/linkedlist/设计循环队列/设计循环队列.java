package leetcode.linkedlist.设计循环队列;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-26
 * Time: 23:23
 */
public class 设计循环队列 {
    class MyCircularQueue {
        int head;
        int tail;
        int size;
        int[] queue;
        public MyCircularQueue(int k) {
            //创建一个数组用作循环队列
            this.queue = new int[k];
        }

        public boolean enQueue(int value) {
            if(isFull()){
                return false;
            }
            queue[this.tail++] = value;
            this.size++;
            this.tail%=this.queue.length;
            return true;
        }

        public boolean deQueue() {
            if(isEmpty()){
                return false;
            }
            this.head++;
            this.head%=this.queue.length;
            this.size--;
            return true;
        }

        public int Front() {
            return this.size==0?-1:this.queue[head];
        }

        public int Rear() {
            return this.size==0?-1:this.queue[tail==0?this.queue.length-1:tail-1];
        }

        public boolean isEmpty() {
            return this.size==0;
        }

        public boolean isFull() {
            return this.size==queue.length;
        }
    }
}
