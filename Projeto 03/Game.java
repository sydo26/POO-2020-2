import java.awt.*;

import listeners.GameListeners;
import screens.game.GameScreen;

public class Game implements GameListeners {
    private Player player;
    private GameScreen gameScreen;
    private int pointBooster = 1;

    public Game(String nickName) {
        this.player = new Player(nickName);
        Game game = this;
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameScreen("GIVEME POINTS", game);
            }
        });
    }

    @Override
    public String playerNickName() {
        return this.player.getNickname();
    }

    @Override
    public void upBooster() {
        this.pointBooster *= 2;
    }

    @Override
    public int getBooster() {
        return this.pointBooster;
    }

    @Override
    public void addPoints(int value) {
        this.player.setPoints(this.player.getPoints() + value);
    }

    @Override
    public long getPoints() {
        return this.player.getPoints();
    }

    @Override
    public void removePoints(int value) {
        this.player.setPoints(this.player.getPoints() - value);
    }

    protected void setGameScreen(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public Player getPlayer() {
        return this.player;
    }

    public GameScreen getGameScreen() {
        return this.gameScreen;
    }

}
