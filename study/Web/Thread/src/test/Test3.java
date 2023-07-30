package test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/31
 * Time: 0:23
 */

public class Test3 {
    //懒汉模式
    static class Singleton {
        private volatile Singleton instance = null;

        private Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }

        private Singleton() {
        }
    }
}
