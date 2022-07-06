package 笔试练习.另类加法;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-10-21
 * Time: 18:34
 */
public class UnusualAdd {
    public int addAB(int A, int B) {
        if (B == 0) {
            return A;
        }
        int carry = A & B;
        A ^= B;
        return addAB(A, carry << 1);
    }

    //    public int addAB(int A, int B) {
//        int carry;//保证进位
//        do{
//            carry = A&B;
//            A = A ^ B;
//            B = carry<<1;
//        }while(B!=0);
//        return A;
//    }

//    public int addAB(int A, int B) {
//        int C = A & B;
//        while (C != 0) {
//            A ^= B;
//            B = C << 1;
//            C = A & B;
//        }
//        return A ^ B;
//    }
}
