package 其他练习.杂七杂八;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-10
 * Time: 20:31
 */
class A{
    public A run(A a){
        System.out.println("A run()");
        return a;
    }
    public A(){

    }
}
class B extends A{
    public B(){
        //this(10);//只能存在一个，因为都必须是第一条语句
        super();

    }
    public B(int n) {
        this();
    }
    @Override
    public B run(A a) {
        System.out.println("B run()");
        return (B)a;
    }
}
public class TestDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(10_0000));
        }
        Set<Integer> set = new HashSet<>();
        for (Integer data : list) {
            if (!set.add(data)) {
                System.out.println(data);
                break;
            }
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer data : list) {
            map.put(data,map.getOrDefault(data,0) + 1);
        }
        System.out.println(map);
        Iterator<Map.Entry<Integer,Integer>> it = map.entrySet().iterator();
//        while (it.hasNext()) {
//            //类似于Scanner的用法
//            Map.Entry<Integer,Integer> entry = it.next();
//            System.out.println("key:"+entry.getKey()+" value:"+entry.getValue()+" ");
//        }
    }
    public static void main2(String[] args) {

        String[] arr = {"a","b","c"};
        String[] a = (String[]) arr;
        String s = "hello";
        String t = new String("hello");
//        String t = "hello";
        char c[] = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(s.equals(t));
        System.out.println(t.equals(c));
        System.out.println(s==t);
        System.out.println(t.equals(new String("hello")));
    }
    public static void main1(String[] args) {
        A a = new A(){
            public void print(){
                System.out.println("hhh");
            }

        };

        Object object = new A();
        //A a = new A();
        B b = new B();
        //判断左边的实例是不是右边类的实例或者其子类的实例
        System.out.println(b instanceof A);

       // System.out.println(a instanceof B);
        System.out.println(object instanceof B);
//        A a = new B();
//        a.run(a);
    }
}
