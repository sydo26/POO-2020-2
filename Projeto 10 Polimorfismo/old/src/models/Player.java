package src.models;

import src.interfaces.PlayerHandle;
import src.util.Dimension2D;
import src.util.GameGraphics;
import src.util.Vector2D;

public class Player extends PlayerRigidBody implements PlayerHandle {

    protected boolean painted;
    private PlayerData playerData;
    private PlayerMovement playerMovement;
    private World world;

    public Player(String name, String displayName, double xWorld, double yWorld, Dimension2D collisionBody) {
        super(collisionBody.getWidth(), collisionBody.getHeight());
        this.playerData = new PlayerData(name, displayName);
        this.playerMovement = new PlayerMovement(1, xWorld, yWorld);
        this.painted = false;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public World getWorld() {
        return world;
    }

    public boolean isPainted() {
        return painted;
    }

    @Override
    public PlayerData getPlayerData() {
        return playerData;
    }

    @Override
    public void setName(String name) {
        this.playerData.setName(name);
    }

    @Override
    public void setDisplayName(String displayName) {
        this.playerData.setDisplayName(displayName);
    }

    @Override
    public String getUUID() {
        return this.playerData.getUUID();
    }

    @Override
    public String getName() {
        return this.playerData.getName();
    }

    @Override
    public String getDisplayName() {
        return this.playerData.getDisplayName();
    }

    @Override
    public PlayerMovement getPlayerMovement() {
        return this.playerMovement;
    }

    @Override
    public Vector2D getPositionInWorld() {
        return this.playerMovement.getPositionInWorld();
    }

    @Override
    public double getXWorld() {
        return this.playerMovement.getXWorld();
    }

    @Override
    public double getYWorld() {
        return this.playerMovement.getYWorld();
    }

    @Override
    public void draw(GameGraphics g) {
        paintBody(g, 0, getPositionInWorld());
        this.painted = true;
    }

    @Override
    public void update(DataGame data) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterFirstDraw(DataGame data) {
        // TODO Auto-generated method stub

    }

}
