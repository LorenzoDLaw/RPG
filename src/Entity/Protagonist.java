package Entity;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;

public class Protagonist extends Entity{

    // Protagonist attributes 
    private String name;
    private int level;
    private int experience;

    // Stats
    private double maxHealthPoints;
    private double healthPoints;
    private double manaPoints;
    private double strength;
    private double magic;
    private double defense;
    private double magicDefense;

    // Equipment
    private String weapon;
    private String armor;
    private String accessory;

    // Inventory and cash
    private int cash;
    private List<String> inventory;

    
    public Image staticImg = new Image(getClass().getResourceAsStream("/immagini/Protagonist.png"));
    
    
    // Constructors
    public Protagonist(String name) {
    	super(name);
        this.level = 1;
        this.experience = 0;

        // Default stats
        this.maxHealthPoints = 100;
        this.healthPoints = 100;
        this.manaPoints = 50;
        this.strength = 10;
        this.magic = 10;
        this.defense = 5;
        this.magicDefense = 5;

        this.cash = 0;
        this.inventory = new ArrayList<>();

        this.weapon = "Old Sword";
        this.armor = "Old Armor";
        this.accessory = null;
    }

    public Protagonist() {
        this("Unnamed Hero");
    }

    // Level-up method
    public void levelUp() {
        this.level++;
        this.maxHealthPoints += 10;
        this.healthPoints = this.maxHealthPoints; // Restore health on level-up
        this.manaPoints += 5;
        this.strength += 2;
        this.magic += 2;
        this.defense += 1;
        this.magicDefense += 1;
        System.out.println("Congratulations! You've leveled up to Level " + this.level);
    }

    // Experience and level-up progression
    public void gainExperience(int exp) {
        this.experience += exp;
        System.out.println("Gained " + exp + " experience points.");
        while (this.experience >= experienceToNextLevel()) {
            this.experience -= experienceToNextLevel();
            levelUp();
        }
    }

    private int experienceToNextLevel() {
        return 100 * this.level; // Example formula for required experience
    }

    // Equipment methods
    public void equipWeapon(String weapon) {
        this.weapon = weapon;
        System.out.println("Equipped weapon: " + weapon);
    }

    public void equipArmor(String armor) {
        this.armor = armor;
        System.out.println("Equipped armor: " + armor);
    }

    public void equipAccessory(String accessory) {
        this.accessory = accessory;
        System.out.println("Equipped accessory: " + accessory);
    }

    // Inventory management
    public void addToInventory(String item) {
        inventory.add(item);
        System.out.println(item + " added to inventory.");
    }

    public boolean removeFromInventory(String item) {
        if (inventory.remove(item)) {
            System.out.println(item + " removed from inventory.");
            return true;
        }
        System.out.println(item + " not found in inventory.");
        return false;
    }

    public void displayInventory() {
        System.out.println("Inventory: " + (inventory.isEmpty() ? "Empty" : String.join(", ", inventory)));
    }

    // Helper method to check if alive
    public boolean isAlive() {
        return healthPoints > 0;
    }

    // Getters and setters (unchanged for brevity)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }
    public double getMaxHealthPoints() { return maxHealthPoints; }
    public void setMaxHealthPoints(double maxHealthPoints) { this.maxHealthPoints = maxHealthPoints; }
    public double getHealthPoints() { return healthPoints; }
    public void setHealthPoints(double healthPoints) { this.healthPoints = healthPoints; }
    public double getManaPoints() { return manaPoints; }
    public void setManaPoints(double manaPoints) { this.manaPoints = manaPoints; }
    public double getStrength() { return strength; }
    public void setStrength(double strength) { this.strength = strength; }
    public double getMagic() { return magic; }
    public void setMagic(double magic) { this.magic = magic; }
    public double getDefense() { return defense; }
    public void setDefense(double defense) { this.defense = defense; }
    public double getMagicDefense() { return magicDefense; }
    public void setMagicDefense(double magicDefense) { this.magicDefense = magicDefense; }
    
    
    // image menager for the characther
    public void setImageWalk(){
    	up1 = new Image(getClass().getResourceAsStream("/immagini/boy_up_1.png"));
        up2 = new Image(getClass().getResourceAsStream("/immagini/boy_up_2.png"));
        down1 = new Image(getClass().getResourceAsStream("/immagini/boy_down_1.png"));
        down2 = new Image(getClass().getResourceAsStream("/immagini/boy_down_2.png"));
        left1 = new Image(getClass().getResourceAsStream("/immagini/boy_left_1.png"));
        left2 = new Image(getClass().getResourceAsStream("/immagini/boy_left_2.png"));
        right1 = new Image(getClass().getResourceAsStream("/immagini/boy_right_1.png"));
        right2 = new Image(getClass().getResourceAsStream("/immagini/boy_right_2.png"));
    }
    
    public Image getImage(int i) {
        switch (i) {
            case 1:
                return up1;
            case 2:
                return up2;
            case 3:
                return down1;
            case 4:
                return down2;
            case 5:
                return left1;
            case 6:
                return left2;
            case 7:
                return right1;
            case 8:
                return right2;
            default:
                throw new IllegalArgumentException("Unexpected value: " + i);
        }
    }
    
    public void movement(KeyEvent e) {
    	switch (e.getKeyCode()) {
		case 'W':
			
			break;
		case 'S':
			
			break;
		case 'A':
			
			break;
		case 'D':
			
			break;
		default:
			break;
		}
    	
    	
    }

}
