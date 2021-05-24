package demo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-22
 * Time: 19:51
 */
public abstract class People extends Person{
     public String name;
     public void run(){
         System.out.println(this.name+"run");
     }
     //public abstract void work();
     public static void main(String[] args) {

     }
}
