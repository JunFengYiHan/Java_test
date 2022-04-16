package web.Thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-04-13
 * Time: 20:12
 */
public class ThreadDemo2 {
    //饿汉设计模式
    static class Singleton1 {
        static Singleton1 instance = new Singleton1();

        private Singleton1() {

        }

        static Singleton1 getInstance() {
            return instance;
        }
    }

    //懒汉设计模式
    static class Singleton2 {
        //添加volatile确保内存可见性
        static volatile Singleton2 instance = null;

        private Singleton2() {

        }

        public static Singleton2 getInstance() {
            if (instance == null) {//区分是不是首批调用
                synchronized (Singleton2.class) {//第一次访问加锁,防止重复创建
                    if (instance == null) {//判断是否已经创建对象
                        instance = new Singleton2();
                    }
                }
            }
            return instance;
        }
    }
}
