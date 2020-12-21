package screens.game.components;

import java.awt.*;
import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import javax.swing.JComponent;

import listeners.GameListeners;
import screens.game.GameGraphics;

public class BlockBreak extends GameComponent {
    private String name;
    private int pressedAnimationFrames = 5;
    private Color color = new Color(100, 100, 100);
    private boolean pressedAnimation = false;
    private GameListeners listener;
    private List<MiniBlocks> blocks = new ArrayList<>();

    public BlockBreak(String name, GameListeners listener) {
        this.name = name;
        this.width = 100;
        this.height = 100;
        this.x = 0;
        this.y = 0;
        this.listener = listener;
        setWithRect();
    }

    public List<MiniBlocks> getBlocks() {
        return this.blocks;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void draw(Graphics g) {
        for(MiniBlocks block : this.blocks){
            if(block != null) {
                block.draw(g);
            }
        }
        g.setColor(this.color);
        g.fillRoundRect(this.x, this.y, 100, 100, 15, 15);
    }

    @Override
    public void update(GameGraphics parent) {
        List<MiniBlocks> removes = new ArrayList<>();
        for(MiniBlocks block : this.blocks){
            block.update(parent);
            if(block.fineshed()) {
                removes.add(block);
            }
        }
        for(MiniBlocks block : removes) {
            this.blocks.remove(block);
        }

        if(isMouseMovedCollision()) {
            GameGraphics.setComponentMouseInside(this.getClass().getName());
        }

        if(GameGraphics.getComponentMouseInside().equals(this.getClass().getName())) {
            if(isMouseMovedCollision()) {
                parent.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }else parent.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }

        if(isMousePressedCollision() || this.pressedAnimation) {
            this.pressedAnimation = true;
            this.color = new Color(250, 100, 20);
            this.pressedAnimationFrames--;
            for(int i = 0; i < 100; i++) {
                this.blocks.add(new MiniBlocks(new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)),
            this.x + (this.width/2), this.y + (this.height/2), (new Random()).nextInt(20 + 20)-20, (new Random()).nextInt(20 + 20)-20));
            } 
            this.listener.addPoints(this.listener.getBooster() * 2);
            if(this.pressedAnimationFrames == 0) {
                this.pressedAnimation = false;
                this.pressedAnimationFrames = 5;
                this.color = new Color(100, 100, 100);
            }
        }
    }

}


class MiniBlocks extends GameComponent {

    private Color color;
    private int directionX;
    private int directionY;
    private int rotateAngle;
    private int timeFrames = 120;

    public MiniBlocks(Color color, int initx, int inity, int directionX, int directionY) {
        this.x = initx;
        this.y = inity;
        this.color = color;
        this.directionX = directionX;
        this.directionY = directionY;

        setSize(20, 20);
    }
    

    public int getRotateAngle() {
        return rotateAngle;
    }

    public int getTimeFrames() {
        return timeFrames;
    }

    public int getDirectionX() {
        return directionX;
    }

    public int getDirectionY() {
        return directionY;
    }

    public Color getColor() {
        return color;
    }

    public boolean fineshed() {
        return this.timeFrames <= 0;
    }

    @Override
    public void update(GameGraphics parent) {
        if(!fineshed()) {
            this.x += this.directionX;
            this.y += this.directionY;
            this.timeFrames--;
        }
    }

    @Override
    public void draw(Graphics g) {
        if(!fineshed()) {
            g.setColor(this.color);
            g.fillRoundRect(this.x, this.y, this.width, this.width, 1, 1);
        }
    }

}
