package game.models;

import game.types.GameObjectType;
import game.util.DataGameGraphics;
import game.util.Dimension2D;
import game.util.GameGraphics;
import game.util.Vector2D;

public abstract class GameObject {

    protected Vector2D position;
    protected Dimension2D size;
    protected GameObjectType type;

    protected GameObject(double x, double y, double w, double h, GameObjectType type) {
        this.position = new Vector2D(x, y);
        this.size = new Dimension2D(w, h);
        this.type = type;
    }

    public GameObjectType getType() {
        return type;
    }

    public Vector2D getPosition() {
        return position;
    }

    public Dimension2D getSize() {
        return size;
    }

    public abstract void update(DataGameGraphics data);

    public abstract void draw(GameGraphics g);

}
