import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-04-26
 * Time: 19:56
 */
public class MyArrayList {
    public int[] elem ;//= new int[5];
    public int usedSize;//有效长度

    // 打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    public boolean isFull() {
        if(this.usedSize == this.elem.length){
            return true;
        }
        return false;
    }
    // 在 pos 位置新增元素
    public  void add(int pos,int date) {
        if(pos<0||pos>this.usedSize){
            System.out.println("pos位置不合法");
            return;
        }

        if(isFull()) {
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }

        for (int i = this.usedSize - 1; i >= pos ; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = date;
        this.usedSize++;
    }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind){
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind){
                return i;
            }
        }
        return -1;//未找到标记为-1
    }
    // 获取 pos 位置的元素
     public int getPos(int pos) {
         if(pos<0||pos>this.usedSize){
            return -1;
        }
         return this.elem[pos];
    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if(pos<0||pos>=this.usedSize){
            System.out.println("pos位置非法");
            return;
        }
        this.elem[pos] = value;
    }
    //删除第一次出现的关键字toRemove
    public void remove(int toRemove) {
        int index = this.search(toRemove);
        if(index == -1){
            System.out.println("不存在该数字");
            return;
        }
        for (int i = index; i < this.usedSize - 1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }
    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }
    // 清空顺序表
    public void clear() {
        this.usedSize = 0;
    }
}
    