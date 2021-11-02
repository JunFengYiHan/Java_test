package 其他练习.学校练习.Java实验.第7次作业;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-11-02
 * Time: 9:05
 */
public class DangerException extends Exception {
    private String name;

    public DangerException(String name) {
        this.name = name;
    }

    public void toShow() {
        System.out.println("发现危险物品: " + this.name);
    }
}
