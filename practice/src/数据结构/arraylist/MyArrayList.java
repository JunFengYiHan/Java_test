package 数据结构.arraylist;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-08-16
 * Time: 10:17
 */
public class MyArrayList<E> {
    private E[] elem;
    private int useSize;

    public MyArrayList() {
        this.elem = (E[])new Object[10];
    }

    public boolean add(E val) {
        if (this.isFull()) {
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        this.elem[this.useSize++] = val;
        return true;
    }

    public E remove (int index) {
        if (index<0||index>=this.useSize) {
            throw new IndexOutOfBoundsException();
        }
        E tmp = this.elem[index];
        for (int i = index; i < this.useSize-1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.useSize--;
        return tmp;
    }

    private boolean isFull() {
        return this.useSize==this.elem.length;
    }
}
