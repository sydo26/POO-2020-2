package src.models;

import java.awt.*;
import src.util.Dimension2D;
import src.util.GameGraphics;
import src.util.Vector2D;

public class PrimaryPlayer extends Player {

    public PrimaryPlayer(String name, String displayName, double xWorld, double yWorld, Dimension2D collisionBody) {
        super(name, displayName, xWorld, yWorld, collisionBody);
    }

    @Override
    public void paintBody(GameGraphics g, double angle, Vector2D world) {
        double posX = g.getScreenWidth() / 2;
        double posY = g.getScreenHeight() / 2;
        g.translate(posX, posY);
        g.fill(Color.WHITE);
        g.rotate(angle);
        g.rect(-getCollisionDimensionBody().getWidth() / 2, -getCollisionDimensionBody().getHeight() / 2,
                getCollisionDimensionBody().getWidth(), getCollisionDimensionBody().getHeight());
        g.fill(Color.ORANGE);
        g.rect(getCollisionDimensionBody().getWidth() / 2 + 2, -getCollisionDimensionBody().getHeight() / 2 + 5, 10,
                getCollisionDimensionBody().getHeight() - 10);

        g.rotate(-angle);
        g.translate(-posX, -posY);
    }

    @Override
    public void draw(GameGraphics g) {
        paintBody(g, Math.atan2(g.getMouseY() - g.getScreenHeight() / 2, g.getMouseX() - g.getScreenWidth() / 2),
                getPositionInWorld());
        this.painted = true;
    }

    @Override
    public void update(DataGame data) {

        getPlayerMovement().updateMove();

        if (data.getKeyBoard().keyIsPressed(65)) { // left
            getPlayerMovement().move(-1, 0, getWorld().getDimension(), getCollisionDimensionBody());
        }

        if (data.getKeyBoard().keyIsPressed(68)) { // right
            getPlayerMovement().move(1, 0, getWorld().getDimension(), getCollisionDimensionBody());
        } else {
            getPlayerMovement().getMovement().slowdown(1, 0);
        }
        // if (data.getKeyBoard().keyIsPressed(87)) {// top
        // move(0, -1);
        // }

        // if (data.getKeyBoard().keyIsPressed(83)) {// bottom
        // move(0, 1);
        // }

    }
}
