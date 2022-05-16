package sql.jdbc;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-05-16
 * Time: 22:16
 */
public class JDBCTest3 {
    public static void main(String[] args) throws SQLException {
        //创建DataSource
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/test?character=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("077512");
        //建立链接
        Connection connection = dataSource.getConnection();
        //拼接sql
        String sql = "update stu set name = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,"李少峰");
        statement.setInt(2,1);
        //执行sql
        int ret =  statement.executeUpdate();
        System.out.println(statement);
        System.out.println("ret = "+ret);

        statement.close();
        connection.close();
    }
}
