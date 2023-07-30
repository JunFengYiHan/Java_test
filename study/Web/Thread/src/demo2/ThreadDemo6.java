package demo2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/30
 * Time: 19:03
 */

public class ThreadDemo6 {
    //饿汉模式
    static class Singleton {
        private Singleton() {

        }

        private static Singleton instance = new Singleton();

        public static Singleton getInstance() {
            return instance;
        }

    }

    public static void main(String[] args) {

    }
}
