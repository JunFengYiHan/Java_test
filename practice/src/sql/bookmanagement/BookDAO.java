package sql.bookmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-05-17
 * Time: 11:30
 */
// DAO Data Access Object
public class BookDAO {
    //1. 新增书籍 insert
    public boolean add(Book book) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // 建立链接
            connection = DBUtil.getConnection();
            //拼装sql
            String sql = "insert into book values(null,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, book.getName());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getPrice());
            statement.setString(4, book.getType());
            statement.setInt(5, book.isBorrow() ? 1 : 0);
            //执行sql
            int ret = statement.executeUpdate();
            //单次插入一行数据
            if (ret != 1) {
                return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
        return false;
    }

    //2. 显示所有书籍 select
    public List<Book> selectALL() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Book> books = new LinkedList<>();
        try {
            //获取链接
            connection = DBUtil.getConnection();
            //拼装sql
            String sql = "select * from book";
            statement = connection.prepareStatement(sql);
            //执行sql
            resultSet = statement.executeQuery();
            //遍历结果集合
            while (resultSet.next()) {
                Book book = new Book();
                book.setBookId(resultSet.getInt("bookId"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                book.setPrice(resultSet.getInt("price"));
                book.setType(resultSet.getString("type"));
                book.setBorrow(resultSet.getInt("isBorrowed") == 1);
                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return books;
    }

    //3. 显示指定书籍 select
    public List<Book> selectByName(String name) {
        List<Book> books = new LinkedList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //获取链接
            connection = DBUtil.getConnection();
            //拼装sql
            String sql = "select * from book where name = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            //执行sql
            resultSet = statement.executeQuery();
            //遍历结果
            while (resultSet.next()) {
                Book book = new Book();
                book.setBookId(resultSet.getInt("bookId"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                book.setPrice(resultSet.getInt("price"));
                book.setBorrow(resultSet.getInt("isBorrowed") == 1);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return books;
    }

    //4. 删除书籍 delete
    //按id删除
    public boolean delete(int bookId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //获取链接
            connection = DBUtil.getConnection();
            //拼装sql
            String sql = "delete from book where bookId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, bookId);
            //执行sql
            int ret = statement.executeUpdate();
            if (ret != 1) {
                return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
        return false;
    }

    //按名字删除
    public boolean delete(String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //获取链接
            connection = DBUtil.getConnection();
            //拼装sql
            String sql = "delete from book where name = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            //执行sql
            int ret = statement.executeUpdate();
            if (ret == 0) {
                System.out.println("没有名字为" + name + "的书籍");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
        return false;
    }

    //5. 借阅书籍 update
    public boolean borrowBook(int bookId) {
        Connection connection = null;
        PreparedStatement statement1 = null;
        PreparedStatement statement2 = null;
        ResultSet resultSet = null;
        try {
            //先判断能否被借阅
            //获取链接
            connection = DBUtil.getConnection();
            //拼装sql
            String sql = "select * from book where bookId = ?";
            statement1 = connection.prepareStatement(sql);
            statement1.setInt(1, bookId);
            //执行sql
            resultSet = statement1.executeQuery();
            //判断是否存在
            if (resultSet.next()) {
                //存在就判断是否借出
                boolean isBorrowed = resultSet.getInt("isBorrowed") == 1;
                if (isBorrowed) {
                    //System.out.println("id为" + bookId + "的书已被借出");
                    return false;
                }
            } else {
                return false;
            }
            //可以借阅
            sql = "update book set isBorrowed = 1 where bookId = ?";
            // 创建第二个statement
            statement2 = connection.prepareStatement(sql);
            statement2.setInt(1, bookId);
            int ret = statement2.executeUpdate();
            if (ret != 1) {
               // System.out.println("借阅失败");
                return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            //释放第一个statement
            if (statement1 != null) {
                try {
                    statement1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            DBUtil.close(connection, statement2, resultSet);
        }

        return false;
    }

    //6. 归还书籍 update
    public boolean returnBook(int bookId) {
        Connection connection = null;
        PreparedStatement statement1 = null;
        PreparedStatement statement2 = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from book where bookId = ?";
            statement1 = connection.prepareStatement(sql);
            statement1.setInt(1, bookId);
            resultSet = statement1.executeQuery();
            if (resultSet.next()) {
                boolean isBorrowed = resultSet.getInt("isBorrowed") == 0;
                if (isBorrowed) {
                    System.out.println("未被借出");
                    return false;
                }
            } else {
                return false;
            }
            sql = "update book set isBorrowed = 1 where bookId = ?";
            statement2 = connection.prepareStatement(sql);
            statement2.setInt(1,bookId);
            int ret = statement2.executeUpdate();
            if(ret!=1) {
                System.out.println("归还失败");
                return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
