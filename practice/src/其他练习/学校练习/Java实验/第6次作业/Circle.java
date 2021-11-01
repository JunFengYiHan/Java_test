package 其他练习.学校练习.Java实验.第6次作业;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-11-01
 * Time: 16:36
 */
//圆形
public class Circle extends Shapes implements Shape{
    double r;

    public Circle() {

    }

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double getArea() {
        return r * r * Math.PI;
    }

    @Override
    public double getLength() {
        return 2 * r * Math.PI;
    }

    @Override
    public double size() {
        return getArea();
    }
}
