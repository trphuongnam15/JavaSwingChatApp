package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JTextField;


public class GUI  extends JFrame implements ActionListener {
    private static Socket clientSocket;
    private static int PORT;
    private PrintWriter out;
    private JPanel contentPane;
    private JTextArea txtAreaLogs;
    private JButton btnStart;
    private JPanel panelNorth;
    private JLabel lblChatClient;
    private JPanel panelNorthSouth;
    private JLabel lblPort;
    private JLabel lblName;
    private JPanel panelSouth;
    private JButton btnSend;
    private JTextField txtMessage;
    private JTextField txtNickname;
    private JTextField txtPort;
    private String clientName;
}
