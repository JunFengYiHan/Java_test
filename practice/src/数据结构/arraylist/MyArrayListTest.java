package 数据结构.arraylist;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-08-16
 * Time: 10:18
 */
public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        //System.out.println(myArrayList.get(0));
        System.out.println(myArrayList.size());
        System.out.println(myArrayList.add("bc"));
        myArrayList.add("ac");
        myArrayList.add("fc");
        myArrayList.add("gc");
        System.out.println(myArrayList.add("hc"));
        System.out.println(myArrayList.size());
        System.out.println(myArrayList.remove(4));
        myArrayList.set(0,"abc");
        //myArrayList.set(-1,"abc");
        //myArrayList.set(7,"abc");
        System.out.println(myArrayList.add("jc"));
        myArrayList.add("lc");
        System.out.println(myArrayList.size());
        System.out.println(myArrayList.toString());
    }
}
