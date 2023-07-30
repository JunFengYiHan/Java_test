package demo2;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/30
 * Time: 22:37
 */

public class ThreadDemo12 {
    //描述任务
    static class Task implements Comparable<Task> {
        //描述要执行的任务
        private Runnable command;
        //表示任务什么时候执行
        //使用 ms 级时间戳
        private long time;

        public Task(Runnable command, long time) {
            this.command = command;
            this.time = time + System.currentTimeMillis();
        }

        //执行任务
        public void run() {
            command.run();
        }

        @Override
        public int compareTo(Task o) {
            return (int) (this.time - o.time);
        }
    }

    static class MyTimer {
        //使用带有优先级的阻塞队列组织这些任务
        private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
        private Object locker = new Object();

        public void schedule(Runnable command, long delay) {
            Task task = new Task(command, delay);
            queue.put(task);
            //每次加入新的任务都需要重新唤醒扫描线程,重新判断是否需要等待
            synchronized (locker) {
                locker.notify();
            }
        }

        public MyTimer() {
            Thread t = new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Task task = queue.take();
                            long curTimer = System.currentTimeMillis();
                            //当前时间小于任务执行时间,则继续等待,将任务重新放回队列
                            if (curTimer < task.time) {
                                queue.put(task);
                                //等待当前最先开始任务时间与当前时间的时间差
                                synchronized (locker) {
                                    locker.wait(task.time - System.currentTimeMillis());
                                }
                            } else {
                                task.run();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                }
            };

            t.start();
        }
    }

    public static void main(String[] args) {
        System.out.println("代码开始执行");
        MyTimer timer = new MyTimer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }, 3000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello1");
            }
        }, 1500);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello2");
            }
        }, 500);

    }
}
