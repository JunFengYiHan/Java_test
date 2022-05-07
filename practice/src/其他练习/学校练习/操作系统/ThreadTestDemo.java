package 其他练习.学校练习.操作系统;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-05-07
 * Time: 21:14
 */
public class ThreadTestDemo {
    static class PCB implements Comparable<PCB> {

        private String name;//进程名
        private int arrive;//到达时间
        private int runTime;//运行时间
        private char state;//状态
        //private PCB next;//指向下一个指针
        private int lifeCycle;//生命周期
        private Runnable command;//需要运行的执行流

        public void run() {
            command.run();//直接调用run方法不实际创建PCB
        }

        public PCB() {
        }

        public PCB(String name, int arrive, int runTime) {
            this.name = name;
            this.arrive = arrive;
            this.runTime = runTime;
            this.state = 'R';//创建好的PCB切换状态为R
        }

        @Override
        public String toString() {
            return "PCB{" +
                    "name='" + name + '\'' +
                    ", arrive=" + arrive +
                    ", runTime=" + runTime +
                    ", state=" + state +
                    ", lifeCycle=" + lifeCycle +
                    '}';
        }

        @Override
        public int compareTo(PCB o) {
            return this.arrive - o.arrive;
        }

    }

    private static int totalTime;//总的运行时间
    private static int fragment;//运行的时间片
    private static final Queue<TestDemo.PCB> runQueue = new LinkedList<>();//就绪队列
    private static final PriorityQueue<TestDemo.PCB> readyQueue = new PriorityQueue<>();//进程到达初始队列
    private static final Queue<TestDemo.PCB> retQueue = new LinkedList<>();//完成队列,展示结果

    static class Timer {
        private Object locker = new Object();//锁对象

        public Timer() {

        }
    }

}
