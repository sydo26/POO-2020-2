
import javax.swing.SwingUtilities;

import game.GameApp;

public class App {
    public static void main(String[] args) throws InterruptedException {
        SwingUtilities.invokeLater(() -> new GameApp());
    }
}
