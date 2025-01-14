package lorenzo.scanu;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Battle extends Main{

    // Scene components
    private Pane battleScene;
    private GridPane battleGrid;
    private Button btnMeleAttack;
    private Button btnManaAttack;
    private Button btnInventory;
    private Button btnRun;
    private ProgressBar enemyHealthBar;
    private ProgressBar playerHealthBar;
    private ProgressBar playerManaBar;

    // Game dimensions (from Main)
    private int width;
    private int height;

    public Battle() {
        // Initialize dimensions prendendo i dati dal main
        width = WIDTH_GIOCO;  
        height = HEIGHT_GIOCO;

        // Create scene
        battleScene = new Pane();
        //GreadPane for allocate enemy and player sprite
        battleGrid = new GridPane();
        battleGrid.setStyle("-fx-background-color: #C0C0C0;");
        battleGrid.setPrefSize(WIDTH_GIOCO,HEIGHT_GIOCO*0.8);


        // Create components
        enemyHealthBar = new ProgressBar(1.0);
        playerHealthBar = new ProgressBar(1.0);
        playerManaBar = new ProgressBar(1.0);
        
        btnMeleAttack = new Button("Mele Attack");
        btnManaAttack = new Button("Magic Attack");
        btnInventory = new Button("Object");
        btnRun = new Button("Run");

        // Set positions dynamically based on width and height

        battleGrid.add(playerHealthBar, 0,0,1,2);
        battleGrid.add(playerManaBar, 0,1);
        battleGrid.add(enemyHealthBar, 4,0);

        HBox hboxBattle = new HBox(50); // 10 pixels spacing between children
        hboxBattle.getChildren().addAll(btnMeleAttack, btnManaAttack, btnInventory, btnRun);
        hboxBattle.setStyle("-fx-padding: 20;"); // Dark background with padding
        hboxBattle.setLayoutX(WIDTH_GIOCO*0.05);
        hboxBattle.setLayoutY(HEIGHT_GIOCO*0.85);
        
        
        // Add button and health bar to the battle scene 
        battleScene.getChildren().addAll(battleGrid, hboxBattle);
        
        // set on action for button
        btnMeleAttack.setOnAction(e -> {
            System.out.println("melee attack on the enemy!");
            // Additional logic for melee attack goes here
        });

        btnManaAttack.setOnAction(e -> {
            System.out.println("magic spell on the enemy!");
            // Additional logic for magic attack goes here
        });

        btnInventory.setOnAction(e -> {
            System.out.println("inventory ");
            // Additional logic for using an object goes here
        });

        btnRun.setOnAction(e -> {
            System.out.println("You tried to run away from the battle!");
            // Ritornl nella mappa 
            runFromBattle();
        });
    }

    // Return the battle scene
    public Pane getBattle() {
        return battleScene;
    }

    
    
    
    // Calculate damage
    public double calcoloDanni(double attacco, double difesa, boolean isMagic) {
        double dannoBase = isMagic ? attacco * 1.5 : attacco;
        return Math.max(0, dannoBase - difesa);
    }
}
