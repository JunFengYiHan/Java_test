/**
 * Created with IntelliJ IDEA.
 * Description:
 * * Java集合当中 LinkedList 底层是一个双向链表  这里只是用了一下名字
 * User: 柒
 * Date: 2021-04-27
 * Time: 19:59
 */

class ListNode {
    public int val;//值
    public ListNode next;//存储下一个节点的地址  也就是说 这个是一个引用
    public ListNode() {
    }
    public ListNode(int val) {
        this.val = val;
    }
}

public class MyLinkedList {
    public ListNode head;//标识整个链表的头

    public static void main(String[] args) {

    }
    //得到单链表的长度
    public int size(){
        ListNode tmp = this.head;
        int count = 0;
        while(tmp!=null){
            tmp = tmp.next;
            count++;
        }
        return count;
    }
    //头插法
    public void addFirst(int data) {
        ListNode listNode = new ListNode(data);
        listNode.next = this.head;
        this.head = listNode;
    }
    //尾插法
    public void addLast(int data) {
        ListNode listNode = new ListNode(data);
        ListNode tmp = this.head;
        if(this.head==null){
            this.head =listNode;
            return;
        }
        while(tmp.next!= null){
            tmp = tmp.next;
        }
        tmp.next = listNode;

//        while(tmp!=null){
//            tmp = tmp.next;
//        }
//        tmp = listNode;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) {
        if(index<0||index>this.size()){
            System.out.println("index不合法");
            return;
        }
        if(index == 0){
            this.addFirst(data);
            return;
        }
        if(index == this.size()){
            this.addLast(data);
            return;
        }
        ListNode node = new ListNode(data);
        ListNode cur = findIndexSubOne(index);
        node.next = cur.next;
        cur.next = node;

    }
    public ListNode findIndexSubOne(int index) {
        ListNode tmp = this.head;
        while(index>1){
            tmp = tmp.next;
            index--;
        }
        return tmp;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode tmp = this.head;
        for (int i = 0; i < this.size(); i++) {
            if(tmp.val == key){
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        ListNode tmp = this.head;
        ListNode node = tmp;
        if(this.head.val==key){
            this.head = this.head.next;
            return;
        }
        while(tmp!=null && tmp.val!=key){
            node = tmp;
            tmp = tmp.next;
        }
        if(tmp==null){
            System.out.println("不存在key");
            return;
        }
        node.next = tmp.next;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode tmp = this.head;
        ListNode node = tmp;
        while(this.head!=null && this.head.val==key){
            this.head = this.head.next;
        }
//        if(this.head.val==key){
//
//        }
        while(true){
            while(tmp!=null && tmp.val!=key){
                node = tmp;
                tmp = tmp.next;
            }
            if(tmp==null){
                System.out.println(key+"删除完成");
                return;
            }
            node.next = tmp.next;
            tmp = tmp.next;
        }
    }

    public void clear() {
        ListNode tmp = this.head;
        while(tmp!=null){
            this.head=null;
            tmp = tmp.next;
            this.head=tmp;
        }
        System.out.println("链表已清空");
    }


//    public ListNode removeList() {
//
//    }
    /**
     * 穷举法，最low的方式 先建造一个链表出来，让你来感受一下
     */
//    public void createList() {
//        ListNode listNode1 = new ListNode(12);//12
//        ListNode listNode2 = new ListNode(45);
//        ListNode listNode3 = new ListNode(6);
//        ListNode listNode4 = new ListNode(8);
//        ListNode listNode5 = new ListNode(5);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        this.head = listNode1;//head引用  引用了 listNode1引用  引用的对象
//    }
    /**
     * 遍历链表：
     */
    public void display() {
        ListNode cur = this.head;
        //不能是this.head.next != null  这样写 最后一个节点是不能被打印的
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
}










//public class MyLinkedList {
//    //头插法
//    public void addFirst(int data) {}
//    //尾插法
//    public void addLast(int data) {}
//    //任意位置插入,第一个数据节点为0号下标
//    public boolean addIndex(int index,int data){}
//    //查找是否包含关键字key是否在单链表当中
//    public boolean contains(int key){}
//    //删除第一次出现关键字为key的节点
//    public void remove(int key){}
//    //删除所有值为key的节点
//    public void removeAllKey(int key){}
//    //得到单链表的长度
//    public int size(){
//
//    }
//    //打印链表
//    public void display(){}
//    //清空链表
//    public void clear(){}
//}
