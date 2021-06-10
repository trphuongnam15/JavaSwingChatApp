package server;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import me.alexpanov.net.FreePortFinder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;


public class GUI extends JFrame implements ActionListener {
    public static SimpleDateFormat formatter = new SimpleDateFormat("[hh:mm a]");
    private static HashMap<String, PrintWriter> connectedClients = new HashMap<>();
    private static final int MAX_CONNECTED = 50;
    private static int PORT;
    private static ServerSocket server;
    private static volatile boolean exit = false;

    private JPanel contentPane;
    private JTextArea txtAreaLogs;
    private JButton btnStart;
    private JLabel lblChatServer;
    
    GUI() {
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(7, 94, 84));
        p1.setBounds(0, 0, 450, 70);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("server/icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(5, 17, 30, 30);
        p1.add(l1);

        l1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
                System.exit(0);
            }
        });

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("server/icons/1.png"));
        Image i5 = i4.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);
        l2.setBounds(40, 5, 60, 60);
        p1.add(l2);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("server/icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l5 = new JLabel(i9);
        l5.setBounds(290, 20, 30, 30);
        p1.add(l5);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("server/icons/phone.png"));
        Image i12 = i11.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
        ImageIcon i13 = new ImageIcon(i12);
        JLabel l6 = new JLabel(i13);
        l6.setBounds(350, 20, 35, 30);
        p1.add(l6);

        ImageIcon i14 = new ImageIcon(ClassLoader.getSystemResource("server/icons/3icon.png"));
        Image i15 = i14.getImage().getScaledInstance(13, 25, Image.SCALE_DEFAULT);
        ImageIcon i16 = new ImageIcon(i15);
        JLabel l7 = new JLabel(i16);
        l7.setBounds(410, 20, 13, 25);
        p1.add(l7);

        JLabel l3 = new JLabel("Gaitonde");
        l3.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        l3.setForeground(Color.WHITE);
        l3.setBounds(110, 15, 100, 20);
        p1.add(l3);

        JLabel l4 = new JLabel("Active Now");
        l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
        l4.setForeground(Color.WHITE);
        l4.setBounds(110, 35, 100, 20);
        p1.add(l4);

        a1 = new JTextArea();
        a1.setBounds(5, 75, 440, 570);
        a1.setBackground(Color.PINK);
        add(a1);

        t1 = new JTextField();
        t1.setBounds(5, 655, 310, 40);
        t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(t1);

        b1 = new JButton("Send");
        b1.setBounds(320, 655, 123, 40);
        b1.setBackground(new Color(7, 94, 84));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        b1.addActionListener(this);
        add(b1);

        //getContentPane().setBackground(Color.YELLOW);
        setLayout(null);
        setSize(450, 700);
        setLocation(400, 200);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String out = t1.getText();
        a1.setText(a1.getText() + "\n" + out);
    }
}
