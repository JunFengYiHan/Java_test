package 其他练习.学校练习.Java实验.第5次作业;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-18
 * Time: 19:45
 */
public class Cylinder extends Circle{
    private double height;
    public Cylinder(double r,double h) {
        this.radius = r;
        this.height = h;
    }
    //获取高度
    public double getHeight() {
        return this.height;
    }
    //获取面积
    public double getVol() {
        return super.getArea()*this.height;
    }
    //输出结果
    public void dispVol() {
        System.out.println(getVol());
    }
}
