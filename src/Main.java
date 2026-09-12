import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Main extends JFrame {
    private Space ourUniverse;

    public Main() {
        super("Main");
        ourUniverse = new Space();
        ourUniverse.setBackground(new Color(21, 25, 46));
        setContentPane(ourUniverse);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(800, 600));
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main window = new Main();
            window.setVisible(true);
            window.startAnimation();
        });
    }

    private void startAnimation() {
        Timer timer = new Timer(16, e -> ourUniverse.repaint());
        timer.setInitialDelay(0);
        timer.start();
    }
}
