package src.interfaces;

import src.models.DataGame;
import src.util.GameGraphics;

public interface Scene {

    public String getSceneName();

    public void loadingAssets(DataGame data);

    public void preDraw(DataGame data);

    public void draw(GameGraphics g);

    public void update(DataGame data);
}
