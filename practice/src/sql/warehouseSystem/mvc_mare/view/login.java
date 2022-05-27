/*
 * Created by JFormDesigner on Mon May 16 01:20:22 CST 2022
 */

package sql.warehouseSystem.mvc_mare.view;


import sql.warehouseSystem.mvc_mare.dao.AdmUser_Dao;
import sql.warehouseSystem.mvc_mare.model.AdmUser;
import sql.warehouseSystem.mvc_mare.util.Conn;
import sql.warehouseSystem.mvc_mare.util.Stringutil;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class login {


    public static void main (String[] args){
        new login();
    }
    public Conn conn=new Conn();

    private void 重置(ActionEvent e) {
        username.setText("");
        password.setText("");
    }

    private void 登录(ActionEvent e) {
        String userName=username.getText();
        String Password=new String(password.getPassword());
        if(Stringutil.isEmpty(userName)){
            JOptionPane.showMessageDialog(登录,"用户名不能为空!");
            return ;
        }
        if(Stringutil.isEmpty(Password)){
            JOptionPane.showMessageDialog(登录,"密码不能为空!");
            return ;
        }

        AdmUser user=new AdmUser();

        user.setAdministrstords_name(userName);
        user.setAdministrstords_password(Password);

        Connection c=null;
        try {
            c=conn.getCon();
            AdmUser result= AdmUser_Dao.check(c,user);
            if(result!=null){
                JOptionPane.showMessageDialog(null,"登录成功！");
                login.dispose();

                new Mainframe();
            }else{
                JOptionPane.showMessageDialog(null,"用户名没有注册或者密码错误！");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                conn.closeCon(c);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public login() {
        initComponents();
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        login = new JFrame();
        登录 = new JButton();
        重置 = new JButton();
        username = new JTextField();
        password = new JPasswordField();
        用户名 = new JLabel();
        密码 = new JLabel();

        //======== login ========
        {
            login.setTitle("\u767b\u5f55");
            login.setVisible(true);
            //var loginContentPane = login.getContentPane();
            Container loginContentPane = login.getContentPane();

            //---- 登录 ----
            登录.setText("\u767b\u5f55");
            登录.addActionListener(e -> 登录(e));

            //---- 重置 ----
            重置.setText("\u91cd\u7f6e");
            重置.addActionListener(e -> 重置(e));

            //---- 用户名 ----
            用户名.setText("\u7528\u6237\u540d\uff1a");
            用户名.setFont(用户名.getFont().deriveFont(用户名.getFont().getSize() + 2f));
            用户名.setHorizontalAlignment(SwingConstants.LEFT);

            //---- 密码 ----
            密码.setText("\u5bc6\u7801\uff1a");
            密码.setFont(密码.getFont().deriveFont(密码.getFont().getSize() + 2f));
            密码.setHorizontalAlignment(SwingConstants.LEFT);

            GroupLayout loginContentPaneLayout = new GroupLayout(loginContentPane);
            loginContentPane.setLayout(loginContentPaneLayout);
            loginContentPaneLayout.setHorizontalGroup(
                loginContentPaneLayout.createParallelGroup()
                    .addGroup(loginContentPaneLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(loginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(loginContentPaneLayout.createSequentialGroup()
                                .addGroup(loginContentPaneLayout.createParallelGroup()
                                    .addComponent(用户名, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(loginContentPaneLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(密码, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(loginContentPaneLayout.createParallelGroup()
                                    .addComponent(username, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(password)))
                            .addGroup(loginContentPaneLayout.createSequentialGroup()
                                .addComponent(登录)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(重置)))
                        .addContainerGap(52, Short.MAX_VALUE))
            );
            loginContentPaneLayout.setVerticalGroup(
                loginContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, loginContentPaneLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(loginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(用户名, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(loginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(密码, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(loginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(登录)
                            .addComponent(重置))
                        .addContainerGap(20, Short.MAX_VALUE))
            );
            login.pack();
            login.setLocationRelativeTo(login.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JFrame login;
    private JButton 登录;
    private JButton 重置;
    private JTextField username;
    private JPasswordField password;
    private JLabel 用户名;
    private JLabel 密码;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


}
