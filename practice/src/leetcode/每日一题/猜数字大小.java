//package leetcode.每日一题;
//
//import java.util.Random;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: 柒
// * Date: 2021-06-14
// * Time: 2:22
// */
//
//public class 猜数字大小 {
//
//    int guess(int num){
//        Random random = new Random();
//        int pick = random.nextInt(100);
//        //return Integer.compare(pick, num);和下面的if等效
//        if(pick<num){
//            return -1;
//        }else if(pick>num){
//            return 1;
//        }else{
//            return 0;
//        }
//    }
//    public int guessNumber(int n) {
//        int left = 1;
//        int right = n;
//        int mid = 1;
//        while(left<=right){
//            mid = left + (right-left >>2);//防止整型溢出
//            if(guess(mid)>0){
//                left = mid+1;//猜小了，去掉左边区间
//            }else if(guess(mid)<0){
//                right = mid-1;//猜大了，去掉右边区间
//            }else{
//                break;//猜对了跳出循环返回
//            }
//        }
//        //这个返回一定要有，不然Java编译都过不去
//        //所以就干脆跳出循环返回
//        return mid;
//    }
//}
