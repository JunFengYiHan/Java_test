package sql.jdbc;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-05-16
 * Time: 13:22
 */
public class JDBCTest1 {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        //设置访问地址                          | 协议固定形式| 本机IP   |端口号|数据库名|  字符集             |传输数据是否加密|
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8&useSSL=false");
        //设置用户名
        ((MysqlDataSource)dataSource).setUser("root");
        //设置访问密码
        ((MysqlDataSource)dataSource).setPassword("077512");
        //下面写法没问题,但是更换数据库较为麻烦
//        MysqlDataSource mysqlDataSource = new MysqlDataSource();
//        mysqlDataSource.setUrl();
//        mysqlDataSource.setUser();
//        mysqlDataSource.setPassword();

        Connection connection = dataSource.getConnection();
//      构造一个对象
        String sql = "insert into stu values (?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入id:");
        int id = scanner.nextInt();
        System.out.print("请输入名字:");
        String name = scanner.next();
        statement.setInt(1,id);
        statement.setString(2,name);
//      statement提供了两个方法
        //executeUpdate(),用于增加,删除,修改; 返回值表示当前操作影响了几行
        //executeQuery(),用于查找 返回值为ResultSet,表示一张表
        System.out.println(statement);
        int ret = statement.executeUpdate();

        System.out.println("ret = " + ret);
        //释放资源
        statement.close();
        connection.close();
    }
}
