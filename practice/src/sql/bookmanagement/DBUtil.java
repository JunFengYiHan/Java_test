package sql.bookmanagement;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-05-17
 * Time: 10:49
 */
public class DBUtil {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/bookmanagement?character=utf8&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "077512";
    //单例设计
    //饿汉模式
//    private static final DataSource dataSource = new MysqlDataSource();
//    static {
//        ((MysqlDataSource)dataSource).setUrl(URL);
//        ((MysqlDataSource)dataSource).setUser(USERNAME);
//        ((MysqlDataSource)dataSource).setPassword(PASSWORD);
//    //获取链接
//    public static Connection getConnection() throws SQLException {
//        return dataSource.getConnection();
//    }

//  懒汉模式
    private static  DataSource dataSource = null;
    private static DataSource getDataSource() {
        if(dataSource==null) {
            dataSource = new MysqlDataSource();
            ((MysqlDataSource)dataSource).setUrl(URL);
            ((MysqlDataSource)dataSource).setUser(USERNAME);
            ((MysqlDataSource)dataSource).setPassword(PASSWORD);
        }
        return dataSource;
    }
    //获取链接
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
    //释放资源
    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet){
        if(connection!=null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement!=null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(resultSet!=null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
