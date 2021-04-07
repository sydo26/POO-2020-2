package game.util;

public class DataGame {
    Dimension2D screenSize;
    FrameManager fps;
    MouseManager mouseManager;

    public DataGame(Dimension2D screenSize, int defaultFrameRate) {
        this.screenSize = screenSize;
        this.fps = new FrameManager(defaultFrameRate);
        this.mouseManager = new MouseManager(screenSize.getWidth(), screenSize.getHeight());
    }

    public FrameManager getFrameManager() {
        return fps;
    }

    public Dimension2D getScreenSize() {
        return screenSize;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

}
