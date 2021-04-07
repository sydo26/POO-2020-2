package src.scenes;

import src.models.DataGame;
import src.models.Player;
import src.models.PrimaryPlayer;
import src.models.SceneBase;
import src.models.World;
import src.util.Dimension2D;
import src.util.GameGraphics;

public class InGameScene extends SceneBase {

    PrimaryPlayer player;
    World world;

    public InGameScene() {
        System.out.println("Scene: " + this.getSceneName());
        this.world = new World(20, 20, 2000, 2000);
    }

    @Override
    public void preDraw(DataGame data) {
        this.player = new PrimaryPlayer("sydo26", "Sydo26", 200, 200, new Dimension2D(50, 50));

        this.world.setPrimaryPlayer(this.player);
        this.world.addPlayer(new Player("teste", "Player teste", 50, 50, new Dimension2D(50, 50)));
    }

    @Override
    public void update(DataGame data) {
        this.player.update(data);
    }

    @Override
    public void draw(GameGraphics g) {
        g.background(71, 71, 71);
        this.world.draw(g);

    }
}
