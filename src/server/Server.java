package server;

import javax.swing.*;
import java.awt.*;

public class Server extends JFrame {
    JPanel p1;

    Server() {
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(7, 94, 84));
        p1.setBounds(0, 0, 450, 70);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("server/icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(5, 17, 30, 30);
        p1.add(l1);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("server/icons/1.png"));
        Image i5 = i4.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);
        l2.setBounds(5, 17, 60, 60);
        p1.add(l2);

        getContentPane().setBackground(Color.YELLOW);
        setLayout(null);
        setSize(450, 700);
        setLocation(400, 200);
        setVisible(true);
    }
}
