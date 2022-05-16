package sql.jdbc;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-05-16
 * Time: 21:19
 */
public class JDBCTest2 {
    public static void main(String[] args) throws SQLException {
        //创建DataSource
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/test?character=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("077512");
        //建立链接
        Connection connection = dataSource.getConnection();
        //拼接sql
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要删除的学生id: ");
        int id = scanner.nextInt();
        String sql = "delete from stu where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        //执行sql
        int ret =  statement.executeUpdate();
        System.out.println(statement);
        System.out.println(ret);
        statement.close();
        connection.close();
    }
}
