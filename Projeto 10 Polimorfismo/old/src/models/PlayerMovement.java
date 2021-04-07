package src.models;

import java.io.Serializable;

import src.util.Dimension2D;
import src.util.Vector2D;

public class PlayerMovement implements Serializable {
    private static final long serialVersionUID = 8861424485047815830L;

    private Vector2D positionInWorld;

    private transient Movement movement;

    public PlayerMovement(double speed, double xWorld, double yWorld) {
        this.positionInWorld = new Vector2D(xWorld, yWorld);
        this.movement = new Movement(new Vector2D(0.5, 0.5), new Vector2D(speed, speed));
    }

    public Movement getMovement() {
        return movement;
    }

    public double getSpeedX() {
        return movement.getVelocityX();
    }

    public double getSpeedY() {
        return movement.getVelocityY();
    }

    public void updateMove() {
        movement.update();
    }

    public void move(int dx, int dy, Dimension2D worldSize, Dimension2D playerSize) {
        movement.accelerate(dx, dy);

        // System.out.println(movement.getVelocityX());
        double x = movement.getVelocityX();

        double nextX = x + getYWorld();

        if (nextX + playerSize.getWidth() / 2 > worldSize.getWidth()) {
            x = x - (nextX - getXWorld());
        } else if (nextX - playerSize.getWidth() / 2 < 0) {
            x = -(getYWorld() - nextX) - x;
        }

        addXWorld(x);
    }

    // public void moveY(int dy, Dimension2D worldSize, Dimension2D playerSize) {
    // double y = dy * playerSpeed;

    // double nextY = y + getYWorld();

    // if (nextY + playerSize.getHeight() / 2 > worldSize.getHeight()) {
    // y = y - (nextY - getYWorld());
    // } else if (nextY - playerSize.getHeight() / 2 < 0) {
    // y = -(getYWorld() - nextY) - y;
    // }

    // addYWorld(y);
    // }

    public void addXWorld(double x) {
        positionInWorld.setX(positionInWorld.getX() + x);
    }

    public void addYWorld(double y) {
        positionInWorld.setY(positionInWorld.getY() + y);
    }

    public void setXWorld(double x) {
        positionInWorld.setX(x);
    }

    public void setYWorld(double y) {
        positionInWorld.setY(y);
    }

    public Vector2D getPositionInWorld() {
        return positionInWorld;
    }

    public double getXWorld() {
        return positionInWorld.getX();
    }

    public double getYWorld() {
        return positionInWorld.getY();
    }
}
