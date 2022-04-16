package web.Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-04-13
 * Time: 21:46
 */
public class ThreadDemo3 {
    static class LockerQueue {
        private int[] ints = new int[1000];
        private int head = 0;
        private int tail = 0;
        private int size = 0;
        private Object locker = new Object();

        public void put(int elem) throws InterruptedException {
            synchronized (locker) {
                while (size >= ints.length) {
                    //return;
                    locker.wait();//生产者放满了等待
                }
                ints[tail] = elem;
                tail++;
                tail %= ints.length;
                size++;
                locker.notify();//唤醒消费者
            }
        }

        public int tack() throws InterruptedException {
            synchronized (locker) {
                while (size <= 0) {
                    //return 0;
                    locker.wait();//没库存了消费者等待
                }
                int elem = ints[head];
                head++;
                head %= ints.length;
                size--;
                locker.notify();//唤醒生产者
                return elem;
            }
        }
    }

    public static void main(String[] args) {
        LockerQueue lockerQueue = new LockerQueue();
        //消费者线程
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        int elem = lockerQueue.tack();
                        System.out.println("消费了元素: " + elem);
                        Thread.sleep(1000);
                    }
                    //Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();

        //生产者线程
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println("生产了元素: " + i);

                    try {
                        lockerQueue.put(i);
                        //Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
