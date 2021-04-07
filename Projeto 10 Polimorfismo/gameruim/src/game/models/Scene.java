package game.models;

import java.awt.event.KeyEvent;

import game.interfaces.SceneManager;
import game.util.DataGameGraphics;
import game.util.GameGraphics;

public abstract class Scene {

    protected String sceneName;

    protected Scene() {
        this.sceneName = this.getClass().getCanonicalName();
    }

    public String getSceneName() {
        return sceneName;
    }

    public void keyPressed(KeyEvent e) {
        /** @Override */
    }

    public void keyUp(KeyEvent e) {
        /** @Override */
    }

    public void keyTyped(KeyEvent e) {
        /** @Override */
    }

    public void update(DataGameGraphics data, SceneManager manager) {
        /** @Override */
    }

    public void update(DataGameGraphics data) {
        /** @Override */
    }

    public void update() {
        /** @Override */
    }

    public abstract void setup(GameGraphics g);

    public abstract void draw(GameGraphics g, SceneManager manager);

    @Override
    public String toString() {
        return sceneName;
    }
}
