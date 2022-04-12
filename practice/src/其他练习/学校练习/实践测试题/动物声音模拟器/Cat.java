package 其他练习.学校练习.实践测试题.动物声音模拟器;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-12-21
 * Time: 16:29
 */
public class Cat implements Animal{
    @Override
    public void cry() {
        System.out.println("小猫喵喵叫");
    }

    @Override
    public String getAnimalName() {
        return "Cat";
    }

    @Override
    public void play() {
        climbTree();
    }

    public void climbTree() {
        System.out.println("小猫爬树");
    }
}
