package 其他练习.学校练习.Java实验.第9次作业;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-12-13
 * Time: 16:37
 */
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class TestJFrame {
    public static void main(String[] args) {

        String str="中华人民共和国";
        String path="D:"+ File.separator+"桌面数据"+File.separator+"国旗.png";

        Icon icon=new ImageIcon(path);

        JFrame jf=new JFrame("GUI实验");
        Dimension d = new Dimension();
        Point p=new Point(150,100);
        JLabel jlab=new JLabel(str,icon,JLabel.CENTER);
        Font font=new Font("幼圆",Font.ITALIC+Font.BOLD,20);

        jlab.setFont(font);
        jlab.setForeground(Color.RED);

        jf.add(jlab);

        d.setSize(400,300);

        jf.setSize(d);
        jf.setBackground(Color.WHITE);
        jf.setLocation(p);

        jf.setVisible(true);

    }
}
