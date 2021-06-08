import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-28
 * Time: 19:13
 */
class MyArrayList<T>{
    private  T[] elem;
    private int size;
    public MyArrayList(){
        this.elem = (T[]) new Objects[10];
        //Integer [] arr = (Integer[]) new Objects[10];
    }
//    public MyArrayList(T[] elem, int size) {
//        this.elem = elem;
//        this.size = size;
//    }
}
class A <T> {
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
        A<String> a = new A<String>("100");
        String value = a.get();
        System.out.println(value);
//        System.arraycopy();
    }




//    public class T {}
//    public class A extends T{}
//    public class B extends A{}
//        public static void main5(String[] args){
//            List<Class<? extends T>> list = new ArrayList<>();
//            A a =new A();
//            list.add();
        //}

    private static void testMethod(){
        System.out.println("testMethod");
    }

    public static void main1(String[] args) {

        //((TestDemo)null).testMethod();
//        try {
//            int a = 0;
//            // do something that may cause an Exception
//
//        } catch (java.io.FileNotFoundException ex) {
//
//            System.out.print("FileNotFoundException!");
//
//        } catch (java.io.IOException ex) {
//
//            System.out.print("IOException!");
//
//        } catch (java.lang.Exception ex) {
//
//            System.out.print("Exception!");
//
//        }
    }
}
