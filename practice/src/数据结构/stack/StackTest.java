package 数据结构.stack;


public class StackTest {
    public static void main(String[] args) {

        MyStack<Integer> s = new MyStack<>();
        System.out.println(s.push(1));
        System.out.println(s.push(2));
        System.out.println(s.push(5));
        System.out.println(s.push(7));
        System.out.println(s.empty());

        System.out.println(s.peek());
        int n = s.peek();
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

        System.out.println(s.empty());
        //s.pop();
    }
}
