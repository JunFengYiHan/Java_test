package 其他练习.学校练习.Java实验.第8次作业;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-11-29
 * Time: 19:44
 */
public class MyThread4 implements Runnable{
    private Info info;
    public MyThread4(Info info) {
        this.info = info;
    }

    @Override
    public void run() {
        if (info.flag) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
