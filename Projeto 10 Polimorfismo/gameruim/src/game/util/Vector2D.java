package game.util;

import java.io.Serializable;

public class Vector2D implements Serializable {
    private static final long serialVersionUID = 2448434813845816490L;
    public double x;
    public double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Vector2D setX(double x) {
        this.x = x;
        return this;
    }

    public Vector2D setY(double y) {
        this.y = y;
        return this;
    }

    public Vector2D addX(double valueX) {
        this.x += valueX;
        return this;
    }

    public Vector2D addY(double valueY) {
        this.y += valueY;
        return this;
    }

    public Vector2D add(Vector2D other) {
        this.x += other.getX();
        this.y += other.getY();
        return this;
    }

    public Vector2D reduceX(double valueX) {
        this.x -= valueX;
        return this;
    }

    public Vector2D reduceY(double valueY) {
        this.y -= valueY;
        return this;
    }

    public Vector2D reduce(Vector2D other) {
        this.x -= other.getX();
        this.y -= other.getY();
        return this;
    }

    @Override
    public String toString() {
        return "[ x:" + this.getX() + ", y:" + this.getY() + " ]";
    }

    public static Vector2D getRotatePosition(double x, double y, double angleRotate) {
        return new Vector2D(x * Math.cos(angleRotate) + y * Math.sin(angleRotate),
                -x * Math.sin(angleRotate) + y * Math.cos(angleRotate));
    }

}
