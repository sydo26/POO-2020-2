import javax.swing.JComponent;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class GameGraphics extends JComponent implements MouseListener, MouseMotionListener, KeyListener {

    private transient List<GameObject> gameObjects = new ArrayList<>();

    public GameGraphics() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void addGameObject(GameObject obj) {
        this.gameObjects.add(obj);
    }

    public void removeGameObject(GameObject obj) {
        this.gameObjects.remove(obj);
    }

    public void removeGameObject(int index) {
        this.gameObjects.remove(index);
    }

    private long time = System.currentTimeMillis();

    void stableFrames(long startTime) {
        if (System.currentTimeMillis() - this.time >= 1000) {
            this.time = System.currentTimeMillis();
        }

        long diff = (System.currentTimeMillis() - startTime);
        long sleepTime = (1000 / 120) - diff;

        if (sleepTime >= 0) {
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        for (GameObject obj : this.getGameObjects()) {
            obj.update();
            obj.draw(g2d);
        }

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("monospace", Font.BOLD, 24));

        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (GameObject obj : this.getGameObjects()) {
            obj.mouseClicked(e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (GameObject obj : this.getGameObjects()) {
            obj.mousePressed(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (GameObject obj : this.getGameObjects()) {
            obj.mouseReleased(e);
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        for (GameObject obj : this.getGameObjects()) {
            obj.mouseEntered(e);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        for (GameObject obj : this.getGameObjects()) {
            obj.mouseExited(e);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        for (GameObject obj : this.getGameObjects()) {
            obj.mouseDragged(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for (GameObject obj : this.getGameObjects()) {
            obj.mouseMoved(e);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        for (GameObject obj : this.getGameObjects()) {
            obj.keyTyped(e);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        for (GameObject obj : this.getGameObjects()) {
            obj.keyPressed(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        for (GameObject obj : this.getGameObjects()) {
            obj.keyReleased(e);
        }
    }
    
}
