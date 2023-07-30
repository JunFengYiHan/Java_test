package test;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/30
 * Time: 23:36
 */

public class Test1 {
    static class Task implements Comparable<Task> {
        //需要执行的任务
        private Runnable command;
        //任务执行的时间,毫秒级时间戳
        private long time;

        public Task(Runnable command, long delay) {
            this.command = command;
            this.time = delay + System.currentTimeMillis();
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

    static class Timer {
        //任务优先阻塞队列
        private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
        //锁对象,防止过度空转
        private Object locker = new Object();

        public void schedule(Runnable command, long delay) {
            //创建任务,并加入定时器队列
            Task task = new Task(command, delay);
            queue.put(task);
            //当有新的任务时唤醒扫描线程,重新计算
            synchronized (locker) {
                locker.notify();
            }
        }

        //扫描线程
        public Timer() {
            Thread t = new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Task task = queue.take();
                            //当前时间小于任务时间继续等待,否则执行任务
                            if (System.currentTimeMillis() < task.time) {
                                queue.put(task);
                                synchronized (locker) {
                                    locker.wait(task.time - System.currentTimeMillis());
                                }
                            } else {
                                task.run();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            break;//当出现中断信号时结束线程
                        }
                    }
                }
            };
            //启动扫描线程
            t.start();
        }
    }

    public static void main(String[] args) {
        System.out.println("代码开始执行");
        Timer timer = new Timer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hell1");
            }
        }, 3000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hell2");
            }
        }, 2000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hell3");
            }
        }, 500);

    }
}
