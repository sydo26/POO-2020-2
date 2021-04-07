package src.interfaces;

import src.models.DataGame;
import src.models.PlayerData;
import src.models.PlayerMovement;
import src.util.GameGraphics;
import src.util.Vector2D;

public interface PlayerHandle {

    public PlayerData getPlayerData();

    public void setName(String name);

    public void setDisplayName(String displayName);

    public String getUUID();

    public String getName();

    public String getDisplayName();

    public PlayerMovement getPlayerMovement();

    public Vector2D getPositionInWorld();

    public double getXWorld();

    public double getYWorld();

    public void draw(GameGraphics g);

    public void update(DataGame data);

    public void afterFirstDraw(DataGame data);
}
