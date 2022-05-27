package sql.warehouseSystem.mvc_mare.dao;



import sql.warehouseSystem.mvc_mare.model.Goods_table;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class Goods_table_Dao {

    public static int input_goods(Connection conn, Goods_table goods)throws Exception{

        String sql="insert into 商品表 values(null,?,?,?,?,?)";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1,goods.getID());
        ps.setString(2,goods.getGoods_name());
        ps.setString(3,goods.getFactory());
        ps.setInt(4,goods.getGoods_num());
        ps.setString(5,goods.getGoods_date());

        return ps.executeUpdate();
    }
}
