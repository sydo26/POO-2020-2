package game.util;

public class MouseManager {
    private double xMax;
    private double yMax;
    private double screenX;
    private double screenY;

    private double x;
    private double y;

    private double dragX;
    private double dragY;

    public MouseManager(double xMax, double yMax) {
        this.screenX = 0;
        this.screenY = 0;
        this.x = 0;
        this.y = 0;
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public double getxMax() {
        return xMax;
    }

    public double getyMax() {
        return yMax;
    }

    public void setScreenX(double valueX) {
        this.screenX = valueX;
    }

    public void setScreenY(double valueY) {
        this.screenY = valueY;
    }

    public double getScreenX() {
        return screenX;
    }

    public double getScreenY() {
        return screenY;
    }

    public double getDragX() {
        return dragX;
    }

    public double getDragY() {
        return dragY;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public void setDragX(double dragX) {
        this.dragX = dragX < 0 ? 0 : (dragX > xMax ? xMax : dragX);
    }

    public void setDragY(double dragY) {
        this.dragY = dragY < 0 ? 0 : (dragY > yMax ? yMax : dragY);
    }

    public void setX(double x) {
        this.x = x < 0 ? 0 : (x > xMax ? xMax : x);
    }

    public void setY(double y) {
        this.y = y < 0 ? 0 : (y > yMax ? yMax : y);
    }
}
