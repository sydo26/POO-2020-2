package src.util;

import java.awt.geom.*;

import src.models.DataGame;

import java.awt.*;

public class GraphicsManager {
    protected Graphics2D g2d;
    protected DataGame dataGame;

    public void shapeDraw(Shape shape) {
        this.g2d.draw(shape);
    }

    public void shapeFill(Shape shape) {
        this.g2d.fill(shape);
    }

    public void stroke(Stroke stroke) {
        this.g2d.setStroke(stroke);
    }

    public void rectDraw(double x, double y, double width, double height) {
        shapeDraw(new Rectangle2D.Double(x, y, width, height));
    }

    public void rectDraw(Vector2D vector, Dimension2D dimension) {
        rectDraw(vector.getX(), vector.getY(), dimension.getWidth(), dimension.getHeight());
    }

    public void circleDraw(double x, double y, double size) {
        shapeDraw(new Ellipse2D.Double(x, y, size, size));
    }

    public void circleDraw(Vector2D vector, double size) {
        circleDraw(vector.getX(), vector.getY(), size);
    }

    public void rect(double x, double y, double width, double height) {
        shapeFill(new Rectangle2D.Double(x, y, width, height));
    }

    public void rect(Vector2D vector, Dimension2D dimension) {
        rect(vector.getX(), vector.getY(), dimension.getWidth(), dimension.getHeight());
    }

    public void circle(double x, double y, double size) {
        shapeFill(new Ellipse2D.Double(x, y, size, size));
    }

    public void circle(Vector2D vector, double size) {
        circle(vector.getX(), vector.getY(), size);
    }

    public void fill(Color color) {
        this.g2d.setColor(color);
    }

    public void fill(String color) {
        if (color.startsWith("#")) {
            fill(Color.decode(color));
        } else {
            fill(Color.getColor(color));
        }
    }

    public void fill(int r, int g, int b) {
        fill(new Color(r, g, b));
    }

    public void fill(int r, int g, int b, int a) {
        fill(new Color(r, g, b, a));
    }

    public void background(Color color) {
        Color save = this.g2d.getColor();
        fill(color);
        rect(0, 0, dataGame.getScreenGameSize().getWidth(), dataGame.getScreenGameSize().getHeight());
        fill(save);
    }

    public void background(String color) {
        if (color.startsWith("#")) {
            background(Color.decode(color));
        } else {
            background(Color.getColor(color));
        }
    }

    public void background(int r, int g, int b) {
        background(new Color(r, g, b));
    }

    public void background(int r, int g, int b, int a) {
        background(new Color(r, g, b, a));
    }

    public void translate(double x, double y) {
        this.g2d.translate(x, y);
    }

    public void translate(Vector2D vector) {
        translate(vector.getX(), vector.getY());
    }

    public void rotate(double theta) {
        this.g2d.rotate(theta);
    }

    public void rotate(double theta, double x, double y) {
        this.g2d.rotate(theta, x, y);
    }

    public void rotate(double theta, Vector2D vector) {
        rotate(theta, vector.getX(), vector.getY());
    }

}
