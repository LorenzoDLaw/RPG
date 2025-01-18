package Entity;

import javafx.scene.image.Image;

public class Entity {
    private String name;
    private double health;
    private double maxHealth;
    private double attack;
    private double defense;
    private double magicPower;

    
    public Image up1,up2,down1,down2,left1,left2,right1,right2;
    
    public Entity(String name, double maxHealth, double attack, double defense, double magicPower) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.attack = attack;
        this.defense = defense;
        this.magicPower = magicPower;
    }
    public Entity(String nome) {
    	this.name = nome;
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

    public boolean isAlive() {
        return health > 0;
    }
        
    
}

