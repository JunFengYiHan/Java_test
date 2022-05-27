package sql.warehouseSystem.mvc_mare.dao;



import sql.warehouseSystem.mvc_mare.model.Adm_ware_table;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ware_table_Dao {

   /* public static ResultSet list(Connection con, Adm_ware_table ware)throws Exception{
        StringBuffer sb=new StringBuffer("select * from 仓库表");

        if(ware.getID()!=0){
            sb.append("where 仓库号 like '%"+ware.getID()+"%'");
        }

        PreparedStatement ps=con.prepareStatement(sb.toString());

        return ps.executeQuery();
    }*/
    //入库时同步仓库商品数量
    public static int updata(Connection con, Adm_ware_table ware)throws Exception{

        String sql="update 仓库表 set 商品数量=? where 仓库号=?";

        PreparedStatement ps=con.prepareStatement(sql);

        ps.setInt(1,ware.getGoods_num());
        ps.setInt(2,ware.getID());

        return ps.executeUpdate();
    }


}

