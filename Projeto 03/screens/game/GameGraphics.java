package screens.game;

import javax.swing.JComponent;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;

import listeners.GameListeners;

import screens.game.components.GameComponent;

import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class GameGraphics extends JComponent {
    private float fps = 0;
    private float finalFps = 0;
    private long time = System.currentTimeMillis();
    private transient GameListeners listener;
    private static String componentMouseInside = "";

    private final transient List<GameComponent> components = new ArrayList<>(); 

    private static final int MAX_FPS = 240;

    public GameGraphics(GameListeners listener, int width, int height) {
        this.listener = listener;
        this.setLayout(null);
        this.setLocation(0, 0);
        this.setPreferredSize(new Dimension(width, height));
        this.mouseEvents();
    }

    public static String getComponentMouseInside() {
        return componentMouseInside;
    }

    public static void setComponentMouseInside(String name) {
        componentMouseInside = name;
    }

    public final void addComponent(GameComponent component) {
        this.components.add(component);
    }

    public final void removeComponent(GameComponent component) {
        this.components.remove(component);
    }

    public final void setComponents(List<GameComponent> components) {
        this.components.removeAll(this.components);
        this.components.addAll(components);
    }    

    private void mouseEvents() {

        addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                //
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                for(GameComponent comp : components) {
                    comp.mouseMoved(e);
                }
            }
            
        });

        addMouseListener(new MouseInputListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                for(GameComponent comp : components) {
                    comp.mouseClicked(e);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // System.out.println("Pressed");
                for(GameComponent comp : components) {
                    comp.mousePressed(e);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                // System.out.println("Released");
                for(GameComponent comp : components) {
                    comp.mouseReleased(e);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                // System.out.println("Entered");

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                // System.out.println("Exited");
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                // ignore
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                // ignore
            }
            
        });
    }
    private boolean fpsCheck(long startTime) {
        if (System.currentTimeMillis() - this.time >= 1000) {
            this.time = System.currentTimeMillis();
            this.finalFps = this.fps;
            this.fps = 0;
        }
        this.fps++;

        long diff = (System.currentTimeMillis() - startTime);
        long sleepTime = 1000 / MAX_FPS - diff;

        if (sleepTime >= 0) {
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        long startTime = System.currentTimeMillis();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getPreferredSize().width, this.getPreferredSize().height);
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 18));

        for(GameComponent comp : this.components) {
            comp.update(this);
            comp.draw(g);
        }

        g.drawString("Olá, " + this.listener.playerNickName(), 30, 30);
        g.drawString("FPS: " + this.finalFps, 30, 60);
        g.setColor(Color.YELLOW);
        g.drawString("Points: " + this.listener.getPoints(), 30, 640);
        g.drawString(this.listener.getBooster() * 2 + " pontos a cada 1 frame em que você segura o botão.", 30, 670);
        
        fpsCheck(startTime);
        repaint();
    }

}