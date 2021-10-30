package 其他练习.学校练习.Java实验.第5次作业;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-18
 * Time: 19:24
 */
public class Circle {
    protected double radius;//半径

    public Circle() {
        this.radius = 0.0;
    }
    public Circle(double r) {
        this.radius = r;
    }
    //获取半径
    public double getRadius() {
        return this.radius;
    }
    //获取周长
    public double getPerimeter() {
        return 2*this.radius*Math.PI;
    }
    //获取面积
    public double getArea() {
        return radius*radius*Math.PI;
    }
    //输出结果
    public void disp() {
        System.out.println("半径:"+this.radius+"\n周长:"+this.getPerimeter()+"\n面积:"+this.getArea());
    }
}
