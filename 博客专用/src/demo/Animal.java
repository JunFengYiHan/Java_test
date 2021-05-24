package demo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-05-22
 * Time: 12:52
 */
public class Animal{
    protected String name;
    protected String sex;
    protected void eat(){
        System.out.println(this.name+"吃饭！");
    }
    public void sleep(){
        System.out.println(this.name+"睡觉！");
    }
}
