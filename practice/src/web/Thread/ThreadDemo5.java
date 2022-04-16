package web.Thread;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-04-14
 * Time: 20:07
 */
public class ThreadDemo5 {
    static class Worker extends Thread{
        private BlockingQueue<Runnable> queue = null;
        public Worker(BlockingQueue<Runnable> queue) {
            this.queue = queue;
        }
        @Override
        public void run() {
            while(true) {
                try {
                    Runnable command = queue.take();
                    command.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class ThreadPool{
        private BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();

        private List<Worker> workers = new ArrayList<>();
        private static final int MAX_Thread_COUNT = 10;
        public void submit(Runnable command) throws InterruptedException {
            if (workers.size()<MAX_Thread_COUNT) {
                Worker worker = new Worker(queue);
                worker.start();
                workers.add(worker);
            }
            queue.put(command);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = new ThreadPool();
        for (int i = 0; i < 100; i++) {
            int n = i;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(n);
                }
            });
        }
    }
}
