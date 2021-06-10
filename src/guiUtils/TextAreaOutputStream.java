package guiUtils;

import java.io.OutputStream;
import javax.swing.JTextArea;

public class TextAreaOutputStream extends OutputStream  {
    private final JTextArea txtArea;
    private final StringBuilder sb = new StringBuilder();

    public TextAreaOutputStream(JTextArea txtArea) {
        this.txtArea = txtArea;
    }

    @Override
    public void write(int b) {
        if (b == '\r') {
            return;
        }
        if (b == '\n') {
            final String text = sb + "\n";

            txtArea.append(text);
            sb.setLength(0);
        } else {
            sb.append((char) b);
        }
    }
}
