package 其他练习.学校练习.实践测试题.动物声音模拟器;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-12-21
 * Time: 16:25
 */
public class Simulator {
    public void sound(Animal animal) {
        System.out.println(animal.getAnimalName());
        animal.cry();
    }
    public void display(Animal animal) {
        animal.play();
    }
}
