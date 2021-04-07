package game.util;

import java.util.Map;
import java.util.TreeMap;

import game.interfaces.Draw;
import game.interfaces.SceneManager;
import game.models.Scene;

public class ScenesGame implements SceneManager, Draw {

    DataGame dataGame;

    Map<String, Scene> scenes;

    String currentScene;

    boolean firstDraw;

    public ScenesGame(DataGame data) {
        this.dataGame = data;
        this.scenes = new TreeMap<>();
        this.currentScene = null;
        this.firstDraw = true;
    }

    public void setCurrentScene(String currentScene) {
        if (scenes.containsKey(currentScene)) {
            this.currentScene = currentScene;
            dataGame.fps.setFrameRate(dataGame.fps.getDefaultFrameRate());
        }
    }

    public Scene getCurrentScene() {
        return scenes.get(currentScene);
    }

    public void addScene(Scene scene) {
        if (!this.scenes.containsKey(scene.getSceneName())) {
            this.scenes.put(scene.getSceneName(), scene);
            if (currentScene == null) {
                this.currentScene = scene.getSceneName();
            }
        }
    }

    @Override
    public void update(DataGameGraphics data) {
        if (!firstDraw) {
            this.getCurrentScene().update(data, this);
            this.getCurrentScene().update(data);
            this.getCurrentScene().update();
        }
    }

    @Override
    public void draw(GameGraphics g) {
        if (firstDraw) {
            this.getCurrentScene().setup(g);
            this.firstDraw = false;
        }
        this.getCurrentScene().draw(g, this);
    }

    @Override
    public void moveTo(String sceneName) {
        if (scenes.containsKey(sceneName)) {
            this.currentScene = sceneName;
        }
    }

}
