package game.models;

import game.util.Vector2D;

public abstract class Shape {
    protected Vector2D position;

    public abstract boolean collide(Shape shapeObject);

    public abstract boolean collide(double x, double y);

    public abstract Vector2D rotate(double angleRotate);

    public abstract Vector2D rotate(double xO, double yO, double angleRotate);

    public abstract Vector2D translate(double x, double y);

    public abstract Vector2D translate(double x0, double y0, double x, double y);

}
