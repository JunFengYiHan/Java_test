package test;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/31
 * Time: 0:05
 */

public class Test2 {
    static class BlockingQueue {
        //循环队列
        private int[] items = new int[1000];
        private int head = 0;
        private int tail = 0;
        private int size = 0;

        //锁对象
        private Object locker = new Object();

        //入队列
        public void put(int item) {
            //队列已满,阻塞等待
            synchronized (locker) {
                if (size == items.length) {
                    try {
                        locker.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                items[tail] = item;
                tail++;
                tail %= items.length;
                size++;
                locker.notify();
            }

        }

        //出队列
        public int take() {
            synchronized (locker) {
                int ret = 0;
                //队列为空,阻塞等待
                if (size == 0) {
                    try {
                        locker.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                ret = items[head];
                head++;
                head %= items.length;
                size--;
                locker.notify();
                return ret;
            }

        }
    }

    public static void main(String[] args) {
        //中间场所
        BlockingQueue queue = new BlockingQueue();
        //消费者
        Thread consumer = new Thread() {
            @Override
            public void run() {
                while (true) {
                    int value = queue.take();
                    System.out.println("消费了元素: " + value);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        consumer.start();
        //生产者
        Thread produce = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    queue.put(i);
                    System.out.println("生产了元素: " + i);
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        };
        produce.start();
    }
}
