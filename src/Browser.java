import javax.swing.*;
import java.awt.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Browser extends JPanel {
    private JTextField urlField;
    private JButton goButton;
    private JFXPanel jfxPanel;
    private WebEngine webEngine;

    public Browser() {
        setLayout(new BorderLayout());

        urlField = new JTextField("https://example.com", 30);
        goButton = new JButton("GO");

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Enter URL:"));
        topPanel.add(urlField);
        topPanel.add(goButton);

        add(topPanel, BorderLayout.NORTH);

        jfxPanel = new JFXPanel(); // JavaFX component in Swing
        add(jfxPanel, BorderLayout.CENTER);

        Platform.runLater(this::initFX);  // Run JavaFX code in FX thread

        goButton.addActionListener(e -> loadPage());
        urlField.addActionListener(e -> loadPage());
    }

    private void initFX() {
        WebView webView = new WebView();
        webEngine = webView.getEngine();

        jfxPanel.setScene(new Scene(webView));
        loadPage();
    }

    private void loadPage() {
        String url = urlField.getText();
        if (!url.startsWith("http")) {
            url = "https://" + url;
        }
        String finalUrl = url;
        Platform.runLater(() -> webEngine.load(finalUrl));
    }
}
