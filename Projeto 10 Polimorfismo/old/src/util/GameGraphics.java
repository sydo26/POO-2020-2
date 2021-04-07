package src.util;

import java.awt.*;

import src.models.DataGame;
import src.models.Mouse;

public class GameGraphics extends GraphicsManager {

    public GameGraphics(Graphics2D graphics2d, DataGame dataGame) {
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        graphics2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
                RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        graphics2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

        this.g2d = graphics2d;
        this.dataGame = dataGame;
    }

    public Graphics2D getG2d() {
        return g2d;
    }

    public double getScreenWidth() {
        return getScreenDimension().getWidth();
    }

    public double getScreenHeight() {
        return getScreenDimension().getHeight();
    }

    public DataGame getDataGame() {
        return dataGame;
    }

    public Mouse getMouse() {
        return dataGame.getMouse();
    }

    public double getMouseX() {
        return getMouse().getX();
    }

    public double getMouseY() {
        return getMouse().getY();
    }

    public Dimension2D getScreenDimension() {
        return dataGame.getScreenGameSize();
    }

}
