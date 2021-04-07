package game.util;

import java.awt.geom.*;

public class DataGameGraphics {

    protected DataGame dataGame;

    public DataGameGraphics(DataGame dataGame) {
        this.dataGame = dataGame;
    }

    public double width() {
        return dataGame.getScreenSize().getWidth();
    }

    public double height() {
        return dataGame.getScreenSize().getHeight();
    }

    public double mouseX() {
        return this.dataGame.getMouseManager().getX();
    }

    public double mouseY() {
        return this.dataGame.getMouseManager().getY();
    }

    public Vector2D mouse() {
        return new Vector2D(this.dataGame.getMouseManager().getX(), this.dataGame.getMouseManager().getY());
    }

    public double mouseDraggedX() {
        return this.dataGame.getMouseManager().getDragX();
    }

    public double mouseDraggedY() {
        return this.dataGame.getMouseManager().getDragY();
    }

    public Vector2D mouseDragged() {
        return new Vector2D(this.dataGame.getMouseManager().getDragX(), this.dataGame.getMouseManager().getDragY());
    }

    public double fps() {
        return this.dataGame.getFrameManager().getFps();
    }

    public double averageFps() {
        return this.dataGame.getFrameManager().getAverageFps();
    }

    public double averageDeltaTime() {
        return this.dataGame.getFrameManager().getAverageDeltaTime();
    }

    public double deltaTime() {
        return this.dataGame.getFrameManager().getDeltaTime();
    }

    public double dist(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public boolean collideEllipseAndPoint(double x, double y, double cx, double cy, double dx, double dy) {

        double rx = dx / 2;
        double ry = dy / 2;
        if (x > cx + rx || x < cx - rx || y > cy + ry || y < cy - ry) {
            return false;
        }
        double xx = x - cx;
        double yy = y - cy;
        double eyy = ry * Math.sqrt(Math.abs(rx * rx - xx * xx)) / rx;
        return yy <= eyy && yy >= -eyy;
    }

    public boolean collideEllipseAndEllipse(double cx1, double cy1, double dx1, double dy1, double cx2, double cy2,
            double dx2, double dy2) {

        return false;
    }
}
