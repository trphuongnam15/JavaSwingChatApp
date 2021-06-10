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

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            if (verbose)
                System.out.println("Client connected: " + socket.getInetAddress());
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                for(;;) {
                    out.println("Enter username:\t");
                    name = in.readLine();
                    if (name == null) {
                        return;
                    }
                    synchronized (connectedClients) {
                        if (!name.isEmpty() && !connectedClients.keySet().contains(name)) break;
                        else out.println("INVALIDNAME");
                    }
                }
                out.println("Welcome to the chat group, " + name.toUpperCase() + "!");
                if (verbose) System.out.println(name.toUpperCase() + " has joined.");
                broadcastMessage("[SYSTEM MESSAGE] " + name.toUpperCase() + " has joined.");
                connectedClients.put(name, out);
                String message;
                out.println("You may join the chat now...");
                while ((message = in.readLine()) != null) {
                    if (!message.isEmpty()) {
                        if (message.toLowerCase().equals("/quit")) break;
                        if (message.toLowerCase().equals("hamima")) {
                            broadcastMessage("palaigit si hamima");
                        }
                        broadcastMessage(name + ": " + message);
                    }
                }
            } catch (Exception e) {
                if (verbose) System.out.println(e);
            } finally {
                if (name != null) {
                    if (verbose) System.out.println(name + " is leaving");
                    connectedClients.remove(name);
                    broadcastMessage(name + " has left");
                }
            }
        }
        
        private static void broadcastMessage(String message) {
            for (PrintWriter p: connectedClients.values()) {
                p.println(message);
            }
        }
    }
}
