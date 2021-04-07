package game.models.entity;

import java.awt.Color;

import game.types.EntityType;
import game.util.DataGameGraphics;
import game.util.GameGraphics;

public class Player extends Entity {

    public Player(String name, String displayName, double x, double y, double w, double h) {
        super(name, displayName, x, y, w, h, EntityType.PLAYER);
    }

    @Override
    public int receiveDamage(Entity who, int damage) {
        this.life -= damage;
        return damage;
    }

    @Override
    public int attackTo(Entity target) {
        target.receiveDamage(this, damage);
        return 0;
    }

    @Override
    public int attackTo(Entity target, int damage) {
        target.receiveDamage(this, damage);
        return 0;
    }

    @Override
    public void draw(GameGraphics g) {
        g.fill(Color.LIGHT_GRAY);
        g.rect(getPosition(), getSize());
    }

    @Override
    public void update(DataGameGraphics data) {
        // TODO Auto-generated method stub

    }

}
