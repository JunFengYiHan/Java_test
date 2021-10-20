package 其他练习.学校练习.第1次作业;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-09-26
 * Time: 17:02
 */
public class TestOne {
    public static void print(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n-i; j++) {
                System.out.print(" ");//打印合适的空格
            }
            for (int j = 0; j < i; j++) {
                System.out.print("* ");//打印合适的星号
            }
            System.out.println();
        }

    }

    public static void findMaxNum(int bound) {
        int MaxN = 0;//存放最大得n,可省
        for (int i = 1; (1.0+i)*i/2 < bound; i++) {
            MaxN = i;//不断更新MaxN
        }
        //MaxN==i-1
        System.out.println(MaxN);
    }

    public static void perfectNum(int end) {
        for (int i = 1; i <= end; i++) {
            int sum = 0;//存放当前数因子和
            for (int j = 1; j <= i/2; j++) {
                if (i%j==0) {
                    sum += j;//累加因子
                }
                //判断并输出完数
                if (sum==i) {
                    System.out.println(sum+"是"+end+"以内得完数");
                    break;
                }
            }
        }
    }

    public static void sum(int val,int n) {
        double sum = 0.0;//存放和
        double tmp = 0.0;//存放当前数
        for (int i = 0; i < n; i++) {
            tmp = tmp*10 + val;//求得当前数
            sum += tmp;//累加
        }
        System.out.println(sum);
    }

    public static void fact(int n) {
        double sum = 0.0;//存放阶乘和
        double s = 1.0;//存放阶乘
        for (int i = 1; i <= n; i++) {
            s *= i;//求得当前i得阶乘
            sum += s;//累加阶乘
        }
        System.out.println(sum);
    }

    public static void func() {
        int sum = 0;//和
        int symbol = 1;//符号

        for (int i = 13; i <= 1003; i+=10) {
            sum += symbol*i;//求和
            symbol = -symbol;//更新符号
        }
        System.out.println(sum);
    }

    public static void narNum(int n) {
        int start = (int)Math.pow(10,n-1);
        int end = (int)Math.pow(10,n);
        for (int i = start; i < end; i++) {
            int tmp = i;//防止修改i
            int sum = 0;//存放每次该数的自幂和
            //求各位次方之和
            while(tmp!=0) {
                sum+=Math.pow(tmp%10,n);
                tmp/=10;
            }
            //和等于该数说明是自幂数
            if (sum==i) {
                System.out.println(i+"是一个"+n+"位的自幂数");
            }
        }
    }
}
