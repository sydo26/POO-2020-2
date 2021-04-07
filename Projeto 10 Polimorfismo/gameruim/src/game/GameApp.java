package game;

import java.awt.event.*;
import java.awt.*;

import javax.swing.JComponent;
import javax.swing.JFrame;

import game.interfaces.UpdateRunnable;
import game.util.DataGame;
import game.util.Dimension2D;
import game.util.GameGraphics;
import game.util.ScenesGame;
import scenes.GameRunning;

public class GameApp extends JFrame implements MouseMotionListener {
    private static final long serialVersionUID = 3458681055934392703L;

    transient DataGame dataGame;
    transient ScenesGame scenesGame;
    transient GameGraphics graphics;

    JComponent canvasScreen;

    public GameApp() {
        this.dataGame = new DataGame(new Dimension2D(1440, 900), 60);
        this.scenesGame = new ScenesGame(dataGame);
        scenesDefault();
        this.setTitle("Game RUim");
        this.setUndecorated(true);
        this.setSize(dataGame.getScreenSize().getDimension());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setBackground(Color.WHITE);

        this.addMouseMotionListener(this);

        this.canvasScreen = new JComponent() {
            private static final long serialVersionUID = 7614874393077118562L;

            @Override
            protected void paintComponent(Graphics g) {
                dataGame.getFrameManager().update(new UpdateRunnable() {
                    @Override
                    public void runLogic() {
                        scenesGame.update(graphics);
                    }

                    @Override
                    public void runGraphics() {
                        if (graphics == null) {
                            setGraphics(new GameGraphics((Graphics2D) g, dataGame));
                        } else
                            graphics.setG2d((Graphics2D) g);

                        scenesGame.draw(graphics);
                        repaint();
                    }
                });
            }
        };

        this.canvasScreen.setSize(dataGame.getScreenSize().getDimension());
        this.canvasScreen.setPreferredSize(dataGame.getScreenSize().getDimension());

        this.getContentPane().add(canvasScreen);
    }

    void setGraphics(GameGraphics g) {
        this.graphics = g;
    }

    void scenesDefault() {
        this.scenesGame.addScene(new GameRunning());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.dataGame.getMouseManager().setScreenX(e.getXOnScreen());
        this.dataGame.getMouseManager().setScreenX(e.getYOnScreen());

        this.dataGame.getMouseManager().setDragX(e.getPoint().getX());
        this.dataGame.getMouseManager().setDragY(e.getPoint().getY());

        this.dataGame.getMouseManager().setX(e.getPoint().getX());
        this.dataGame.getMouseManager().setY(e.getPoint().getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.dataGame.getMouseManager().setScreenX(e.getXOnScreen());
        this.dataGame.getMouseManager().setScreenX(e.getYOnScreen());
        this.dataGame.getMouseManager().setX(e.getPoint().getX());
        this.dataGame.getMouseManager().setY(e.getPoint().getY());
    }
}
