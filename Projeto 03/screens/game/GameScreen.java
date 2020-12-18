package screens.game;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import listeners.GameListeners;
import screens.game.components.BlockBreak;
import screens.game.components.Booster;

public class GameScreen {

    protected JFrame frame;
    protected GameGraphics graphics;
    public GameScreen(String title, GameListeners listener) {
        initGraphics(listener);
        initFrame(title);
        initComponents(listener);
    }

    private void initFrame(String title) {
        this.frame = new JFrame(title);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.getContentPane().add(this.graphics);
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
    }

    private void initGraphics(GameListeners listener) {
        this.graphics = new GameGraphics(listener, 900, 700);
    }

    private void initComponents(GameListeners listener) {
        BlockBreak blockbreak = new BlockBreak("Tap tap!", listener);
        blockbreak.setLocation(this.graphics.getWidth() / 2 - blockbreak.getWidth() / 2, this.graphics.getHeight() / 2 - blockbreak.getHeight() / 2);

        Booster booster = new Booster(listener);
        booster.setLocation(this.graphics.getWidth() - 30 - booster.getWidth(), 30 - (booster.getHeight()/2));
        
        

        // add components
        this.graphics.addComponent(blockbreak);
        this.graphics.addComponent(booster);
    }
}