package src;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import java.awt.event.*;
import java.awt.*;

import src.models.DataGame;
import src.scenes.InGameScene;
import src.util.Dimension2D;
import src.util.ScenesController;

@SuppressWarnings("serial")
public class Game extends JFrame implements MouseMotionListener, KeyListener {

    public final Dimension2D gameSize = new Dimension2D(1024, 768);

    transient DataGame dataGame;

    ScenesController scenesController;

    public Game() {
        setTitle("Game rUiM");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension((int) gameSize.getWidth(), (int) gameSize.getHeight()));
        setLayout(null);
        setResizable(false);
        setUndecorated(true);
        addMouseMotionListener(this);
        addKeyListener(this);

        this.dataGame = new DataGame(gameSize);

        this.scenesController = new ScenesController(dataGame);
        this.scenesController.addScene(new InGameScene());

        getContentPane().add(scenesController);
        pack();
        setLocationRelativeTo(null);
    }

    public void start() {
        setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.dataGame.updateMouse(e.getPoint().getX(), e.getPoint().getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.dataGame.updateMouse(e.getPoint().getX(), e.getPoint().getY());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.dataGame.getKeyBoard().addKeyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.dataGame.getKeyBoard().removeKeyPressed(e.getKeyCode());
    }

}
