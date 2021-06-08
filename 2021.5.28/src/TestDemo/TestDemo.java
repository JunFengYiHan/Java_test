package TestDemo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-31
 * Time: 0:29
 */
class A<T> {
    T value;
    A(T value) {
        this.value = value;
    }
    T get() {
        return value;
    }
}
public class TestDemo {
    public static void main(String[] args) {
        A<Integer> a = new A<>(100);
        System.out.println(a);
    }
}
