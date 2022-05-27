package sql.warehouseSystem.mvc_mare.dao;



import sql.warehouseSystem.mvc_mare.model.out_ware_table;
import sql.warehouseSystem.mvc_mare.util.Stringutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class out_ware_table_Dao {
    //查询出库表记录

    public static ResultSet list(Connection con, out_ware_table out)throws Exception{

        StringBuffer sb=new StringBuffer("select * from 出库表 ");

        if(Stringutil.isNotEmpty(out.getGoods_name())){

            sb.append(" and 商品名称 like '%"+out.getGoods_name()+"%'");
        }
        if(out.getUser_id()!=0){
            sb.append("and 用户ID like '%"+out.getUser_id()+"%'");
        }
        if(Stringutil.isNotEmpty(out.getFactory())){
            sb.append("and 厂家 like '%"+out.getFactory()+"%'");
        }
        if(Stringutil.isNotEmpty(String.valueOf(out.getDate()))){
            sb.append("and 日期 like '%"+out.getDate()+"%'");
        }
        if(Stringutil.isNotEmpty(out.getConsignee_man())) {

            sb.append(" and 提货员工 like '%"+out.getConsignee_man()+"%'");
        }
        if(out.getOut_id()!=0){

            sb.append(" and 出库单号 like '%"+out.getOut_id()+"%'");
        }

        PreparedStatement ps=con.prepareStatement(sb.toString().replaceFirst("and","where"));//替换and

        return ps.executeQuery();//返回结果集
    }
}
