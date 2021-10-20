package 其他练习.学校练习.第3次作业;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-09-26
 * Time: 16:50
 */
public class Rectangle {
    private double width;//宽
    private double height;//高
    private String  color;//颜色

    public Rectangle() {

    }

    public Rectangle(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    //获取面积
    public double getArea() {
        return this.width*this.height;
    }

    //获取周长
    public double getLength() {
        return 2*(this.width+this.height);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
