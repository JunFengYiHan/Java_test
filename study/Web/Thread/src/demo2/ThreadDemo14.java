package demo2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/31
 * Time: 23:59
 */

public class ThreadDemo14 {
    //任务类
    static class Worker extends Thread {
        private BlockingQueue<Runnable> queue = null;

        public Worker(BlockingQueue<Runnable> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            //执行任务
            while (true) {
                try {
                    Runnable command = queue.take();
                    //通过run执行任务
                    command.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //线程池类
    static class ThreadPool {
        //使用阻塞队列
        private BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();
        //存放工作线程
        private List<Thread> workers = new ArrayList<>();
        //最大线程数量
        private static final int MAX_WORKER_COUNT = 10;

        //添加任务,同时创建线程
        public void submit(Runnable command) throws InterruptedException {
            if (workers.size() < MAX_WORKER_COUNT) {
                //添加工作线程
                Worker worker = new Worker(queue);
                //启动工作线程
                worker.start();
                //加入线程池
                workers.add(worker);
            }
            //将任务加入阻塞队列
            queue.put(command);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPool pool = new ThreadPool();
        for (int i = 0; i < 100; i++) {
            int n = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(n);
                }
            });
        }
    }
}
