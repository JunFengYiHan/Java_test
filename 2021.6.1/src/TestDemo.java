import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-01
 * Time: 20:10
 */
class Student{
    public String name;
    public String cla;
    public double score;

    public Student(String name, String cla, double score) {
        this.name = name;
        this.cla = cla;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", cla='" + cla + '\'' +
                ", score=" + score +
                '}';
    }
}
public class TestDemo {
    public static void main(String[] args) {
        String str1 = "welcome to bit";
        String str2 = "come";
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i <str1.length() ; i++) {
            if(!str2.contains(""+str1.charAt(i))){
                linkedList.add(""+str1.charAt(i));
            }
        }
        System.out.println(linkedList);
    }


    public static void main1(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(9);
        list.add(5);
        list.add(6);
        list.add(5);
        list.add(7);
        list.add(10);
        Collections.sort(list);
        System.out.println(list);
        LinkedList<Student> bit = new LinkedList<>();
        bit.add(new Student("张三","100期",88.5));
        bit.add(new Student("李四","100期",98.5));
        bit.add(new Student("王五","100期",75.5));
        for (Student s:bit) {
            System.out.println(s);
        }
//        ArrayList<Integer> list1 = new ArrayList();
//        list1.add(1);
//        list1.add(2);
//        list1.add(3);
//        ArrayList<Integer> list2 = new ArrayList(list1);
//        System.out.println(list2);
    }
}
