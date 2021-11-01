package 其他练习.学校练习.Java实验.第6次作业;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-11-01
 * Time: 16:35
 */
//矩形
public class Rectangle extends Shapes {
    double length;
    double with;

    public Rectangle() {
    }

    public Rectangle(double length, double with) {
        this.length = length;
        this.with = with;
    }

    @Override
    public double getArea() {
        return length * with;
    }

    @Override
    public double getLength() {
        return 2 * (length + with);
    }
}
