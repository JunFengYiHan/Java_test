package 其他练习.学校练习.实践测试题.简单记事本;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.io.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2021-12-22
 * Time: 21:22
 */
public class Notepad {
    private JFrame jFrame;
    private JMenu jMenu;
    private JMenuBar jMenuBar;
    private JMenuItem newItem, openItem, saveItem, saveAsItem, closeItem;
    private JTextArea jTextArea;
    private File file;
    JFileChooser jfc;

    public Notepad() {
        jFrame = new JFrame("记事本");

        jFrame.setLayout(null);

        jTextArea = new JTextArea(5, 10);
        jTextArea.setBounds(0, 0, 680, 730);
        jTextArea.setEnabled(true);


        jMenu = new JMenu("文件");//菜单栏
        newItem = new JMenuItem("新建(N)");
        openItem = new JMenuItem("打开(O))");
        saveItem = new JMenuItem("保存(S)");
        saveAsItem = new JMenuItem("另存为(A)");
        closeItem = new JMenuItem("关闭(E)");
        newItem.setMnemonic('N');
        newItem.setAccelerator(KeyStroke.getKeyStroke('N', Event.CTRL_MASK));
        openItem.setMnemonic('O');
        openItem.setAccelerator(KeyStroke.getKeyStroke('O', Event.CTRL_MASK));
        saveItem.setMnemonic('S');
        saveItem.setAccelerator(KeyStroke.getKeyStroke('S', Event.CTRL_MASK));
        saveAsItem.setMnemonic('A');
        saveAsItem.setAccelerator(KeyStroke.getKeyStroke('A', Event.CTRL_MASK));
        closeItem.setMnemonic('E');
        closeItem.setAccelerator(KeyStroke.getKeyStroke('E', Event.CTRL_MASK));
        jMenu.add(newItem);
        jMenu.add(openItem);
        jMenu.add(saveItem);
        jMenu.add(saveAsItem);
        jMenu.add(closeItem);
        jMenuBar = new JMenuBar();
        jMenuBar.add(jMenu);

        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Notepad();
            }
        });
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                //jfc.showOpenDialog(jFrame);
                jfc.showOpenDialog(null);
                file = jfc.getSelectedFile();
                if (file != null) {
                    try {
                        Scanner sc = new Scanner(new FileInputStream(file));
                        while (sc.hasNextLine()) {
                            jTextArea.append(sc.nextLine());
                            jTextArea.append("\n");
                        }
                    } catch (FileNotFoundException fileNotFoundException) {
                        JOptionPane.showMessageDialog(null, "文件打开失败", "提示", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (file == null) {
                    jfc = new JFileChooser();
                    jfc.showSaveDialog(null);
                    file = jfc.getSelectedFile();
                }
                saveFile();
                //JOptionPane.showMessageDialog(null,"保存成功","提示",JOptionPane.INFORMATION_MESSAGE);

            }
        });
        saveAsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //jfc.showOpenDialog(jFrame);
                jfc = new JFileChooser();
                jfc.showSaveDialog(null);
                file = jfc.getSelectedFile();
                saveFile();
                //JOptionPane.showMessageDialog(null,"保存成功","提示",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        closeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jFrame.add(jTextArea);
        jFrame.setJMenuBar(jMenuBar);
        jFrame.setSize(680, 720);
        jFrame.setVisible(true);
    }

    private void saveFile() {
        try {
            if (file != null) {
                OutputStream ops = new FileOutputStream(file);
                byte[] data = jTextArea.getText().getBytes();
                ops.write(data);
                JOptionPane.showMessageDialog(null, "保存成功", "提示", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
