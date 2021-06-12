import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-06-04
 * Time: 20:02
 */
public class MyStack {
    private int[] elem;//数组
    private int top;//当前可以存放数据元素的下标-》栈顶指针
    private int size;
    public MyStack() {

        this.elem = new int[10];
        this.size=10;
    }

    /**
     * 入栈操作
     * @param item 入栈的元素
     */
    public void push(int item) {
//1、判断当前栈是否是满的
        if(this.top==this.size){
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
            //return;
        }
//2、elem[top] = item top++;
        this.elem[top++] = item;
    }

    /**
     * 出栈
     * @return 出栈的元素
     */
    public int pop() {
        return this.elem[--top];
    }

    /**
     * 得到栈顶元素，但是不删除
     * @return
     */
    public int peek() {
        return this.elem[top-1];
    }

    public boolean empty(){
        return this.top == 0;
    }

}