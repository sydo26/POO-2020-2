package game.util;

import java.awt.*;

public class GameGraphics extends GraphicsManager {

    public GameGraphics(Graphics2D graphics2d, DataGame dataGame) {
        super(dataGame);
        this.g2d = graphics2d;
        defineRenderinghints(this.g2d);

    }

    protected void defineRenderinghints(Graphics2D graphics2d) {
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        graphics2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
                RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        graphics2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
    }

    public Graphics2D getG2d() {
        return g2d;
    }

    public void setG2d(Graphics2D g2d) {
        this.g2d = g2d;
        defineRenderinghints(this.g2d);
    }

    public DataGame getDataGame() {
        return dataGame;
    }

    public Dimension2D getScreenSize() {
        return dataGame.getScreenSize();
    }

}
