package screens.game.components;
import java.awt.event.MouseEvent;
import java.awt.*;
import screens.game.*;

import screens.game.BodyType;

public abstract class GameComponent {

    protected BodyType bodyType = BodyType.RECT;
    protected int x = 0;
    protected int y = 0;
    protected int width = 0;
    protected int height = 0;
    protected int arcWidth = 0;
    protected int arcHeight = 0;
    protected boolean mousePressedCollision = false;
    protected boolean mouseMovedCollision = false;


    public final BodyType getBodyType() {
        return this.bodyType;
    }
    
    public final void setWithArc() {
        this.bodyType = BodyType.ARC;
    }

    public final void setWithRect() {
        this.bodyType = BodyType.RECT;
    }

    public final void setArcSize(int arcWidth, int arcHeight) {
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
    }

    public final void setArcHeight(int arcHeight) {
        this.arcHeight = arcHeight;
    }

    public final void setArcWidth(int arcWidth) {
        this.arcWidth = arcWidth;
    }

    public final int getArcHeight() {
        return this.arcHeight;
    }

    public final int getArcWidth() {
        return this.arcWidth;
    }

    public final int getAlignCenterX() {
        return this.x + (this.width/2);
    }

    public final int getAlignCenterY() {
        return this.y + (this.height/2);
    }

    public final int getHeight() {
        return this.height;
    }
    
    public final int getWidth() {
        return this.width;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public final boolean isMouseMovedCollision() {
        return this.mouseMovedCollision;
    }

    public final boolean isMousePressedCollision() {
        return this.mousePressedCollision;
    }

    public final void setHeight(int height) {
        this.height = height;
    }

    public final void setMouseMovedCollision(boolean mouseMoved) {
        this.mouseMovedCollision = mouseMoved;
    }

    public final void setMousePressedCollision(boolean mousePressed) {
        this.mousePressedCollision = mousePressed;
    }

    public final void setWidth(int width) {
        this.width = width;
    }

    public final void setX(int x) {
        this.x = x;
    }

    public final void setY(int y) {
        this.y = y;
    }

    public final void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public final void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private final boolean insideRect(int x, int y) {
        return (x >= this.x && x <= this.x + getWidth())
        && (y >= this.y && y <= this.y + getHeight());
    }

    private final boolean insideArc(int x, int y) {
        double r = ((double) this.height/2) + (Math.pow((double) this.width/2, 2)/(8*((double) this.height/2)));
        int dx = x - this.getAlignCenterX();
        int dy = y - this.getAlignCenterY();

        return Math.abs(Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2))) <= r;
    }

    public final boolean inside(int x, int y) {
        switch(this.bodyType.toString()) {
            case "RECT": 
                return insideRect(x, y);
            case "RECT_ROUND":
                return false;
            case "ARC":
                return insideArc(x, y);
            default: return false;
        }
    }

    public void mouseClicked(MouseEvent e) {
       
    }

    public void mousePressed(MouseEvent e) {
        this.mousePressedCollision = inside(e.getX(), e.getY());
        // System.out.println("Pressed: " + this.mousePressed + " mouseX:" + e.getX() + " mouseY:" + e.getY() + "\t alignX: " + this.getAlignCenterX() + " alignY:" + this.getAlignCenterY());
    }

    public void mouseMoved(MouseEvent e) {
        this.mouseMovedCollision = inside(e.getX(), e.getY());
        // System.out.println("Moved: " + this.mouseMoved);
    }

    public void mouseReleased(MouseEvent e) {
        this.mousePressedCollision = false;
    }


    public abstract void update(GameGraphics parent);
    public abstract void draw(Graphics g);

}
