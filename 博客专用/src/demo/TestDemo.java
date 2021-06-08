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
    public static void eat(People people){
        people.eat();
    }
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        Student student = new Student();
        eat(teacher);
        eat(student);
    }



    public static void work(People people){
        people.work();
    }
    public static void main3(String[] args) {
        //People people1 = new People();
        //People people2 = new Teacher();
       // People people = new People();
        Teacher teacher = new Teacher();
        Student student = new Student();
      //  work(people);
        work(teacher);
        work(student);
       // people1.work();
        //people2.work();
       // teacher.work();
//        Teacher teacher = new Teacher();
//         People people =  new Teacher();
//         Teacher teacher = (Teacher) people;
//        cook(teacher);
    }

    public static People cook(People people){
        Teacher teacher = new Teacher();
        return teacher;
    }
    public static void main2(String[] args) {
        //Animal animal = new Animal();
        //Cat cat =  (Cat) animal;
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
