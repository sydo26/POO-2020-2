package src.interfaces;

import java.util.List;

import src.models.Player;
import src.models.PrimaryPlayer;
import src.util.Dimension2D;
import src.util.GameGraphics;
import src.util.Vector2D;

public interface WorldHandle {
    public Vector2D getPosition();

    public Dimension2D getDimension();

    public List<Player> getPlayers();

    public void addPlayer(Player player);

    public void setPrimaryPlayer(PrimaryPlayer player);

    public void draw(GameGraphics g);

}
