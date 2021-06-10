package server;

import java.io.*;
import java.net.*;
import java.util.HashMap;

public class Main {
    private static HashMap<String, PrintWriter> connectedClients = new HashMap<>();
    private static final int MAX_CONNECTED = 50;
    private static int PORT;
    private static boolean verbose;
    private static ServerSocket server;

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String name;
    }
}
