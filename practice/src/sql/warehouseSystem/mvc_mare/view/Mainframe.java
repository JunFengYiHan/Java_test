/*
 * Created by JFormDesigner on Tue May 17 11:33:54 CST 2022
 */

package sql.warehouseSystem.mvc_mare.view;



import sql.warehouseSystem.mvc_mare.dao.*;
import sql.warehouseSystem.mvc_mare.model.*;
import sql.warehouseSystem.mvc_mare.util.Conn;
import sql.warehouseSystem.mvc_mare.util.Stringutil;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;


public class Mainframe extends JFrame {
    public static void main(String[] args) {
        new Mainframe();
    }

    private int result;

    private Conn conn=new Conn();
    private Adm_input_ware input=new Adm_input_ware();
    private out_ware_table out=new out_ware_table();
    private AdmDebit_table debit=new AdmDebit_table();
    private Adm_ware_table ware=new Adm_ware_table();
    private Goods_table goods=new Goods_table();

    public Mainframe() {
        initComponents();
    }

    //入库查询表单写入
    private void input_filltable(Adm_input_ware input){

        DefaultTableModel dtm=(DefaultTableModel) table1.getModel();//通过bookType获得Model
        dtm.setRowCount(0);//清空表格
        Connection con=null;
        try {
            con=conn.getCon();
            ResultSet rs= input_ware_Dao.list(con,input);//结果集存放list方法返回值
            //遍历将数据写进图形界面
            while (rs.next()){
                //整行添加进入表格，用集合存储
                Vector v=new Vector();
                v.add(rs.getString("入库单号"));
                v.add(rs.getString("仓库号"));
//                v.add(rs.getString("商品号"));
                v.add(rs.getString("商品名称"));
                v.add(rs.getString("用户ID"));
                v.add(rs.getString("厂家"));
                v.add(rs.getString("日期"));
                v.add(rs.getString("数量"));
                v.add(rs.getString("送货员工"));

                dtm.addRow(v);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                conn.closeCon(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    //出库查询表单写入
    private void out_filltable(out_ware_table out){

        DefaultTableModel dtm=(DefaultTableModel) table2.getModel();//通过bookType获得Model
        dtm.setRowCount(0);//清空表格
        Connection con=null;
        try {
            con=conn.getCon();
            ResultSet rs= out_ware_table_Dao.list(con,out);//结果集存放list方法返回值
            //遍历将数据写进图形界面
            while (rs.next()){
                //整行添加进入表格，用集合存储
                Vector v=new Vector();
                v.add(rs.getString("出库单号"));
                v.add(rs.getString("仓库号"));
                v.add(rs.getString("商品号"));
                v.add(rs.getString("商品名称"));
                v.add(rs.getString("用户ID"));
                v.add(rs.getString("厂家"));
                v.add(rs.getString("日期"));
                v.add(rs.getString("数量"));
                v.add(rs.getString("提货人"));

                dtm.addRow(v);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                conn.closeCon(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    //借记查询表单写入
    private void debit_filltable(AdmDebit_table debit){

        DefaultTableModel dtm=(DefaultTableModel) table3.getModel();
        dtm.setRowCount(0);//清空表格
        Connection con=null;
        try {
            con=conn.getCon();
            ResultSet rs= AdmDebit_table_Dao.list(con,debit);//结果集存放list方法返回值
            //遍历将数据写进图形界面
            while (rs.next()){
                //整行添加进入表格，用集合存储
                Vector v=new Vector();
                v.add(rs.getString("借记单号"));
                v.add(rs.getString("仓库号"));
                v.add(rs.getString("商品号"));
                v.add(rs.getString("用户ID"));
                v.add(rs.getString("商品名称"));
                v.add(rs.getString("数量"));
                v.add(rs.getString("厂家"));
                v.add(rs.getString("借出日期"));
                v.add(rs.getString("归还日期"));
                v.add(rs.getString("借出人姓名"));

                dtm.addRow(v);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                conn.closeCon(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    
    private void menuItem1(ActionEvent e) {
        result=JOptionPane.showConfirmDialog(this,"您要确定退出系统码？");
        if(result==JOptionPane.OK_OPTION){
            System.exit(1);
        }
    }
    //出库查询重置按钮
    private void button4(ActionEvent e) {
        textField7.setText("");
        textField9.setText("");
        textField11.setText("");
        textField8.setText("");
        textField10.setText("");
        textField12.setText("");
    }
    private void button10(ActionEvent e) {
        textField28.setText("");
        textField29.setText("");
        textField30.setText("");
        textField31.setText("");
        textField32.setText("");
        textField33.setText("");
        textField34.setText("");
        textField35.setText("");
        textField36.setText("");
    }
    //入库重置事件处理
    private void button2(ActionEvent e) {
        textField1.setText("");
        textField3.setText("");
        textField5.setText("");
        textField2.setText("");
        textField4.setText("");
        textField6.setText("");

    }
    private void button8(ActionEvent e) {
        textField19.setText("");
        textField20.setText("");
        textField21.setText("");
        textField23.setText("");
        textField24.setText("");
        textField25.setText("");
        textField26.setText("");
        textField27.setText("");
    }
    //借记表重置
    private void button6(ActionEvent e) {
        textField13.setText("");
        textField15.setText("");
        textField16.setText("");
        textField17.setText("");
        textField18.setText("");
        textField14.setText("");
    }
    //入库表查询事件处理
    private void button1(ActionEvent e) {
        String input_id= textField5.getText();
        String user_id= textField1.getText();
        String Goods_name=textField2.getText();
        String factory=textField3.getText();
        String data=textField4.getText();
        String Delivery_man=textField6.getText();

        if(Stringutil.isEmpty(input_id)){
            input.setInput_id(0);
        }else
            input.setInput_id(Integer.valueOf(input_id));
        if(Stringutil.isEmpty(user_id)){
            input.setUser_id(0);
        }else
            input.setUser_id(Integer.valueOf(user_id));

        input.setGoods_name(Goods_name);
        input.setFactory(factory);
        input.setData(data);
        input.setDelivery_man(Delivery_man);

        input_filltable(input);

    }
    //出库查询事件
    private void button3(ActionEvent e) {
        String out_id=textField11.getText();
        String user_id=textField7.getText();
        String Goods_name=textField8.getText();
        String factory=textField9.getText();
        String date=textField10.getText();
        String consignee_man=textField12.getText();

        if(Stringutil.isEmpty(out_id)){
            out.setOut_id(0);
        }else
            out.setOut_id(Integer.valueOf(out_id));
        if(Stringutil.isEmpty(user_id)){
            out.setUser_id(0);
        }else
            out.setUser_id(Integer.valueOf(user_id));

        out.setGoods_name(Goods_name);
        out.setFactory(factory);
        out.setDate(date);
        out.setConsignee_man(consignee_man);

        out_filltable(out);
    }
    //借记表查询事件
    private void button5(ActionEvent e) {
      String debit_id=textField17.getText();
      String user_id=textField13.getText();
      String Goods_name=textField14.getText();
      String de_date=textField15.getText();
      String re_date=textField16.getText();
      String debit_man=textField18.getText();
      
      if(Stringutil.isEmpty(debit_id)){
          debit.setDebit_id(0);
      }else
          debit.setDebit_id(Integer.valueOf(debit_id));
      if(Stringutil.isEmpty(user_id))
          debit.setUser_id(0);
      else 
          debit.setUser_id(Integer.valueOf(user_id));
      debit.setGoods_name(Goods_name);
      debit.setDe_date(de_date);
      debit.setRe_date(re_date);
      debit.setDebit_man(debit_man);
      
      debit_filltable(debit);
    }
    
    //入库填写表单确认
    private void button7(ActionEvent e) {
        String input_id=textField19.getText();
        String user_id=textField21.getText();
        String Goods_name=textField23.getText();
        String factory=textField24.getText();
        String Goods_num=textField25.getText();
        String data=textField26.getText();
        String Delivery_man=textField27.getText();
        String ID=textField20.getText();
        

        if(Stringutil.isEmpty(input_id)){
            JOptionPane.showMessageDialog(null,"入库单号不能为空");
            return;
        }else{
            input.setInput_id(Integer.valueOf(input_id));
        }

        if(Stringutil.isEmpty(user_id)){
            JOptionPane.showMessageDialog(null,"用户不能为空");
            return;
        }else{
            input.setUser_id(Integer.valueOf(user_id));
        }
        if(Stringutil.isEmpty(ID)){
            JOptionPane.showMessageDialog(null,"仓库号不能为空");
            return;
        }else{
            input.setID(Integer.valueOf(ID));
        }

        if(Stringutil.isEmpty(Goods_num)){
            JOptionPane.showMessageDialog(null,"数量不能为空");
            return;
        }
        else
            input.setGoods_num(Integer.valueOf(Goods_num));


        input.setFactory(factory);
        input.setDelivery_man(Delivery_man);
        input.setGoods_name(Goods_name);
        input.setData(data);

        Connection con=null;
        Connection con1=null;
        Connection con2=null;
        Connection con3=null;
        Connection con4=null;

        //查询当前入库单用户是否存在，若不在则需提示联系管理员注册
        try {
            con3=conn.getCon();
            String sql ="select * from 用户表 where 用户ID=?";
            PreparedStatement ps=con3.prepareStatement(sql);
            ps.setInt(1,input.getUser_id());
            ResultSet rs=ps.executeQuery();

            if(rs.next()!=true){
                JOptionPane.showMessageDialog(null,"没有用户注册信息，请联系管理员注册！");
                textField19.setText("");
                textField20.setText("");
                textField21.setText("");
                textField23.setText("");
                textField24.setText("");
                textField25.setText("");
                textField26.setText("");
                textField27.setText("");
                return;
            }

        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            try {
                conn.closeCon(con3);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        try {
            con=conn.getCon();
            
            if(input_ware_Dao.input_ware(con,input)==1){
                JOptionPane.showMessageDialog(null,"添加成功");
                
                textField19.setText("");
                textField20.setText("");
                textField21.setText("");
                textField23.setText("");
                textField24.setText("");
                textField25.setText("");
                textField26.setText("");
                textField27.setText("");

                goods.setFactory(input.getFactory());
                goods.setGoods_name(input.getGoods_name());
                goods.setGoods_date(input.getData());
                goods.setGoods_num(input.getGoods_num());
                goods.setID(input.getID());

                //更新仓库表
                try{
                    /*
                    * 遇到的问题
                    * 1、java.sql.SQLException: Can not issue executeUpdate() or executeLargeUpdate() for SELECTs
                    * 数据库连接：一个数据库连接类只能执行一个sql语句
                    * executeQuery，一般执行SELECT语句，返回ResultSet
                    * executeUpdate，一般执行DELETE或UPDATE或INSERT语句（这些操作更新数据库，所以是update），返回int，被改变的语句的行数。
                    * execute，不确定是什么类型的SQL语句时可以用这个方法
                    * */
                    con1=conn.getCon();
                    con2=conn.getCon();
                    con4=conn.getCon();

                    String sql="select 存储容量,商品数量 from 仓库表 where 仓库号=?";

                    PreparedStatement ps=con1.prepareStatement(sql);
                    ps.setInt(1, input.getID());
                    ware.setID(input.getID());
                    //ps.executeQuery();

                    ResultSet rs=ps.executeQuery();
                    String num1=null;
                    String num2=null;
                    while(rs.next()){
                        num1=rs.getString("存储容量");
                        num2= rs.getString("商品数量");

                        ware.setGoods_num(input.getGoods_num()+Integer.valueOf(num2));
                        if(ware.getGoods_num()<Integer.valueOf(num1)){
                            if(ware_table_Dao.updata(con2,ware)==1&& Goods_table_Dao.input_goods(con4,goods)==1){
                                JOptionPane.showMessageDialog(null,"仓库已更新");
                            }

                        }else {
                            JOptionPane.showMessageDialog(null,"1>仓库容量不足");
                        }
                    }
                }catch (Exception e1){
                    e1.printStackTrace();
                }finally {
                    conn.closeCon(con1);
                    conn.closeCon(con2);
                    conn.closeCon(con4);
                }



            }else{
                JOptionPane.showMessageDialog(null,"1>添加失败");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"2>添加失败");
            ex.printStackTrace();
        }finally {
            try {
                conn.closeCon(con);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        panel1 = new JPanel();
        tabbedPane1 = new JTabbedPane();
        panel4 = new JPanel();
        tabbedPane3 = new JTabbedPane();
        panel10 = new JPanel();
        label32 = new JLabel();
        label33 = new JLabel();
        label34 = new JLabel();
        label35 = new JLabel();
        label36 = new JLabel();
        label37 = new JLabel();
        label38 = new JLabel();
        label39 = new JLabel();
        label40 = new JLabel();
        button9 = new JButton();
        button10 = new JButton();
        textField28 = new JTextField();
        textField29 = new JTextField();
        textField30 = new JTextField();
        textField31 = new JTextField();
        textField32 = new JTextField();
        textField33 = new JTextField();
        textField34 = new JTextField();
        textField35 = new JTextField();
        textField36 = new JTextField();
        panel24 = new JPanel();
        panel25 = new JPanel();
        label9 = new JLabel();
        label10 = new JLabel();
        textField7 = new JTextField();
        textField8 = new JTextField();
        label11 = new JLabel();
        label12 = new JLabel();
        textField9 = new JTextField();
        textField10 = new JTextField();
        label13 = new JLabel();
        label14 = new JLabel();
        textField11 = new JTextField();
        textField12 = new JTextField();
        button3 = new JButton();
        button4 = new JButton();
        label15 = new JLabel();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        panel5 = new JPanel();
        tabbedPane2 = new JTabbedPane();
        panel7 = new JPanel();
        panel23 = new JPanel();
        label3 = new JLabel();
        label4 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        label5 = new JLabel();
        label6 = new JLabel();
        textField3 = new JTextField();
        textField4 = new JTextField();
        label7 = new JLabel();
        label8 = new JLabel();
        textField5 = new JTextField();
        textField6 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel8 = new JPanel();
        label23 = new JLabel();
        label24 = new JLabel();
        label25 = new JLabel();
        label26 = new JLabel();
        label27 = new JLabel();
        label28 = new JLabel();
        label29 = new JLabel();
        label31 = new JLabel();
        button7 = new JButton();
        button8 = new JButton();
        textField19 = new JTextField();
        textField20 = new JTextField();
        textField21 = new JTextField();
        textField23 = new JTextField();
        textField24 = new JTextField();
        textField25 = new JTextField();
        textField26 = new JTextField();
        textField27 = new JTextField();
        panel6 = new JPanel();
        tabbedPane4 = new JTabbedPane();
        panel11 = new JPanel();
        panel26 = new JPanel();
        label16 = new JLabel();
        label17 = new JLabel();
        textField13 = new JTextField();
        textField14 = new JTextField();
        label18 = new JLabel();
        label19 = new JLabel();
        textField15 = new JTextField();
        textField16 = new JTextField();
        label20 = new JLabel();
        label21 = new JLabel();
        textField17 = new JTextField();
        textField18 = new JTextField();
        button5 = new JButton();
        button6 = new JButton();
        label22 = new JLabel();
        scrollPane3 = new JScrollPane();
        table3 = new JTable();
        panel9 = new JPanel();

        //======== this ========
        setVisible(true);
        setTitle("\u4ed3\u5e93\u7ba1\u7406\u7cfb\u7edf");
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout());

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u7f16\u8f91");

                //---- menuItem1 ----
                menuItem1.setText("\u9000\u51fa");
                menuItem1.addActionListener(e -> menuItem1(e));
                menu1.add(menuItem1);
            }
            menuBar1.add(menu1);
        }
        setJMenuBar(menuBar1);

        //======== panel1 ========
        {
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing.
            border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e" , javax. swing .border . TitledBorder. CENTER
            ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069al\u006fg", java .awt . Font
            . BOLD ,12 ) ,java . awt. Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener(
            new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062or\u0064er"
            .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
            panel1.setLayout(new GridLayout());

            //======== tabbedPane1 ========
            {

                //======== panel4 ========
                {
                    panel4.setLayout(new GridLayout());

                    //======== tabbedPane3 ========
                    {

                        //======== panel10 ========
                        {

                            //---- label32 ----
                            label32.setText("\u51fa\u5e93\u5355\u53f7\uff1a");

                            //---- label33 ----
                            label33.setText("\u7528\u6237\uff1a");

                            //---- label34 ----
                            label34.setText("\u5546\u54c1\u540d\u79f0\uff1a");

                            //---- label35 ----
                            label35.setText("\u5382\u5bb6\uff1a");

                            //---- label36 ----
                            label36.setText("\u6570\u91cf\uff1a");

                            //---- label37 ----
                            label37.setText("\u65e5\u671f\uff1a");

                            //---- label38 ----
                            label38.setText("\u63d0\u8d27\u5458\u5de5\uff1a");

                            //---- label39 ----
                            label39.setText("\u5546\u54c1\u53f7\uff1a");

                            //---- label40 ----
                            label40.setText("\u4ed3\u5e93\u53f7\uff1a");

                            //---- button9 ----
                            button9.setText("\u786e\u8ba4");
                            button9.setFont(button9.getFont().deriveFont(button9.getFont().getStyle() | Font.BOLD, button9.getFont().getSize() + 6f));

                            //---- button10 ----
                            button10.setText("\u91cd\u7f6e");
                            button10.setFont(button10.getFont().deriveFont(button10.getFont().getStyle() | Font.BOLD, button10.getFont().getSize() + 6f));
                            button10.addActionListener(e -> button10(e));

                            GroupLayout panel10Layout = new GroupLayout(panel10);
                            panel10.setLayout(panel10Layout);
                            panel10Layout.setHorizontalGroup(
                                panel10Layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel10Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addGroup(panel10Layout.createParallelGroup()
                                            .addGroup(panel10Layout.createSequentialGroup()
                                                .addGroup(panel10Layout.createParallelGroup()
                                                    .addGroup(panel10Layout.createSequentialGroup()
                                                        .addComponent(label39, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(textField31, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(panel10Layout.createSequentialGroup()
                                                        .addComponent(label36, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(textField34, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(26, 26, 26)
                                                .addGroup(panel10Layout.createParallelGroup()
                                                    .addGroup(panel10Layout.createSequentialGroup()
                                                        .addComponent(label34, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(panel10Layout.createParallelGroup()
                                                            .addComponent(textField29, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(textField32, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(panel10Layout.createSequentialGroup()
                                                        .addGap(6, 6, 6)
                                                        .addComponent(label37)
                                                        .addGap(39, 39, 39)
                                                        .addComponent(textField35, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(31, 31, 31)
                                                        .addComponent(label38, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(textField36, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(panel10Layout.createSequentialGroup()
                                                .addComponent(label32, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textField28, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                                .addGap(32, 32, 32)
                                                .addComponent(label40, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                .addGap(149, 149, 149)
                                                .addGroup(panel10Layout.createParallelGroup()
                                                    .addGroup(panel10Layout.createSequentialGroup()
                                                        .addComponent(label35, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(textField33, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(panel10Layout.createSequentialGroup()
                                                        .addComponent(label33, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(textField30, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(panel10Layout.createSequentialGroup()
                                                .addGap(102, 102, 102)
                                                .addComponent(button9, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                                                .addGap(135, 135, 135)
                                                .addComponent(button10, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 123, Short.MAX_VALUE))
                            );
                            panel10Layout.setVerticalGroup(
                                panel10Layout.createParallelGroup()
                                    .addGroup(panel10Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(panel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label32, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label33, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textField30, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textField28, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label40, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textField29, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panel10Layout.createParallelGroup()
                                            .addGroup(panel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label39, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField31, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label34, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField32, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(GroupLayout.Alignment.TRAILING, panel10Layout.createParallelGroup()
                                                .addComponent(textField33, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label35, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panel10Layout.createParallelGroup()
                                            .addGroup(panel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label36, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField34, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label37, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField35, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label38, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField36, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(panel10Layout.createParallelGroup()
                                            .addGroup(panel10Layout.createSequentialGroup()
                                                .addGap(78, 78, 78)
                                                .addComponent(button10, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panel10Layout.createSequentialGroup()
                                                .addGap(87, 87, 87)
                                                .addComponent(button9, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)))
                                        .addContainerGap(236, Short.MAX_VALUE))
                            );
                        }
                        tabbedPane3.addTab("\u586b\u5199\u51fa\u5e93\u8868", panel10);

                        //======== panel24 ========
                        {

                            //======== panel25 ========
                            {

                                //---- label9 ----
                                label9.setText("\u7528\u6237ID\uff1a");
                                label9.setFont(label9.getFont().deriveFont(label9.getFont().getStyle() | Font.BOLD));

                                //---- label10 ----
                                label10.setText("\u5546\u54c1\u540d\u79f0\uff1a");
                                label10.setFont(label10.getFont().deriveFont(label10.getFont().getStyle() | Font.BOLD));

                                //---- label11 ----
                                label11.setText("\u5382\u5bb6\uff1a");
                                label11.setFont(label11.getFont().deriveFont(label11.getFont().getStyle() | Font.BOLD));

                                //---- label12 ----
                                label12.setText("\u51fa\u5e93\u65e5\u671f\uff1a");
                                label12.setFont(label12.getFont().deriveFont(label12.getFont().getStyle() | Font.BOLD));

                                //---- label13 ----
                                label13.setText("\u51fa\u5e93\u5355\u53f7\uff1a");
                                label13.setFont(label13.getFont().deriveFont(label13.getFont().getStyle() | Font.BOLD));

                                //---- label14 ----
                                label14.setText("\u63d0\u8d27\u5458\u5de5\uff1a");
                                label14.setFont(label14.getFont().deriveFont(label14.getFont().getStyle() | Font.BOLD));

                                //---- button3 ----
                                button3.setText("\u67e5\u8be2");
                                button3.setFont(button3.getFont().deriveFont(button3.getFont().getStyle() | Font.BOLD, button3.getFont().getSize() + 1f));
                                button3.addActionListener(e -> button3(e));

                                //---- button4 ----
                                button4.setText("\u91cd\u7f6e");
                                button4.setFont(button4.getFont().deriveFont(button4.getFont().getStyle() | Font.BOLD, button4.getFont().getSize() + 1f));
                                button4.addActionListener(e -> button4(e));

                                GroupLayout panel25Layout = new GroupLayout(panel25);
                                panel25.setLayout(panel25Layout);
                                panel25Layout.setHorizontalGroup(
                                    panel25Layout.createParallelGroup()
                                        .addGroup(panel25Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(panel25Layout.createParallelGroup()
                                                .addComponent(label9, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label10, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(panel25Layout.createParallelGroup()
                                                .addComponent(textField8, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField7, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
                                            .addGap(27, 27, 27)
                                            .addGroup(panel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(label12, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                                .addComponent(label11, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(textField10, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                                .addComponent(textField9, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                                            .addGap(29, 29, 29)
                                            .addGroup(panel25Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(label13, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label14, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(panel25Layout.createParallelGroup()
                                                .addComponent(textField11, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField12, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
                                            .addGap(26, 26, 26)
                                            .addGroup(panel25Layout.createParallelGroup()
                                                .addComponent(button4)
                                                .addComponent(button3))
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                );
                                panel25Layout.setVerticalGroup(
                                    panel25Layout.createParallelGroup()
                                        .addGroup(panel25Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(panel25Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label9, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label13, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button3)
                                                .addComponent(label11, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panel25Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(textField10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(label14, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button4)
                                                .addComponent(label12))
                                            .addContainerGap())
                                );
                            }

                            //---- label15 ----
                            label15.setText("\u8bf7\u5728\u4ee5\u4e0b\u67e5\u8be2\u6846\u5185\u8f93\u5165\u60a8\u8981\u67e5\u8be2\u7684\u4fe1\u606f\uff1a");
                            label15.setFont(label15.getFont().deriveFont(label15.getFont().getStyle() | Font.BOLD, label15.getFont().getSize() + 6f));

                            //======== scrollPane2 ========
                            {

                                //---- table2 ----
                                table2.setModel(new DefaultTableModel(
                                    new Object[][] {
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, "", null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                    },
                                    new String[] {
                                        "\u51fa\u5e93\u5355\u53f7", "\u4ed3\u5e93\u53f7", "\u5546\u54c1\u53f7", "\u5546\u54c1\u540d\u79f0", "\u7528\u6237", "\u5382\u5bb6", "\u65e5\u671f", "\u6570\u91cf", "\u63d0\u8d27\u5458\u5de5"
                                    }
                                ));
                                {
                                    TableColumnModel cm = table2.getColumnModel();
                                    cm.getColumn(1).setPreferredWidth(30);
                                    cm.getColumn(2).setPreferredWidth(30);
                                    cm.getColumn(7).setPreferredWidth(30);
                                }
                                scrollPane2.setViewportView(table2);
                            }

                            GroupLayout panel24Layout = new GroupLayout(panel24);
                            panel24.setLayout(panel24Layout);
                            panel24Layout.setHorizontalGroup(
                                panel24Layout.createParallelGroup()
                                    .addGroup(panel24Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(label15, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(377, Short.MAX_VALUE))
                                    .addComponent(panel25, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(scrollPane2)
                            );
                            panel24Layout.setVerticalGroup(
                                panel24Layout.createParallelGroup()
                                    .addGroup(panel24Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(label15, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(panel25, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE))
                            );
                        }
                        tabbedPane3.addTab("\u67e5\u8be2\u51fa\u5e93\u8868", panel24);
                    }
                    panel4.add(tabbedPane3);
                }
                tabbedPane1.addTab("\u51fa\u5e93\u7ba1\u7406", UIManager.getIcon("FileChooser.listViewIcon"), panel4);

                //======== panel5 ========
                {
                    panel5.setLayout(new GridLayout());

                    //======== tabbedPane2 ========
                    {

                        //======== panel7 ========
                        {

                            //======== panel23 ========
                            {

                                //---- label3 ----
                                label3.setText("\u7528\u6237ID\uff1a");
                                label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD));

                                //---- label4 ----
                                label4.setText("\u5546\u54c1\u540d\u79f0\uff1a");
                                label4.setFont(label4.getFont().deriveFont(label4.getFont().getStyle() | Font.BOLD));

                                //---- label5 ----
                                label5.setText("\u5382\u5bb6\uff1a");
                                label5.setFont(label5.getFont().deriveFont(label5.getFont().getStyle() | Font.BOLD));

                                //---- label6 ----
                                label6.setText("\u5165\u5e93\u65e5\u671f\uff1a");
                                label6.setFont(label6.getFont().deriveFont(label6.getFont().getStyle() | Font.BOLD));

                                //---- label7 ----
                                label7.setText("\u5165\u5e93\u5355\u53f7\uff1a");
                                label7.setFont(label7.getFont().deriveFont(label7.getFont().getStyle() | Font.BOLD));

                                //---- label8 ----
                                label8.setText("\u9001\u8d27\u5458\u5de5\uff1a");
                                label8.setFont(label8.getFont().deriveFont(label8.getFont().getStyle() | Font.BOLD));

                                //---- button1 ----
                                button1.setText("\u67e5\u8be2");
                                button1.setFont(button1.getFont().deriveFont(button1.getFont().getStyle() | Font.BOLD, button1.getFont().getSize() + 1f));
                                button1.addActionListener(e -> button1(e));

                                //---- button2 ----
                                button2.setText("\u91cd\u7f6e");
                                button2.setFont(button2.getFont().deriveFont(button2.getFont().getStyle() | Font.BOLD, button2.getFont().getSize() + 1f));
                                button2.addActionListener(e -> button2(e));

                                GroupLayout panel23Layout = new GroupLayout(panel23);
                                panel23.setLayout(panel23Layout);
                                panel23Layout.setHorizontalGroup(
                                    panel23Layout.createParallelGroup()
                                        .addGroup(panel23Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(panel23Layout.createParallelGroup()
                                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panel23Layout.createParallelGroup()
                                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
                                            .addGap(15, 15, 15)
                                            .addGroup(panel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addGroup(panel23Layout.createSequentialGroup()
                                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(panel23Layout.createSequentialGroup()
                                                    .addGap(14, 14, 14)
                                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)))
                                            .addGap(58, 58, 58)
                                            .addGroup(panel23Layout.createParallelGroup()
                                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label8, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
                                            .addGap(29, 29, 29)
                                            .addGroup(panel23Layout.createParallelGroup()
                                                .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField6, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
                                            .addGap(49, 49, 49)
                                            .addGroup(panel23Layout.createParallelGroup()
                                                .addComponent(button1)
                                                .addComponent(button2))
                                            .addGap(39, 39, 39))
                                );
                                panel23Layout.setVerticalGroup(
                                    panel23Layout.createParallelGroup()
                                        .addGroup(panel23Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(panel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button1)
                                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panel23Layout.createParallelGroup()
                                                .addGroup(panel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(label4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(label6)
                                                    .addComponent(button2)
                                                    .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(panel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(label8, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                            .addContainerGap())
                                );
                            }

                            //---- label2 ----
                            label2.setText("\u8bf7\u5728\u4ee5\u4e0b\u67e5\u8be2\u6846\u5185\u8f93\u5165\u60a8\u8981\u67e5\u8be2\u7684\u4fe1\u606f\uff1a");
                            label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 6f));

                            //======== scrollPane1 ========
                            {

                                //---- table1 ----
                                table1.setModel(new DefaultTableModel(
                                    new Object[][] {
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, "", null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                                    },
                                    new String[] {
                                        "\u5165\u5e93\u5355\u53f7", "\u4ed3\u5e93\u53f7", "\u5546\u54c1\u540d\u79f0", "\u7528\u6237", "\u5382\u5bb6", "\u65e5\u671f", "\u6570\u91cf", "\u9001\u8d27\u5458\u5de5"
                                    }
                                ));
                                {
                                    TableColumnModel cm = table1.getColumnModel();
                                    cm.getColumn(1).setPreferredWidth(30);
                                    cm.getColumn(6).setPreferredWidth(30);
                                }
                                scrollPane1.setViewportView(table1);
                            }

                            GroupLayout panel7Layout = new GroupLayout(panel7);
                            panel7.setLayout(panel7Layout);
                            panel7Layout.setHorizontalGroup(
                                panel7Layout.createParallelGroup()
                                    .addGroup(panel7Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(377, Short.MAX_VALUE))
                                    .addComponent(panel23, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
                            );
                            panel7Layout.setVerticalGroup(
                                panel7Layout.createParallelGroup()
                                    .addGroup(panel7Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(panel23, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE))
                            );
                        }
                        tabbedPane2.addTab("\u67e5\u8be2\u5165\u5e93\u8868", panel7);

                        //======== panel8 ========
                        {

                            //---- label23 ----
                            label23.setText("\u5165\u5e93\u5355\u53f7\uff1a");

                            //---- label24 ----
                            label24.setText("\u7528\u6237\uff1a");

                            //---- label25 ----
                            label25.setText("\u5546\u54c1\u540d\u79f0\uff1a");

                            //---- label26 ----
                            label26.setText("\u5382\u5bb6\uff1a");

                            //---- label27 ----
                            label27.setText("\u6570\u91cf\uff1a");

                            //---- label28 ----
                            label28.setText("\u65e5\u671f\uff1a");

                            //---- label29 ----
                            label29.setText("\u9001\u8d27\u5458\u5de5\uff1a");

                            //---- label31 ----
                            label31.setText("\u4ed3\u5e93\u53f7\uff1a");

                            //---- button7 ----
                            button7.setText("\u786e\u8ba4");
                            button7.setFont(button7.getFont().deriveFont(button7.getFont().getStyle() | Font.BOLD, button7.getFont().getSize() + 6f));
                            button7.addActionListener(e -> button7(e));

                            //---- button8 ----
                            button8.setText("\u91cd\u7f6e");
                            button8.setFont(button8.getFont().deriveFont(button8.getFont().getStyle() | Font.BOLD, button8.getFont().getSize() + 6f));
                            button8.addActionListener(e -> button8(e));

                            GroupLayout panel8Layout = new GroupLayout(panel8);
                            panel8.setLayout(panel8Layout);
                            panel8Layout.setHorizontalGroup(
                                panel8Layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel8Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(panel8Layout.createParallelGroup()
                                            .addGroup(panel8Layout.createSequentialGroup()
                                                .addGroup(panel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                    .addComponent(label28, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(panel8Layout.createSequentialGroup()
                                                        .addComponent(label25, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(4, 4, 4)))
                                                .addGroup(panel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(panel8Layout.createSequentialGroup()
                                                        .addGap(17, 17, 17)
                                                        .addComponent(button7, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(133, 133, 133)
                                                        .addComponent(button8, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(GroupLayout.Alignment.TRAILING, panel8Layout.createSequentialGroup()
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(panel8Layout.createParallelGroup()
                                                            .addComponent(textField26, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(textField23, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
                                                        .addGap(363, 363, 363))))
                                            .addGroup(panel8Layout.createSequentialGroup()
                                                .addComponent(label23, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(textField19, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                                .addGap(24, 24, 24)
                                                .addGroup(panel8Layout.createParallelGroup()
                                                    .addGroup(panel8Layout.createSequentialGroup()
                                                        .addGroup(panel8Layout.createParallelGroup()
                                                            .addGroup(panel8Layout.createSequentialGroup()
                                                                .addComponent(label31, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(textField20, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(panel8Layout.createSequentialGroup()
                                                                .addComponent(label26, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(textField24, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
                                                        .addGap(37, 37, 37)
                                                        .addGroup(panel8Layout.createParallelGroup()
                                                            .addGroup(panel8Layout.createSequentialGroup()
                                                                .addComponent(label24, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(textField21, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(panel8Layout.createSequentialGroup()
                                                                .addComponent(label27, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(textField25, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))))
                                                    .addGroup(panel8Layout.createSequentialGroup()
                                                        .addComponent(label29, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(textField27, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))))
                                        .addContainerGap(144, Short.MAX_VALUE))
                            );
                            panel8Layout.setVerticalGroup(
                                panel8Layout.createParallelGroup()
                                    .addGroup(panel8Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(panel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label23, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label31, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textField20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label24, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textField21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textField19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panel8Layout.createParallelGroup()
                                            .addGroup(panel8Layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addGroup(panel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(label26, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(label25, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(textField23, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(panel8Layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(textField24, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(label27, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(textField25, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                        .addGap(6, 6, 6)
                                        .addGroup(panel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label28, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label29, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textField27, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textField26, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                                        .addGap(49, 49, 49)
                                        .addGroup(panel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(button8, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(button7, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(296, Short.MAX_VALUE))
                            );
                        }
                        tabbedPane2.addTab("\u586b\u5199\u5165\u5e93\u8868", panel8);
                    }
                    panel5.add(tabbedPane2);
                }
                tabbedPane1.addTab("\u5165\u5e93\u7ba1\u7406", UIManager.getIcon("FileChooser.listViewIcon"), panel5);

                //======== panel6 ========
                {
                    panel6.setLayout(new GridLayout());

                    //======== tabbedPane4 ========
                    {

                        //======== panel11 ========
                        {

                            //======== panel26 ========
                            {

                                //---- label16 ----
                                label16.setText("\u7528\u6237ID\uff1a");
                                label16.setFont(label16.getFont().deriveFont(label16.getFont().getStyle() | Font.BOLD));

                                //---- label17 ----
                                label17.setText("\u5546\u54c1\u540d\u79f0\uff1a");
                                label17.setFont(label17.getFont().deriveFont(label17.getFont().getStyle() | Font.BOLD));

                                //---- label18 ----
                                label18.setText("\u501f\u51fa\u65e5\u671f\uff1a");
                                label18.setFont(label18.getFont().deriveFont(label18.getFont().getStyle() | Font.BOLD));

                                //---- label19 ----
                                label19.setText("\u5f52\u8fd8\u65e5\u671f\uff1a");
                                label19.setFont(label19.getFont().deriveFont(label19.getFont().getStyle() | Font.BOLD));

                                //---- label20 ----
                                label20.setText("\u501f\u8bb0\u5355\u53f7\uff1a");
                                label20.setFont(label20.getFont().deriveFont(label20.getFont().getStyle() | Font.BOLD));

                                //---- label21 ----
                                label21.setText("\u501f\u51fa\u4eba\uff1a");
                                label21.setFont(label21.getFont().deriveFont(label21.getFont().getStyle() | Font.BOLD));

                                //---- button5 ----
                                button5.setText("\u67e5\u8be2");
                                button5.setFont(button5.getFont().deriveFont(button5.getFont().getStyle() | Font.BOLD, button5.getFont().getSize() + 1f));
                                button5.addActionListener(e -> {
			button1(e);
			button5(e);
		});

                                //---- button6 ----
                                button6.setText("\u91cd\u7f6e");
                                button6.setFont(button6.getFont().deriveFont(button6.getFont().getStyle() | Font.BOLD, button6.getFont().getSize() + 1f));
                                button6.addActionListener(e -> {
			button2(e);
			button6(e);
		});

                                GroupLayout panel26Layout = new GroupLayout(panel26);
                                panel26.setLayout(panel26Layout);
                                panel26Layout.setHorizontalGroup(
                                    panel26Layout.createParallelGroup()
                                        .addGroup(panel26Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(panel26Layout.createParallelGroup()
                                                .addComponent(label16, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label17, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(panel26Layout.createParallelGroup()
                                                .addComponent(textField13, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField14, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(panel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(label18, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                                .addComponent(label19, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(textField16, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                                .addComponent(textField15, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                                            .addGap(29, 29, 29)
                                            .addGroup(panel26Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(label20, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label21, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(panel26Layout.createParallelGroup()
                                                .addComponent(textField17, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField18, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
                                            .addGap(26, 26, 26)
                                            .addGroup(panel26Layout.createParallelGroup()
                                                .addComponent(button6)
                                                .addComponent(button5))
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                );
                                panel26Layout.setVerticalGroup(
                                    panel26Layout.createParallelGroup()
                                        .addGroup(panel26Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(panel26Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label16, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label20, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button5)
                                                .addComponent(label18, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panel26Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(textField16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label17, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(label21, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button6)
                                                .addComponent(label19)
                                                .addComponent(textField14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addContainerGap())
                                );
                            }

                            //---- label22 ----
                            label22.setText("\u8bf7\u5728\u4ee5\u4e0b\u67e5\u8be2\u6846\u5185\u8f93\u5165\u60a8\u8981\u67e5\u8be2\u7684\u4fe1\u606f\uff1a");
                            label22.setFont(label22.getFont().deriveFont(label22.getFont().getStyle() | Font.BOLD, label22.getFont().getSize() + 6f));

                            //======== scrollPane3 ========
                            {

                                //---- table3 ----
                                table3.setModel(new DefaultTableModel(
                                    new Object[][] {
                                        {null, null, null, null, null, null, null, "", "", null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, "", null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                    },
                                    new String[] {
                                        "\u501f\u8bb0\u5355\u53f7", "\u4ed3\u5e93\u53f7", "\u5546\u54c1\u53f7", "\u7528\u6237", "\u5546\u54c1\u540d\u79f0", "\u6570\u91cf", "\u5382\u5bb6", "\u501f\u51fa\u65e5\u671f", "\u5f52\u8fd8\u65e5\u671f", "\u501f\u8bb0\u4eba"
                                    }
                                ));
                                {
                                    TableColumnModel cm = table3.getColumnModel();
                                    cm.getColumn(1).setPreferredWidth(30);
                                    cm.getColumn(2).setPreferredWidth(30);
                                    cm.getColumn(5).setPreferredWidth(30);
                                }
                                scrollPane3.setViewportView(table3);
                            }

                            GroupLayout panel11Layout = new GroupLayout(panel11);
                            panel11.setLayout(panel11Layout);
                            panel11Layout.setHorizontalGroup(
                                panel11Layout.createParallelGroup()
                                    .addGroup(panel11Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(label22, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(377, Short.MAX_VALUE))
                                    .addComponent(panel26, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(scrollPane3)
                            );
                            panel11Layout.setVerticalGroup(
                                panel11Layout.createParallelGroup()
                                    .addGroup(panel11Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(label22, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(panel26, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE))
                            );
                        }
                        tabbedPane4.addTab("\u67e5\u8be2\u501f\u8bb0\u8868", panel11);

                        //======== panel9 ========
                        {

                            GroupLayout panel9Layout = new GroupLayout(panel9);
                            panel9.setLayout(panel9Layout);
                            panel9Layout.setHorizontalGroup(
                                panel9Layout.createParallelGroup()
                                    .addGap(0, 743, Short.MAX_VALUE)
                            );
                            panel9Layout.setVerticalGroup(
                                panel9Layout.createParallelGroup()
                                    .addGap(0, 514, Short.MAX_VALUE)
                            );
                        }
                        tabbedPane4.addTab("\u586b\u5199\u501f\u8bb0\u8868\u5355", panel9);
                    }
                    panel6.add(tabbedPane4);
                }
                tabbedPane1.addTab("\u501f\u51fa\u7ba1\u7406", UIManager.getIcon("FileChooser.listViewIcon"), panel6);
            }
            panel1.add(tabbedPane1);
        }
        contentPane.add(panel1);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JPanel panel4;
    private JTabbedPane tabbedPane3;
    private JPanel panel10;
    private JLabel label32;
    private JLabel label33;
    private JLabel label34;
    private JLabel label35;
    private JLabel label36;
    private JLabel label37;
    private JLabel label38;
    private JLabel label39;
    private JLabel label40;
    private JButton button9;
    private JButton button10;
    private JTextField textField28;
    private JTextField textField29;
    private JTextField textField30;
    private JTextField textField31;
    private JTextField textField32;
    private JTextField textField33;
    private JTextField textField34;
    private JTextField textField35;
    private JTextField textField36;
    private JPanel panel24;
    private JPanel panel25;
    private JLabel label9;
    private JLabel label10;
    private JTextField textField7;
    private JTextField textField8;
    private JLabel label11;
    private JLabel label12;
    private JTextField textField9;
    private JTextField textField10;
    private JLabel label13;
    private JLabel label14;
    private JTextField textField11;
    private JTextField textField12;
    private JButton button3;
    private JButton button4;
    private JLabel label15;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JPanel panel5;
    private JTabbedPane tabbedPane2;
    private JPanel panel7;
    private JPanel panel23;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label5;
    private JLabel label6;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel label7;
    private JLabel label8;
    private JTextField textField5;
    private JTextField textField6;
    private JButton button1;
    private JButton button2;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel8;
    private JLabel label23;
    private JLabel label24;
    private JLabel label25;
    private JLabel label26;
    private JLabel label27;
    private JLabel label28;
    private JLabel label29;
    private JLabel label31;
    private JButton button7;
    private JButton button8;
    private JTextField textField19;
    private JTextField textField20;
    private JTextField textField21;
    private JTextField textField23;
    private JTextField textField24;
    private JTextField textField25;
    private JTextField textField26;
    private JTextField textField27;
    private JPanel panel6;
    private JTabbedPane tabbedPane4;
    private JPanel panel11;
    private JPanel panel26;
    private JLabel label16;
    private JLabel label17;
    private JTextField textField13;
    private JTextField textField14;
    private JLabel label18;
    private JLabel label19;
    private JTextField textField15;
    private JTextField textField16;
    private JLabel label20;
    private JLabel label21;
    private JTextField textField17;
    private JTextField textField18;
    private JButton button5;
    private JButton button6;
    private JLabel label22;
    private JScrollPane scrollPane3;
    private JTable table3;
    private JPanel panel9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
