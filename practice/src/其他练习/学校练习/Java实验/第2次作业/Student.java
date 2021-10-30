package 其他练习.学校练习.Java实验.第2次作业;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-09-26
 * Time: 15:49
 */
public class Student {
    private String id;//学号
    private String name;//姓名
    private double math;//数学成绩
    private double english;//英语成绩
    private double computer;//计算机成绩

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public double getComputer() {
        return computer;
    }

    public void setComputer(double computer) {
        this.computer = computer;
    }

    //显示定义无参构造
    public Student() {

    }
    //有参构造,部分初始化
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
    //有参构造全部初始化
    public Student(String id, String name, double math, double english, double computer) {
        this.id = id;
        this.name = name;
        this.math = math;
        this.english = english;
        this.computer = computer;
    }

    //获取总成绩
    public double sum() {
     return this.math+this.english+this.computer;
    }

    //获取平均分
    public double average() {
        return this.sum()/3;
    }

    //获取最高分
    public double getMaxScore() {
        double max = this.math;
        if (max<this.english) {
            max = this.english;
        }
        if (max<this.computer) {
            max = this.computer;
        }
        return max;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //获取最低分
    public double getMinScore() {
        double min = this.math;
        if (min>this.english) {
            min = this.english;
        }
        if (min>this.computer) {
            min = this.computer;
        }
        return min;
    }
}
