package demo2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/30
 * Time: 21:00
 */

public class ThreadDemo10 {
    static class MyBlockingQueue {
        //循环队列
        private int[] items = new int[1000];
        private int head = 0;
        private int tail = 0;
        private int size = 0;
        private Object locker = new Object();

        //put 入队列
        public void put(int item) {
            synchronized (locker) {
                //队列已满
                while (size == items.length) {
                    //TODO 处理阻塞
                    try {
                        locker.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                items[tail] = item;
                tail++;
                //当tail超出数组大小时,将tail重置到0
                if (tail >= items.length) {
                    tail = 0;
                }
                //求模也可
                //tail %= items.length;
                size++;
                locker.notifyAll();
            }
        }

        //take 出队列
        public int take() {
            int ret;
            synchronized (locker) {
                while (size == 0) {
                    //TODO 队列为空,阻塞等待
                    try {
                        locker.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    return 0;
                }
                ret = items[head];
                head++;
                if (head >= items.length) {
                    head = 0;
                }
                //head%=items.length;
                size--;
                locker.notifyAll();
            }
            return ret;
        }
    }

    public static void main(String[] args) {
//        MyBlockingQueue queue = new MyBlockingQueue();
//        queue.put(1);
//        queue.put(2);
//        queue.put(3);
//        queue.put(4);
//
//        System.out.println(queue.take());
//        System.out.println(queue.take());
//        System.out.println(queue.take());
//        System.out.println(queue.take());
        MyBlockingQueue queue = new MyBlockingQueue();
        //消费者线程
        Thread consumer = new Thread() {
            @Override
            public void run() {
                while (true) {
                    int elem = queue.take();
                    System.out.println("消费了元素: " + elem);
                }
            }
        };
        consumer.start();

        //生产者线程
        Thread produce = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println("生产了元素: " + i);
                    queue.put(i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        produce.start();
    }

}
