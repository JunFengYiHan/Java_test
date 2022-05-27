package sql.warehouseSystem.mvc_mare.dao;


import sql.warehouseSystem.mvc_mare.model.Adm_input_ware;
import sql.warehouseSystem.mvc_mare.util.Stringutil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class input_ware_Dao {
    //填写入库表
    public static int input_ware(Connection conn , Adm_input_ware input) throws SQLException {

        String sql="INSERT INTO 入库表 VALUES (?,?,?,?,?,?,?,?)";

        PreparedStatement ps=conn.prepareStatement(sql);


        ps.setInt(1,input.getInput_id());
        ps.setInt(2,input.getUser_id());
        ps.setString(3,input.getGoods_name());
        ps.setString(4,input.getFactory());
        ps.setInt(5,input.getGoods_num());
        ps.setString(6,input.getData());
        ps.setString(7,input.getDelivery_man());
        ps.setInt(8,input.getID());

        return ps.executeUpdate();
    }
    //修改入库表
    public static int updata(Connection conn, Adm_input_ware input)throws Exception{

        String sql="update 入库表 set 仓库号=?,用户ID=?,商品名称=?,厂家=?,数量=?,日期=?,送货员工=? where 入库单号=?";

        PreparedStatement ps=conn.prepareStatement(sql);

        ps.setInt(1,input.getID());
        ps.setInt(2,input.getUser_id());
        ps.setString(3,input.getGoods_name());
        ps.setString(4,input.getFactory());
        ps.setInt(5,input.getGoods_num());
        ps.setString(6,input.getData());
        ps.setString(7,input.getDelivery_man());
        ps.setInt(8,input.getInput_id());

        return ps.executeUpdate();
    }
    //删除入库表记录
    public static int delete(Connection con, String id)throws Exception{

        String sql="delete from 入库表 where 入库单号=?";

        PreparedStatement ps=con.prepareStatement(sql);

        ps.setString(1,id);
        return ps.executeUpdate();
    }

    //查询入库表记录

    public static ResultSet list(Connection con, Adm_input_ware input)throws Exception{

        StringBuffer sb=new StringBuffer("select * from 入库表 ");

        if(Stringutil.isNotEmpty(input.getGoods_name())){

            sb.append(" and 商品名称 like '%"+input.getGoods_name()+"%'");
        }
        if(input.getUser_id()!=0){
            sb.append("and 用户ID like '%"+input.getUser_id()+"%'");
        }
        if(Stringutil.isNotEmpty(input.getFactory())){
            sb.append("and 厂家 like '%"+input.getFactory()+"%'");
        }
        if(Stringutil.isNotEmpty(String.valueOf(input.getData()))){
            sb.append("and 日期 like '%"+input.getData()+"%'");
        }
        if(Stringutil.isNotEmpty(input.getDelivery_man())) {

            sb.append(" and 送货员工 like '%"+input.getDelivery_man()+"%'");
        }
        if(input.getInput_id()!=0){

            sb.append(" and 入库单号 like '%"+input.getInput_id()+"%'");
        }

        PreparedStatement ps=con.prepareStatement(sb.toString().replaceFirst("and","where"));//替换and

        return ps.executeQuery();//返回结果集
    }
}


