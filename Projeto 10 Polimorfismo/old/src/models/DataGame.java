package src.models;

import src.util.Dimension2D;

public class DataGame {
    private Dimension2D screenGameSize;
    private Mouse mouse;
    private KeyBoard keyBoard;

    public DataGame(Dimension2D screenGameSize) {
        this.screenGameSize = screenGameSize;
        this.mouse = new Mouse(0, 0, screenGameSize.getWidth(), screenGameSize.getHeight());
        this.keyBoard = new KeyBoard();
    }

    public void updateMouse(double x, double y) {
        this.mouse.setScreenX(x);
        this.mouse.setScreenY(y);
    }

    public Mouse getMouse() {
        return mouse;
    }

    public KeyBoard getKeyBoard() {
        return keyBoard;
    }

    public Dimension2D getScreenGameSize() {
        return screenGameSize;
    }
}
