/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-04-02
 * Time: 22:44
 */
public class TestDome {
    public static void main(String[] args) {
        
    }
    public static void main3(String[] args) {
        for (int i = 2; i <=100 ; i++) {
            int j = 0;
            for (j = 2; j <i ; j++) {
                if(i%j==0){
                    break;
                }
            }
            if(j==i){
                System.out.println(i);
            }
        }
    }
    public static void main2(String[] args) {
        for (int i = 1000; i <=2000 ; i++) {
            if(i%400==0||i%100!=0&&i%4==0){
                System.out.println(i);
            }
        }
    }
    public static void main1(String[] args) {
        int count=0;
        for (int i = 9; i <= 100; i++) {
            int j=i;
            while(j>=9){
                if(j%10==9){
                    count++;
                }
                j/=10;
            }
        }
        System.out.println(count);
    }
}
