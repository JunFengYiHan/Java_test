/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-04-26
 * Time: 18:59
 */
public class TestDome {

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.elem = new int[5];
        myArrayList.add(0,4);
        myArrayList.add(1,2);
        myArrayList.add(2,3);
        myArrayList.add(3,1);
        myArrayList.add(4,5);
        myArrayList.add(5,6);
        //myArrayList.add(0,99);
        myArrayList.display();
        //System.out.println(myArrayList.contains(3));
        //System.out.println(myArrayList.search(3));
        System.out.println("==============================");
        //System.out.println(myArrayList.getPos(5));
        myArrayList.setPos(2,99);
        myArrayList.display();
    }
}

