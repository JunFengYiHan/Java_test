package web;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-04-13
 * Time: 22:34
 */
public class ThreadDemo4 {
    static class Task implements Comparable<Task> {
        private Runnable command;
        private long time;

        public Task(Runnable command, long time) {
            this.command = command;
            this.time = System.currentTimeMillis() + time;
        }

        public void run() {
            command.run();
        }

        @Override
        public int compareTo(Task o) {
            return (int) (this.time - o.time);
        }
    }


    static class Timer {
        private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
        private Object locker = new Object();

        public void schedule(Runnable command, int time) {
            Task t = new Task(command, time);
            queue.put(t);
            synchronized (locker) {
                locker.notify();
            }
        }

        public Timer() {
            Thread t = new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Task task = queue.take();
                            long curTime = System.currentTimeMillis();
                            if (task.time > curTime) {
                                queue.put(task);
                                synchronized (locker) {
                                    locker.wait(task.time - curTime);
                                }
                            } else {
                                task.run();//执行任务
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            break;//interrupt出现时中断线程
                        }

                    }
                }
            };
            t.start();
        }

    }

    public static void main(String[] args) {
        System.out.println("程序开始");
        Timer timer = new Timer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }, 1000);

    }
}
