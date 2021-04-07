package objects;

import java.awt.Color;
import java.util.Random;

import game.models.entity.Monster;
import game.models.entity.Player;
import game.util.DataGameGraphics;
import game.util.GameGraphics;
import game.util.Vector2D;

public class BallMonster extends Monster {

    public Player target;

    Vector2D random = null;

    private double speedX;
    private double speedY;

    public BallMonster(String name, String displayName, double x, double y, double size) {
        super(name, displayName, x, y, size, size);
        this.speedX = 0;
        this.speedY = 0;
        this.life = 1;
    }

    public void setTargetPlayer(Player target) {
        this.target = target;
    }

    @Override
    public void update(DataGameGraphics data) {

        if (!this.isAlive())
            return;

        if (random == null) {
            this.random = new Vector2D((new Random()).nextInt((int) data.width()), data.height() * 2);
        }

        this.speedX = ((random.x - position.x) / 500);
        this.speedY = ((random.y - position.y) / 500);

        double posX = position.x != random.x ? position.x + speedX : random.x;
        double posY = position.y != random.y ? position.y + speedY : random.y;

        position.x = posX;
        position.y = posY;

        if (data.collideEllipseAndPoint(position.x, position.y, target.getPosition().x, target.getPosition().y,
                target.getSize().w, target.getSize().h)) {
            this.life = 0;
        }

        if (position.y > data.height() + size.getHeight()) {
            this.life = 0;
        }
    }

    @Override
    public void draw(GameGraphics g) {
        if (position.x >= 0 && position.x <= g.width()) {
            g.fill(Color.PINK);
            g.circle(position.x, position.y, size.w);
        }
    }

}
