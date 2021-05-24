package demo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-22
 * Time: 12:54
 */
class Cat extends Animal {
    //什么都不写，只是继承了Animal
}
public class TestDemo {

    public static void main(String[] args) {
        //Animal animal = new Animal();
        Cat cat = new Cat();
        cat.name = "花花";
        cat.sex = "雌性";
        cat.eat();
        cat.sleep();
    }

    public static  void main1(String[] args) {
        Person person = new Person();//实例化一个对象
        person.setName("JunFengYiHan");
        person.setAge(18);
        person.setHeight(179);
        System.out.println(person);
        //person.eat("JunFengYiHan");
    }


}
