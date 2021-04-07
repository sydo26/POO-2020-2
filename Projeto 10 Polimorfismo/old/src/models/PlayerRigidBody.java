package src.models;

import java.awt.Color;

import src.util.Dimension2D;
import src.util.GameGraphics;
import src.util.Vector2D;

public class PlayerRigidBody {

    private Dimension2D collisionDimensionBody;

    public PlayerRigidBody(double width, double height) {
        this.collisionDimensionBody = new Dimension2D(width, height);
    }

    public Dimension2D getCollisionDimensionBody() {
        return collisionDimensionBody;
    }

    public void paintBody(GameGraphics g, double angle, Vector2D world) {

        g.translate(world.getX(), world.getY());
        g.fill(Color.RED);
        g.rotate(angle);
        g.rect(-collisionDimensionBody.getWidth() / 2, -collisionDimensionBody.getHeight() / 2,
                collisionDimensionBody.getWidth(), collisionDimensionBody.getHeight());
        g.rotate(-angle);
        g.translate(-world.getX(), -world.getY());

    }
}
