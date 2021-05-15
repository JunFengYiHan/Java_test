/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-15
 * Time: 16:15
 */
public class TestDemo {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addLast(99);
        myLinkedList.addLast(10);
        myLinkedList.addIndex(0,99);
        myLinkedList.addIndex(0,99);
        myLinkedList.addIndex(7,99);
        myLinkedList.addIndex(4,99);
        myLinkedList.display();
        System.out.println("=================");

//        myLinkedList.removeAllData(99);
//        myLinkedList.clear();
//        System.out.println(myLinkedList.search(0));
        myLinkedList.modify(0,5);
//        System.out.println(myLinkedList.contains(99));
//        myLinkedList.removeFirstData(99);
//        System.out.println(myLinkedList.contains(99));
//        myLinkedList.removeFirstData(99);
//        myLinkedList.removeAllData(99);
//        System.out.println(myLinkedList.contains(99));
//        myLinkedList.removeFirstData(99);
//        System.out.println(myLinkedList.contains(99));
//        myLinkedList.removeAllData(99);
        myLinkedList.display();
    }
}
