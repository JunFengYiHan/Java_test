package demo1;

import demo.Animal;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-21
 * Time: 22:37
 */
class Dog extends Animal{
    public void func(){
        super.name = "大黄";
        super.sex = "雄性";
        super.eat();
        super.sleep();
    }
}
public class Test1 {
    public static void main1(String[] args) {
        Dog dog = new Dog();
        dog.func();
    }

}
