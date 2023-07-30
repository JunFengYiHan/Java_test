package demo2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2023/7/30
 * Time: 19:07
 */

public class ThreadDemo7 {
    //懒汉模式
    static class Singleton {
        private Singleton() {
        }
        //确保instance的值进行更新
        private static volatile Singleton instance = null;

        public static Singleton getInstance() {
            //防止除了第一批调用需要加锁外,其他批次继续加锁
            if (instance == null) {
                //针对第一批调用进行加锁,形成原子操作防止创建多个实例
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }

    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();

    }
}
