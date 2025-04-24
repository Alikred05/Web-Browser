import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Simple web browser");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1024, 600);

            Browser browserPanel = new Browser();
            frame.add(browserPanel, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}
