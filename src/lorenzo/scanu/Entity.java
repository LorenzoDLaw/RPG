package lorenzo.scanu;

public class Entity {
    private String name;
    private double health;
    private double maxHealth;
    private double attack;
    private double defense;
    private double magicPower;

    public Entity(String name, double maxHealth, double attack, double defense, double magicPower) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.attack = attack;
        this.defense = defense;
        this.magicPower = magicPower;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = Math.max(0, Math.min(health, maxHealth));
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public double getAttack() {
        return attack;
    }

    public double getDefense() {
        return defense;
    }

    public double getMagicPower() {
        return magicPower;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String getName() {
        return name;
    }
}

