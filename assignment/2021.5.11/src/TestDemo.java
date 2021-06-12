/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-11
 * Time: 12:23
 */


public class TestDemo {
    public static void main(String[] args) {
        TestLinkedList testLinkedList = new TestLinkedList();
        testLinkedList.addFirst(1);
        testLinkedList.addFirst(2);
        testLinkedList.addFirst(3);
        testLinkedList.addFirst(4);
        testLinkedList.addLast(2);
        testLinkedList.addLast(3);
        testLinkedList.addLast(4);
        testLinkedList.addIndex(0,99);
        testLinkedList.addIndex(8,99);
        testLinkedList.addIndex(9,99);
        testLinkedList.display();
        System.out.println(testLinkedList.contains(4));
        System.out.println(testLinkedList.size());
        testLinkedList.clear();
        System.out.println("====================");
        testLinkedList.remove(1);
        //testLinkedList.removeAllKey(4);
        System.out.println(testLinkedList.size());
        System.out.println(testLinkedList.contains(4));
        testLinkedList.clear();
        testLinkedList.display();
    }
}
