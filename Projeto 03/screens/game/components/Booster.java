package screens.game.components;

import java.awt.*;
import java.awt.event.MouseEvent;

import listeners.GameListeners;
import screens.game.GameGraphics;

public class Booster extends GameComponent {
    private GameListeners listener;
    
    public Booster(GameListeners listener) {
        this.listener = listener;
        this.setSize(500, 30);
    }

    @Override
    public void update(GameGraphics parent) {
        if(this.maxBooster == this.currentBosster) return;
        if(isMouseMovedCollision()) {
            GameGraphics.setComponentMouseInside(this.getClass().getName());
        }

        if(GameGraphics.getComponentMouseInside().equals(this.getClass().getName())) {
            if(isMouseMovedCollision()) {
                parent.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }else parent.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if(inside(e.getX(), e.getY())) {
            if(this.maxBooster == this.currentBosster) return;
            if(this.listener.getPoints() >= calculatedPrice()) {
                this.listener.removePoints(calculatedPrice());
                this.currentBosster++;
                this.listener.upBooster();
            }
        }
    }

    private int calculatedPrice() {
        return (int) (Math.pow((double)((this.currentBosster + 1) * (this.listener.getBooster() * 2)), 2));
    }

    private int maxBooster = 10;
    private int currentBosster = 1;

    @Override
    public void draw(Graphics g) {
        if(this.currentBosster == this.maxBooster) return;
        String str = "Comprar booster x" + this.listener.getBooster() * 4 + " : " + calculatedPrice() + " points";
        FontMetrics metrics = g.getFontMetrics();
        int x = this.x + (this.width - metrics.stringWidth(str)) / 2;
        int y = this.y + ((this.height - metrics.getHeight()) / 2) + metrics.getAscent();

        g.setColor(new Color(255,255,255, isMouseMovedCollision() ? 100 : 20));

        g.fillRoundRect(this.x, this.y, this.width, this.height, 10, 10);
        g.setColor(Color.WHITE);
        g.drawString(str, x, y);
    }
    
}
