/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-19
 * Time: 20:39
 */
class A{
    int n;
    public A () {

    }
}
class B extends A{
    int n;
    public B (){
        super();
    }
}
public class TestDemo {
    public static void main(String[] args) {
        B b = new B();
    }
}
