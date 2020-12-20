public class Pet {
    private int energyMax;
    private int hungryMax;
    private int cleanMax;

    private int energy;
    private int hungry;
    private int clean;

    private int diamonds;
    private int age;
    private boolean alive;
    private String deadMessage = "";

    private void setEnergy(int energy) {
        this.energy = energy < 0 ? 0 : energy;
    }

    private void setClean(int clean) {
        this.clean = clean < 0 ? 0 : clean;
    }

    private void setHungry(int hungry) {
        this.hungry = hungry < 0 ? 0 : hungry;
    }

    private void setCleanMax(int cleanMax) {
        this.cleanMax = cleanMax;
    }
    
    private void setEnergyMax(int energyMax) {
        this.energyMax = energyMax;
    }

    private void setHungryMax(int hungryMax) {
        this.hungryMax = hungryMax;
    }

    public int getEnergy() {
        return energy;
    }

    public int getHungry() {
        return hungry;
    }

    public int getClean() {
        return clean;
    }

    private void setDiamonds(int diamonds) {
        this.diamonds = diamonds;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getEnergyMax() {
        return energyMax;
    }

    public int getHungryMax() {
        return hungryMax;
    }

    public int getCleanMax() {
        return cleanMax;
    }

    public int getDiamonds() {
        return diamonds;
    }

    public int getAge() {
        return age;
    }

    public boolean isAlive() {
        return alive;
    }

    public Pet(int energyMax, int hungryMax, int cleanMax) {
        this.setDiamonds(0);
        this.setAge(0);
        this.setAlive(true);

        this.setEnergy(energyMax);
        this.setHungry(hungryMax);
        this.setClean(cleanMax);

        this.setEnergyMax(energyMax);
        this.setHungryMax(hungryMax);
        this.setCleanMax(cleanMax);
    }

    private boolean verifyAlive() {
        if(this.getClean() == 0) {
            this.setAlive(false);
            this.deadMessage = "fail: pet morreu de sujeira";
            return true;
        }

        if(this.getEnergy() == 0) {
            this.setAlive(false);
            this.deadMessage = "fail: pet morreu de fraqueza";
            return true;
        }

        if(this.getHungry() == 0) {
            this.setAlive(false);
            this.deadMessage = "fail: pet morreu de fome";
            return true;
        }

        return false;
    }

    public void play() {
        if(!this.isAlive()) {
            System.out.println("fail: pet está morto");
            return;
        }

        this.setEnergy(this.getEnergy() - 2);
        this.setHungry(this.getHungry() - 1);
        this.setClean(this.getClean() - 3);
        this.setDiamonds(this.getDiamonds() + 1);
        this.setAge(this.getAge() + 1);

        if(this.verifyAlive()) {
            System.out.println(this.deadMessage);
        }
    }

    public void shower() {
        if(!this.isAlive()) {
            System.out.println("fail: pet está morto");
            return;
        }
        
        this.setEnergy(this.getEnergy() - 3);
        this.setHungry(this.getHungry() - 1);
        this.setClean(this.getCleanMax());
        this.setAge(this.getAge() + 2);

        if(this.verifyAlive()) {
            System.out.println(this.deadMessage);
        }
    }

    public void eat() {
        if(!this.isAlive()) {
            System.out.println("fail: pet está morto");
            return;
        }

        this.setEnergy(this.getEnergy() - 1);
        this.setHungry(this.getHungry() + 4);
        this.setClean(this.getClean() - 2);
        this.setAge(this.getAge() + 1);

        if(this.verifyAlive()) {
            System.out.println(this.deadMessage);
        }
    }

    public void sleep() {
        if(this.getEnergy() > 15) {
            System.out.println("fail: não está com sono");
            return;
        }
        
        this.setAge(this.getAge() + (this.getEnergyMax() - this.getEnergy()));
        this.setEnergy(this.getEnergyMax());
    }

    public void show() {
        System.out.println(this);
    }

    public String toString() {
        return "E:" + this.getEnergy() + "/" + this.getEnergyMax() + ",  S:" + this.getHungry() + "/" + this.getHungryMax() + ",  L:" + this.getClean() + "/" + this.getCleanMax() +
        ",  D:" + this.getDiamonds() + ",  I:" + this.getAge();
    }

}
