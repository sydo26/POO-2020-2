import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import java.awt.event.*;

public class Game {

    public static final int WIDTH = 1024;
    public static final int HEIGHT = 768;

    private JFrame gameScreen;
    private GameGraphics gameGraphics;

    public Game() {
        EventQueue.invokeLater(() -> {
            init();
            insertComponents();
        });
    }

    public GameGraphics getGameGraphics() {
        return gameGraphics;
    }

    public JFrame getGameScreen() {
        return gameScreen;
    }

    void insertComponents() {
        WoodCannon woodCannon = new WoodCannon(100, 625);
        woodCannon.setMaxX(WIDTH);
        woodCannon.setMinX(0);
        this.gameGraphics.addGameObject(woodCannon);
    }

    void init() {
        this.gameGraphics = new GameGraphics();
        this.gameGraphics.setSize(WIDTH, HEIGHT);
        this.gameGraphics.setLayout(null);
        this.gameGraphics.setLocation(0, 0);

        this.gameScreen = new JFrame("WoodCannon");
        this.gameScreen.setSize(WIDTH, HEIGHT);
        this.gameScreen.setLocationRelativeTo(null);
        this.gameScreen.setContentPane(this.gameGraphics);
        this.gameScreen.setResizable(false);
        this.gameScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        for(MouseListener listener : this.gameGraphics.getMouseListeners()) {
            this.gameScreen.addMouseListener(listener);
        }

        for(MouseMotionListener listener : this.gameGraphics.getMouseMotionListeners()) {
            this.gameScreen.addMouseMotionListener(listener);
        }

        for(KeyListener listener : this.gameGraphics.getKeyListeners()) {
            this.gameScreen.addKeyListener(listener);
        }

        this.gameScreen.setVisible(true);
        
    }
}
