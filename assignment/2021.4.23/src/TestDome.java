/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-04-23
 * Time: 18:34
 */


class Person {
//    public String name;
//    //public static String name;
//    public String sex;
//    public int age;
    private String name;
    private String sex;
    private int age;

    public Person(){
        System.out.println("没有参数的构造方法");
    }
    public Person(String str){
        this.name = str;
        System.out.println("一个参数的构造方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //....人的属性
}
public class TestDome {
    public static void main(String[] args) {
        Person person = new Person("张三");
        //person.setName("张三");
        person.setSex("男");
        person.setAge(18);
        System.out.println(person.getName());
        System.out.println(person.getSex());
        System.out.println(person.getAge());


//        Person person = new Person();
//        person.name = "张三";
//        person.sex = "男";
//        person.age = 18;
//        System.out.println(person.name);
//        System.out.println(person.sex);
//        System.out.println(person.age);
    }

    public static void main2(String[] args) {
        //System.out.println(Person.name);
    }

    public static void main1(String[] args) {
//        Person person = new Person();
//        System.out.println(person.name);
//        System.out.println(person.sex);
//        System.out.println(person.age);
//        System.out.println("========赋值前后分割线=======");
//        person.name = "张三";
//        person.sex = "男";
//        person.age = 18;
//        System.out.println(person.name);
//        System.out.println(person.sex);
//        System.out.println(person.age);
    }
}
