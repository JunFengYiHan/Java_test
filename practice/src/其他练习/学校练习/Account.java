package 其他练习.学校练习;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-09-29
 * Time: 19:40
 */
public class Account {
    private static final char[] base = createBase();//标识符取值的目标数组
    private static final HashSet<String> flagSet = new HashSet<>();//存放已使用过的标识符,确保唯一
    private final String flag = createFlag();//标识符
    private String name;//账户名
    private final Date date =  new Date();;//开户日期
    private String password = "123456";//账户默认密码
    private BigDecimal balance;//账户余额

    public Account(){}
    public Account(String name) {
        this.name = name;
        this.balance = new BigDecimal(0);
    }

    public Account(String name, double value) {
        this.name = name;
        this.balance = new BigDecimal(value);
    }
    //产生一个存放英文字母和数字的目标数组
    private static char[] createBase() {
        char[] base = new char[62];
        int use = 0;
        char i = '0';
        while(i<='z') {
            base[use++] = i++;
            if (i=='9'+1) {
                i='A';
            }
            if (i=='Z'+1) {
                i = 'a';
            }
        }
        return base;
    }
    //产生一个标识符
    private String createFlag() {
        boolean num = false;//标识是否出现数字
        boolean ch = false;//标识是否出现字母
        StringBuilder sb;
        Random random = new Random();
        do {
            sb = new StringBuilder();
            while(sb.length()<11) {
                int index = random.nextInt(62);
                sb.append(base[index]);
                if (index<=9) {
                    num = true;
                }
                if (index>9) {
                    ch = true;
                }
            }
        }while(!num || !ch || flagSet.contains(sb.toString()));
        flagSet.add(sb.toString());
        return sb.toString();
    }

    //存款
    public boolean deposit(double value) {
        BigDecimal val = new BigDecimal(value);
        this.balance = this.balance.add(val);
        return true;
    }
    //取款
    public boolean withdrawal(double value) {
        BigDecimal val = new BigDecimal(value);
        if (val.compareTo(this.balance)==1) {
            System.out.println("余额不足");
            return false;
        }
        this.balance = this.balance.subtract(val);
        return true;
    }
    //获取标识符
    public String getFlag() {
        return flag;
    }
    //获取账户名
    public String getName() {
        return name;
    }
    //修改账户名
    public void setName(String name) {
        this.name = name;
    }
    //获取开户日期
    public Date getDate() {
        return date;
    }
    //获取当前密码
    public String getPassword() {
        return password;
    }
    //判断字符串是不是由数字组成
    private boolean isNum(String password) {
        for (int i = 0; i < password.length(); i++) {
            char tmp = password.charAt(i);
            if (tmp<'0'||tmp>'9') {
                return false;
            }
        }
        return true;
    }
    //修改密码
    public boolean setPassword(String password) {
        if (password.length()>6 || !this.isNum(password)) {
            System.out.println("密码过长或者不止包含数字");
            return false;
        }
        this.password = password;
        return true;
    }
    //获取余额
    public BigDecimal getBalance() {
        return balance;
    }
}
