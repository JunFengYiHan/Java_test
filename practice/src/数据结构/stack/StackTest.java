package 数据结构.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-07-24
 * Time: 8:45
 */
class MyStack<T>{
    private T[] elem;
    private int size;//元素个数

    public MyStack() {
        this.elem = (T[]) new Object[3];//小一点方便测试扩容
    }
    //插入元素
    public T push(T data) {
        if (this.size==this.elem.length) {
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        this.elem[size++] = data;
        return data;
    }
    //弹出栈顶元素
    public T pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return this.elem[--size];
    }
    //获取栈顶元素
    public T peek() {
        return this.elem[size-1];
    }
    //判断是否为空
    public boolean empty() {
        return this.size == 0;
    }
}
public class StackTest {
    public static void main(String[] args) {
        MyStack<Integer> s = new MyStack<>();
        System.out.println(s.push(1));
        System.out.println(s.push(2));
        System.out.println(s.push(5));
        System.out.println(s.push(7));
        System.out.println(s.empty());

        System.out.println(s.peek());

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

        System.out.println(s.empty());
        s.pop();
    }
}
