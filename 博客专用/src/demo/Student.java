package demo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-22
 * Time: 19:44
 */
public class Student implements People{

    @Override
    public void work() {
        System.out.println("学习");
    }

    @Override
    public void eat() {
        System.out.println("大米饭");
    }
}
