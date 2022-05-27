package sql.bookmanagement;

import sql.bookmanagement.operations.IOperation;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-05-17
 * Time: 9:58
 */
//+----------+-------------+------+-----+---------+----------------+
//| Field    | Type        | Null | Key | Default | Extra          |
//+----------+-------------+------+-----+---------+----------------+
//| userId   | int(11)     | NO   | PRI | NULL    | auto_increment |
//| userName | varchar(20) | YES  |     | NULL    |                |
//| password | varchar(20) | YES  |     | NULL    |                |
//| isAdmin  | int(11)     | YES  |     | NULL    |                |
//+----------+-------------+------+-----+---------+----------------+
abstract public class User {
    private int userId;
    private String userName;
    private String password;
    //可以进行的操作,针对管理员和普通用户各不相同
    protected IOperation[] iOperations;
    //根据参数调用对应方法
    public void doOperation(int choice) {
        iOperations[choice].work();
    }
    //菜单
    abstract public int menu();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
