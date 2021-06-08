package server;

import javax.swing.*;
import java.awt.*;

public class Server extends JFrame {
    JPanel p1;

    Server() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("server/icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i1);
        l1.setBounds(5, 5, 30, 30);
        setLayout(null);
        setSize(450, 700);
        setLocation(400, 200);
        setVisible(true);
    }
}
