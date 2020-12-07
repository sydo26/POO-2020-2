package models;

import java.util.Random;

public class Entity implements Runnable {

    private Thread attackingThread;
    private Entity target = null;

    private int life;
    private int resistence;
    private int force;
    private String name;
    private String id;
    private int criticalChance;
    private int dodgeChance;

    private int currentLife;

    private String type;
    
    private boolean dead = false;
    private boolean attacking = false;

    public Entity(String name, String type) {
        this.id = type.toUpperCase() + "_" + ((int) Math.floor(Math.random() * 10000));
        this.name = name; 
        this.type = type;
        setForce((int) ((Math.random() * (30 - 10)) + 10));
        setLife((int) ((Math.random() * (30 - 10)) + 10));
        setResistence((int) ((Math.random() * (30 - 10)) + 10));
        setCriticalChance((int) ((Math.random() * (80 - 2)) + 2));
        setDodgeChance((int) ((Math.random() * (80 - 2)) + 2));
        setCurrentLife(getRealLife());
    }


    public int getCurrentLife() {
        return currentLife;
    }

    public Entity getTarget() {
        return target;
    }

    public String getType() {
        return type;
    }

    public int getRealLife() {
        return (int) (life * (resistence * 0.3)) * 100;
    }

    public int getRealDamage() {
        return (int) ((force * 100) + resistence * 0.2);
    }

    public int getLife() {
        return life;
    }

    public int getResistence() {
        return resistence;
    }

    public int getForce() {
        return force;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getCriticalChance() {
        return criticalChance;
    }

    public int getDodgeChance() {
        return dodgeChance;
    }

    public boolean isAttacking() {
        return attacking;
    }
    
    public boolean isDead() {
        return dead;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setResistence(int resistence) {
        this.resistence = resistence;
    }

    public void setForce(int force) {
        this.force = force;
    }
    
    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public void setCriticalChance(int criticalChance) {
        this.criticalChance = criticalChance;
    }

    public void setDodgeChance(int dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public void setTarget(Entity target) {
        this.target = target;
    }
    
    public void setCurrentLife(int currentLife) {
        this.currentLife = currentLife;
    }

    public String toString() {
        return (isDead() ? "(DEAD) " : "") + getType() + " [" + getName() + "]" + " Life: " + getLife() + "     " + "Force: " + getForce() + "     " + "Resistence: " + getResistence() + "     " + "Critical Chance: " + getCriticalChance() +  "     " + "Dodge Chance: " + getDodgeChance() + "     " + "Real Life: " + getRealLife() + "     " + "Real Damage: " + getRealDamage() + "     " + "Current Life: " + getCurrentLife();
    }


    @Override
    public void run() {
        while(isAttacking()) {
            try {
                if(getTarget().isDead() || isDead()) break;
                else getTarget().hit(this);
                if(getTarget().isDead()) stopAttack();
            } catch (NullPointerException e) {
                System.out.println(e);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void startAttack(Entity entity) {
        setAttacking(true);
        attackingThread = new Thread(this);
        System.out.println("Iniciando ataque a entidade " + entity.getName() + "...");
        setTarget(entity);
        attackingThread.start();

    }

    public void stopAttack() {
        setAttacking(false);
        if(isAttacking()) attackingThread = null;
    }
    
    public void die() {
        setDead(true);
        if(isAttacking()) stopAttack();
        System.out.println(getName() + " morreu!");
    }

    public void hit(Entity entity) throws Exception{
        int damage = (int) entity.getRealDamage() - (getResistence() * (int) (Math.random() * (22 - 10) + 10));

        boolean critical = false;
        if((Math.random() * 100) < getCriticalChance()) {
            damage *= (Math.random() * (2 - 1) + 1);
            critical = true;
        }

        Thread.sleep(1000);

        if((Math.random() * 100) < getDodgeChance()) {
            System.out.println(getName() + " desviou do ataque!");
            return;
        }
        if(isDead() || getTarget().isDead()) return;
        setCurrentLife(getCurrentLife() - damage < 0 ? 0 : getCurrentLife() - damage);
        System.out.println((critical ? "[CRITICAL_DAMAGE]: " : "") + getName() + " levou " + damage + " de dano. Vida atual: " + getCurrentLife());
        
        if(getCurrentLife() <= 0) die();
    }
}
