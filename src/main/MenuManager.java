package main;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MenuManager {
    private VBox menu;
    private Button bItem;
    private Button bParty;
    private Button bQuest;
    private Button bSave;

    public MenuManager() {
        menu = new VBox(10); // 10px spacing between buttons
        menu.setStyle("-fx-padding: 20; -fx-alignment: top-left; -fx-background-color: lightgray;");

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
        menu.getChildren().addAll(bItem, bParty, bQuest, bSave);
    }

    // Handlers for each button
    private void handleItemMenu(ActionEvent event) {
        System.out.println("Items menu opened!");
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

    // Public getter for the menu VBox
    public VBox getMenu() {
        return menu;
    }
}
