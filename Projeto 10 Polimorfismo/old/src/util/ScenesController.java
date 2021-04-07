package src.util;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;

import src.interfaces.Scene;
import src.models.DataGame;

@SuppressWarnings("serial")
public class ScenesController extends JComponent {

    private transient Map<String, Scene> scenes;
    private transient Scene currentScene;
    private boolean firstDraw;

    private transient DataGame dataGame;

    public ScenesController(DataGame dataGame) {
        this.firstDraw = true;
        this.currentScene = null;
        this.scenes = new HashMap<>();
        this.dataGame = dataGame;

        setSize((int) dataGame.getScreenGameSize().getWidth(), (int) dataGame.getScreenGameSize().getHeight());
        setPreferredSize(getSize());
        setBackground(Color.WHITE);

    }

    public DataGame getDataGame() {
        return dataGame;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(this.getBackground());
        GameGraphics graphics = new GameGraphics((Graphics2D) g, dataGame);
        draw(graphics);
        repaint();
    }

    public Map<String, Scene> getScenes() {
        return scenes;
    }

    public void moveTo(String sceneName) {
        if (scenes.containsKey(sceneName)) {
            this.firstDraw = true;
            this.currentScene = this.scenes.get(sceneName);
        }

    }

    public void addScene(Scene scene) {
        if (!scenes.containsKey(scene.getSceneName())) {
            this.scenes.put(scene.getSceneName(), scene);
            if (currentScene == null) {
                this.currentScene = this.scenes.get(scene.getSceneName());
            }
        }

    }

    public void draw(GameGraphics graphics) {
        if (currentScene != null) {
            if (this.firstDraw) {
                currentScene.preDraw(dataGame);
                this.firstDraw = false;
            }
            currentScene.update(dataGame);
            currentScene.draw(graphics);
        }

    }

}
