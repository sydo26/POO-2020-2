package src.models;

import src.interfaces.Scene;
import src.util.GameGraphics;

public abstract class SceneBase implements Scene {

    @Override
    public String getSceneName() {
        return this.getClass().getCanonicalName();
    }

    @Override
    public void loadingAssets(DataGame data) {
        // TODO Auto-generated method stub
    }

    @Override
    public void preDraw(DataGame data) {
        // TODO Auto-generated method stub
    }

    @Override
    public void draw(GameGraphics g) {
        // TODO Auto-generated method stub
    }

}
