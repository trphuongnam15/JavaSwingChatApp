import javax.swing.*;

public class Server extends JFrame {
    Server() {
        setSize(450, 700);
        setLocation(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Server().setVisible(true);
    }
}
