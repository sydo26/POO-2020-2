package src.models;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import src.interfaces.WorldHandle;
import src.util.Dimension2D;
import src.util.GameGraphics;
import src.util.Vector2D;

public class World implements WorldHandle {

    private Vector2D position;
    private Dimension2D dimension;

    private PrimaryPlayer primaryPlayer;

    private List<Player> players;

    public World(double x, double y, double w, double h) {
        this.position = new Vector2D(x, y);
        this.dimension = new Dimension2D(w, h);
        this.players = new ArrayList<>();
    }

    public Player getPrimaryPlayer() {
        return primaryPlayer;
    }

    @Override
    public Vector2D getPosition() {
        return position;
    }

    @Override
    public Dimension2D getDimension() {
        return dimension;
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public void draw(GameGraphics g) {

        double posX = g.getScreenWidth() / 2 - (primaryPlayer != null ? primaryPlayer.getXWorld() : 0);
        double posY = g.getScreenHeight() / 2 - (primaryPlayer != null ? primaryPlayer.getYWorld() : 0);

        g.translate(posX, posY);

        g.fill(Color.DARK_GRAY);

        g.rect(new Vector2D(0, 0), dimension);

        for (Player p : players) {
            p.draw(g);
        }

        g.translate(-posX, -posY);

        if (primaryPlayer != null) {
            primaryPlayer.draw(g);
        }
    }

    @Override
    public void setPrimaryPlayer(PrimaryPlayer primaryPlayer) {
        primaryPlayer.setWorld(this);
        this.primaryPlayer = primaryPlayer;
    }

    @Override
    public void addPlayer(Player player) {
        player.setWorld(this);
        this.players.add(player);
    }

}
