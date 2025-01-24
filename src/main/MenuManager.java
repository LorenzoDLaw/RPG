package main;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MenuManager {
    private Pane menuPane;
	private VBox vBoxMenu;
	
	//pane for class item party quest
	private GridPane itemPane;
    
    private Button bItem;
    private Button bParty;
    private Button bQuest;
    private Button bSave;

    boolean ItemMenuOn = false;
     
    //dimensioni 
    private int WIDTH_GIOCO;
    private int HEIGHT_GIOCO;
    public MenuManager(int WIDTH_GIOCO,int HEIGHT_GIOCO) {
    	this.HEIGHT_GIOCO = HEIGHT_GIOCO;
    	this.WIDTH_GIOCO = WIDTH_GIOCO;
    	menuPane = new Pane();
    	vBoxMenu = new VBox(10); // 10px spacing between buttons
    	vBoxMenu.setStyle("-fx-padding: 20; -fx-alignment: top-left;");
    	menuPane.setStyle("-fx-alignment: top-left; -fx-background-color: lightgray;");

        // Initialize buttons
        bItem = new Button("Items");
        bParty = new Button("Party Management");
        bQuest = new Button("Quests");
        bSave = new Button("Save");

        // Attach event handlers to buttons
        bItem.setOnAction(this::handleItemMenu);
        bParty.setOnAction(this::handlePartyMenu);
        bQuest.setOnAction(this::handleQuestMenu);
        bSave.setOnAction(this::handleSaveData);

        // Add buttons to the menu
        vBoxMenu.getChildren().addAll(bItem, bParty, bQuest, bSave);
        menuPane.getChildren().add(vBoxMenu);
    }

    // Handlers for each button
    private void handleItemMenu(ActionEvent event) {
    	ItemMenuOn = true;
        System.out.println("Items menu opened!");
        ItemMenuManager ItemMenu = new ItemMenuManager();
        menuPane.getChildren().remove(vBoxMenu);
        itemPane = ItemMenu.getItemMenu();
        menuPane.getChildren().add(itemPane);
        // TODO: Add logic to display inventory items
    }

    private void handlePartyMenu(ActionEvent event) {
        System.out.println("Party management opened!");
        // TODO: Add logic to manage party members and equipment
    }

    private void handleQuestMenu(ActionEvent event) {
        System.out.println("Quest menu opened!");
        // TODO: Add logic to display and manage quests
    }

    private void handleSaveData(ActionEvent event) {
        System.out.println("Game data saved!");
        // TODO: Implement logic to save game data to a file
    }

    
    public boolean isItemMenuOn() {
        return ItemMenuOn;
    }

    public void closeMenu() {
        if (ItemMenuOn) {
            menuPane.getChildren().remove(itemPane);
            menuPane.getChildren().add(vBoxMenu);
            ItemMenuOn = false;
            System.out.println("Sotto-menu chiuso");
        }else {
        	ItemMenuOn = true;
        }
    }

    // Public getter for the menu VBox
    public Pane getMenu() {
        return menuPane;
    }
}
