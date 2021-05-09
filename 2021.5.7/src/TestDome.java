/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-07
 * Time: 22:06
 */
public class TestDome {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addFirst(1);
//        myLinkedList.addFirst(2);
//        myLinkedList.addFirst(3);
//        myLinkedList.addFirst(4);
        myLinkedList.addLast(5);
        myLinkedList.addLast(5);
        myLinkedList.addLast(6);
        myLinkedList.addLast(7);
        myLinkedList.addLast(7);
        myLinkedList.addLast(7);
        myLinkedList.display();
//        System.out.println(myLinkedList.contains(5));
//        myLinkedList.remove(7);
//        System.out.println(myLinkedList.contains(7));

        System.out.println();
//        myLinkedList.removeAllKey(7);
//        myLinkedList.removeAllKey(5);
        myLinkedList.removeAllKey(6);
//        myLinkedList.addIndex(0,0);
//        myLinkedList.addIndex(2,11);
//        myLinkedList.addIndex(7,8);
//        myLinkedList.addIndex(9,9);
//        myLinkedList.addIndex(10,10);
//        myLinkedList.clear();
        myLinkedList.display();

    }
}
