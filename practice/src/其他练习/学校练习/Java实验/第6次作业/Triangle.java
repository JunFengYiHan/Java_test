package 其他练习.学校练习.Java实验.第6次作业;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-11-01
 * Time: 16:34
 */
//三角形
public class Triangle extends Shapes {
    //三边长
    double a;
    double b;
    double c;

    public Triangle() {
    }

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        double p = getLength() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double getLength() {
        return a + b + c;
    }
}
