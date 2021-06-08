package demo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-22
 * Time: 19:44
 */
interface IRun extends People{

}
public class Teacher implements People,IRun{


    @Override
    public void work() {
        System.out.println("教书");
    }

    @Override
    public void eat() {
        System.out.println("拉面");
    }
}
