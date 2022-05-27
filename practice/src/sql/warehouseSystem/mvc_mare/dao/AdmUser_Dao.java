package sql.warehouseSystem.mvc_mare.dao;



import sql.warehouseSystem.mvc_mare.model.AdmUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdmUser_Dao {

    public static AdmUser check(Connection c, AdmUser user) throws SQLException {
        AdmUser result=null;
        String sql="select * from 管理员表 where 姓名=? and 密码=? ";
        PreparedStatement pst=c.prepareStatement(sql);

        pst.setString(1,user.getAdministrstords_name());
        pst.setString(2, user.getAdministrstords_password());

        ResultSet rs=pst.executeQuery();

        if(rs.next()){
            result=new AdmUser();
            result.setId(rs.getInt("仓库管理员ID"));
            result.setAdministrstords_name(rs.getNString("姓名"));
            result.setAdministrstords_password(rs.getNString("密码"));
        }
        return result;
    }
}
