package 其他练习.学校练习.操作系统;


import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-05-06
 * Time: 23:23
 */
public class TestDemo {

    static class PCB implements Comparable<PCB> {

        private String name;//进程名
        private int arrive;//到达时间
        private int runTime;//运行时间
        private char state;//状态
        //private PCB next;//指向下一个指针
        private int lifeCycle;//生命周期

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
    private static final Queue<PCB> runQueue = new LinkedList<>();//就绪队列
    private static final PriorityQueue<PCB> readyQueue = new PriorityQueue<>();//进程到达初始队列
    private static final Queue<PCB> retQueue = new LinkedList<>();//完成队列,展示结果

    public static boolean input(int num) {
        if (num <= 0) return false;//输入的进程数有误
        Scanner scanner = new Scanner(System.in);
        String name = null;
        int arrive = 0;
        int runTime = 0;
        for (int i = 0; i < num; i++) {
            System.out.printf("进程%d name: arrive: runTime: \n", i);
            name = scanner.next();
            arrive = scanner.nextInt();
            runTime = scanner.nextInt();
            readyQueue.add(new PCB(name, arrive, runTime));
        }
        System.out.print("请输入运行时间片: ");
        fragment = scanner.nextInt();
        return !readyQueue.isEmpty();
    }

    public static void start() {
        totalTime = readyQueue.peek().arrive;//从第一个到达的时间进行周转,减少空转
        while (!readyQueue.isEmpty() || !runQueue.isEmpty()) {
            if (!readyQueue.isEmpty() && readyQueue.peek().arrive <= totalTime) {
                PCB cur = readyQueue.poll();
                run(cur);
                //continue;
            } else if (!runQueue.isEmpty()) {
                PCB cur = runQueue.poll();
                run(cur);
            } else {
                totalTime++;
            }
        }
        //System.out.println(Arrays.toString(retQueue.toArray()));
        for (PCB cur : retQueue) {
            System.out.println(cur.toString());
        }
    }


    public static void run(PCB cur) {
        print(cur);

        int tmpT = fragment;
        while (tmpT > 0 && cur.runTime > 0) {
            totalTime++;
            tmpT--;
            cur.runTime--;
        }
        if (cur.runTime > 0) {
            runQueue.add(cur);
        } else {
            cur.state = 'C';//运行结束切换状态为C
            cur.lifeCycle = totalTime - cur.arrive;//计算周转时间
            retQueue.add(cur);//放入最终结果队列,方便打印
        }
    }

    public static void print(PCB cur) {
        System.out.println("当前运行的进程为 " + cur.toString());
    }

    public static void main(String[] args) {
        System.out.print("请输入需要得总进程数: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        boolean inFlag = input(num);
        if (!inFlag) return;//输入异常终止程序
        start();
    }
}
