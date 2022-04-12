package 其他练习.学校练习.实践测试题.动物声音模拟器;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-12-17
 * Time: 14:27
 */
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Simulator simulator = new Simulator();
        simulator.sound(dog);
        simulator.display(dog);
        simulator.sound(cat);
        simulator.display(cat);
    }
}
