package 其他练习.学校练习.Java实验.第6次作业;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-11-01
 * Time: 16:55
 */
public class Straight implements Shape {
    double length;

    public Straight() {
    }

    public Straight(double length) {
        this.length = length;
    }

    @Override
    public double size() {
        return length;
    }
}
