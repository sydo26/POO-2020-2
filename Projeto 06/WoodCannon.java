import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class WoodCannon extends GameObject {

    private int speed = 1;

    private boolean firing = false;
    private int speedFire = 1;
    private int maxYChange = 20;
    private int yChange = 0;

    public WoodCannon(int x, int y) {
        this.setSize(50, 100);
        this.setLocation(x, y);
    }

    private List<Bullet> bullets = new ArrayList<>();

    @Override
    public void draw(Graphics2D g) {
        if(this.firing) {
            if(this.yChange < maxYChange) {
                this.yChange += this.speedFire;
            }else {
                this.firing = false;
                this.yChange = 0;
            }
        }

        g.setColor(new Color(200, 100, 50));
        g.fillRect(this.getX(), this.getY() + this.yChange, this.getWidth(), this.getHeight());
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(3.0f));
        g.drawRect(this.getX(), this.getY() + this.yChange, this.getWidth(), this.getHeight());

        g.setColor(new Color(200, 100, 50));
        g.fillRect(this.getX() + (this.getWidth()/2) - 10, this.getY() - 10 + this.yChange, 20, 10);
        g.setColor(Color.BLACK);
        g.drawRect(this.getX() + (this.getWidth()/2) - 10, this.getY() - 10 + this.yChange, 20, 10);

        g.setColor(Color.DARK_GRAY);
        g.fillRoundRect(this.getX() + this.getWidth() - (60 + 25), this.getY() + this.getHeight() - 30, 120, 30, 20, 20);
        g.setColor(Color.BLACK);
        g.drawRoundRect(this.getX() + this.getWidth() - (60 + 25), this.getY() + this.getHeight() - 30, 120, 30, 20, 20);

        for(Bullet bullet : this.bullets) {
            bullet.update();
            bullet.draw(g);
        }
    }

    private boolean movingLeft = false;
    private boolean movingRight = false;

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'a') {
            this.movingLeft = true;
        }else if(e.getKeyChar() == 'd') {
            this.movingRight = true;
        }

        if(e.getKeyChar() == ' ') {
            if(!this.firing) {
                this.bullets.add(new Bullet(this.getX() + (this.getWidth()/2) - (10/2), this.getY() - 10));
            }
            this.firing = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == 'a' && this.movingLeft) {
            this.movingLeft = false;
        } else if(e.getKeyChar() == 'd' && this.movingRight) {
            this.movingRight = false;
        }
    }

    @Override
    public void update() {
        List<Bullet> removes = new ArrayList<>();
        for(Bullet bullet : this.bullets) {
            if(bullet.getY() < -bullet.getHeight()) {
                bullet.clean();
                removes.add(bullet);
            }
        }

        for(Bullet bullet : removes) {
            this.bullets.remove(bullet);
        }

        if(this.movingLeft && this.getX() - (60 - 25) > this.getMinX()) {
            if(this.getX() - (60 - 25) < this.getMinX()) this.setLocation(1, this.getY());
            else this.setLocation(this.getX() - this.speed, this.getY());
            
        }else if (this.movingRight && this.getX() + (60 + 40) < this.getMaxX()) {
            if(this.getX() + (60 + 40) > this.getMaxX()) this.setLocation(this.getMaxX() - 1, this.getY());
            else this.setLocation(this.getX() + this.speed, this.getY());
            
        }
    }

    @Override
    public void clean() {
        // TODO Auto-generated method stub

    }
}


class Bullet extends GameObject {

    private Color color;
    private int speed = 5;
    private boolean clean = false;

    public Bullet(int x, int y) {
        this.setLocation(x, y);
        this.setSize(20, 20);
        this.color = new Color((int) Math.random() * 255, (int) Math.random() * 255, (int) Math.random() * 255);
    }

    @Override
    public void draw(Graphics2D g) {
        if(!this.clean) {
            g.setColor(this.color);
            g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        }
    }

    @Override
    public void update() {
        if(!this.clean) {
            this.setLocation(this.getX(), this.getY() - this.speed);
            if(this.getY() < -this.getHeight()) {
                this.clean();
            }
        }
    }

    @Override
    public void clean() {
        this.clean = true;
    }



}