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

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI frame = new GUI();
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(frame);
                    System.setOut(new PrintStream(new TextAreaOutputStream(frame.txtAreaLogs)));
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 570, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        lblChatServer = new JLabel("CHAT SERVER");
        lblChatServer.setHorizontalAlignment(SwingConstants.CENTER);
        lblChatServer.setFont(new Font("Tahoma", Font.PLAIN, 40));
        contentPane.add(lblChatServer, BorderLayout.NORTH);

        btnStart = new JButton("START");
        btnStart.addActionListener(this);
        btnStart.setFont(new Font("Tahoma", Font.PLAIN, 30));
        contentPane.add(btnStart, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        txtAreaLogs = new JTextArea();
        txtAreaLogs.setBackground(Color.BLACK);
        txtAreaLogs.setForeground(Color.WHITE);
        txtAreaLogs.setLineWrap(true);
        scrollPane.setViewportView(txtAreaLogs);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnStart) {
            if(btnStart.getText().equals("START")) {
                exit = false;
                getRandomPort();
                start();
                btnStart.setText("STOP");
            }else {
                addToLogs("Chat server stopped...");
                exit = true;
                btnStart.setText("START");
            }
        }
        refreshUIComponents();
    }

    public void refreshUIComponents() {
        lblChatServer.setText("CHAT SERVER" + (!exit ? ": "+PORT:""));
    }

    public static void start() {
        new Thread(new ServerHandler()).start();
    }

    public static void stop() throws IOException {
        if (!server.isClosed()) server.close();
    }

    private static void broadcastMessage(String message) {
        for (PrintWriter p: connectedClients.values()) {
            p.println(message);
        }
    }

    public static void addToLogs(String message) {
        System.out.printf("%s %s\n", formatter.format(new Date()), message);
    }

    private static int getRandomPort() {
        int min = 50000;
        int max = 60000;
        int port = (int)Math.floor(Math.random()*(max - min + 1) + min);
        PORT = port;
        return port;
    }
}
