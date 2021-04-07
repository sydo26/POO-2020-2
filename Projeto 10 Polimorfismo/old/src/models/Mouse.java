package src.models;

public class Mouse {
    private double xMax;
    private double yMax;
    private double screenX;
    private double screenY;

    public Mouse(double x, double y, double xMax, double yMax) {
        this.screenX = x;
        this.screenY = y;
        this.xMax = xMax;
        this.yMax = yMax;
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

    public double getY() {
        return screenY > yMax ? yMax : screenY;
    }

    public double getX() {
        return screenX > xMax ? xMax : screenX;
    }
}
