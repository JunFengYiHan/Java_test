package web;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-04-11
 * Time: 20:54
 */
class MyThread extends Thread{

    @Override
    public void run() {
        while(true){
            System.out.println("hello Thread!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class MyRunnable implements Runnable{

    @Override
    public void run() {
        while(true) {
            System.out.println("hello main!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class TestThread {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println("Thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"NyThread");
        t.start();
        System.out.println("id "+t.getId());
        System.out.println("name "+t.getName());
        System.out.println("state "+t.getState());
        System.out.println("priority "+t.getPriority());
        System.out.println("isAlive "+t.isAlive());
        System.out.println("isDaemon "+t.isDaemon());
        System.out.println("isInterrupted "+t.isInterrupted());
    }

    public static void main4(String[] args) {
        Thread t = new Thread(()->{
            while(true){
                System.out.println("lambda");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    public static void main3(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("main");
            }
        });
        t.start();


    }

    public static void main2(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();

        while(true) {
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main1(String[] args) {
        Thread t = new MyThread();
        t.start();

        while(true) {
            System.out.println("hello main!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
