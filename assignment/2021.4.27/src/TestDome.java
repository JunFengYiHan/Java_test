/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-04-27
 * Time: 19:24
 */
public class TestDome {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addFirst(1);
//        myLinkedList.addFirst(2);
////        myLinkedList.addFirst(3);
////        myLinkedList.addLast(4);
//        myLinkedList.addLast(5);
//        myLinkedList.addLast(6);
        myLinkedList.display();
        myLinkedList.addIndex(0,18);
        myLinkedList.addIndex(0,18);
        myLinkedList.addIndex(0,18);
//        myLinkedList.addIndex(6,8);
        myLinkedList.display();
//        myLinkedList.remove(18);
//        myLinkedList.remove(18);
//        myLinkedList.remove(8);
        myLinkedList.removeAllKey(18);
       // myLinkedList.removeAllKey(8);
        myLinkedList.display();
        myLinkedList.clear();
        myLinkedList.display();
        System.out.println(myLinkedList.contains(18));
        System.out.println(myLinkedList.contains(1));

    }
}
