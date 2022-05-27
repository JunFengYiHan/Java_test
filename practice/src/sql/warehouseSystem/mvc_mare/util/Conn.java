package sql.warehouseSystem.mvc_mare.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Conn {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/warehouse?character=utf8&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "077512";
    private static DataSource dataSource = null;
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
    public static Connection getCon() throws SQLException {
        return getDataSource().getConnection();
    }


//    private String driver = "com.mysql.cj.jdbc.Driver";
//    private String url="jdbc:mysql://127.0.0.1:3306/warehouse";
//    private String user="root";
//    private String password="077512";
//    public Connection getCon()throws Exception{
//        Class.forName(driver);
//        Connection con;
//        con= DriverManager.getConnection(url,user,password);
//        return con;
//    }
    public void closeCon(Connection con)throws Exception{
        if(con!=null)
            con.close();
    }

    public static void main(String[] args){
        Conn conn=new Conn();
        try {
            conn.getCon();
            System.out.printf("连接成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.printf("连接失败");
        }
    }
}
