package demo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-22
 * Time: 19:51
 */
public  interface People /*abstract extends Person*/{
     int a = 0;
     public int b = 1;
     public static int c = 2;
     public static final int d = 3;
//     void A();
//     public void B();
//     public abstract void C();
     void work();
     void eat();
     default void run(){

     }
    // public static final String name = "忆寒";

     //public abstract void work();



//     public static void main(String[] args) {
//          //People people = new People();
//     }
}

//public  class People /*abstract extends Person*/{
//     public String name;
//     //public abstract void work();
//     public  void work(){
//          System.out.println("睡觉");
//     }
//     public  void eat(){}
////     public static void main(String[] args) {
////          //People people = new People();
////     }
//}
