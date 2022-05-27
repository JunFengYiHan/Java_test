package sql.warehouseSystem.mvc_mare.dao;



import sql.warehouseSystem.mvc_mare.model.AdmDebit_table;
import sql.warehouseSystem.mvc_mare.util.Stringutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AdmDebit_table_Dao {
    //查询借记表
    public static ResultSet list(Connection con, AdmDebit_table debit)throws Exception{
        StringBuffer sb=new StringBuffer("select * from 借记表 ");

        if(debit.getUser_id()!=0){
            sb.append("and 用户ID like '%"+debit.getUser_id()+"%'");
        }
        if(Stringutil.isNotEmpty(debit.getGoods_name())){

            sb.append(" and 商品名称 like '%"+debit.getGoods_name()+"%'");
        }
        if(Stringutil.isNotEmpty(debit.getDe_date())){
            sb.append(" and 借出日期 like '%"+debit.getDe_date()+"%'");
        }
        if(Stringutil.isNotEmpty(debit.getRe_date())){

            sb.append(" and 归还日期 like '%"+debit.getRe_date()+"%'");
        }
        if(Stringutil.isNotEmpty(debit.getDebit_man())){

            sb.append(" and 借出人姓名 like '%"+debit.getDebit_man()+"%'");
        }
        if(debit.getDebit_id()!=0){

            sb.append(" and 借记单号 like '%"+debit.getDebit_id()+"%'");
        }
        PreparedStatement ps=con.prepareStatement(sb.toString().replaceFirst("and","where"));

        return ps.executeQuery();
    }
}
