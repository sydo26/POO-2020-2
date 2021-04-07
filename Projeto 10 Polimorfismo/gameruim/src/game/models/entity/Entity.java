package game.models.entity;

import game.models.GameObject;
import game.types.EntityType;
import game.types.GameObjectType;

public abstract class Entity extends GameObject {

    protected String entityName;
    protected String displayName;

    protected int life;
    protected int damage;

    protected EntityType entityType;

    protected Entity(String name, String displayName, double x, double y, double w, double h, EntityType entityType) {
        super(x, y, w, h, GameObjectType.ENTITY);
        this.entityType = entityType;
        this.entityName = name;
        this.displayName = displayName;
    }

    public abstract int receiveDamage(Entity who, int damage);

    public abstract int attackTo(Entity target);

    public abstract int attackTo(Entity target, int damage);

    public boolean isAlive() {
        return life > 0;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public String getEntityName() {
        return entityName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getLife() {
        return life;
    }

    public int getDamage() {
        return damage;
    }

}
