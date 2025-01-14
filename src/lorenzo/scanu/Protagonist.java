package lorenzo.scanu;

import java.util.ArrayList;
import java.util.List;

public class Protagonist {

    //Protagonist attributes 
    private String name;
    private int level;
    private int experience;

    //Stats
    private int healthPoints;
    private int manaPoints;
    private int strength;
    private int magic;
    private int defense;
    private int magicDefense;
    
    //extra points assignable by the player
    private int extraPoint;
   
    //Equipment
    private String weapon;
    private String armor;
    private String accessory;


    //Inventarui e oro
    private int cash;
    private List<String> inventory;
    
    //Constructor x first fase game
    public Protagonist(String name) {
        this.name = name;
        this.level = 1;
        this.experience = 0;

        //default stats
        this.healthPoints = 100;
        this.manaPoints = 50;
        this.strength = 10;
        this.magic = 10;
        this.defense = 5;
        this.magicDefense = 5;
        this.extraPoint = 0;
        // other attributes
        
        this.cash = 0;
        this.inventory = new ArrayList<>();
        
        this.weapon = "old sword";
        this.armor = "old armor";
        this.accessory = null;
    }

    public Protagonist() {
    	
    }
    
    
    public void levelUp() {
    	this.level = level++;
    	this.healthPoints = healthPoints++;
        this.manaPoints = manaPoints++;
        this.strength = strength++;
        this.magic = magic++;
        this.defense = defense++;
        this.magicDefense = magicDefense++;
        this.extraPoint = extraPoint++;
    }
    
    public void addExtraLevelUpPoint(int healthPoints, int manaPoints, int strength,
    		int magic, int defense, int magicDefense, int agility,int luck){
    	this.healthPoints = healthPoints;
        this.manaPoints = manaPoints;
        this.strength = strength;
        this.magic = magic;
        this.defense = defense;
        this.magicDefense = magicDefense;

    }
}

