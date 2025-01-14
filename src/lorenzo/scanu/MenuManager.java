package lorenzo.scanu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

//creazione del menu nella sua interfaccia 
	// elementi del menu 
	/*
	 * Item --> oggetti del inventario : medicine per hp e mp oggetti storia armi armature e accessory 
	 * party / gestione stat --> memmbry del team, gestione punti statisstica, equipaggiamento
	 * quest --> missioni nel gioco, sviluppare un modo per tenerne traccia 
	 * salva --> salva dati in un file esterno di memoria sovrasvrivi i dati (se riesco più salvataggi) 
	 */

public class MenuManager extends Main{
	private VBox menu;
    private Button bItem;
    private Button bParty;
    private Button bQuest;
    private Button bSave;
	
    public MenuManager() {
		menu = new VBox();
		menu.setStyle("-fx-padding: 20; -fx-alignment: top-left;");
		
		
		// Inizializzazione dei pulsanti
        bItem = new Button("Items");
        bParty = new Button("Party Management");
        bQuest = new Button("Quests");
        bSave = new Button("Save");
        
        //richiamo per i metodi
        bItem.setOnAction(openItem() );
        bParty.setOnAction(openParty());
        bQuest.setOnAction(openQuest());
        bSave.setOnAction(saveData());
        
        // inserisco nel menu
        menu.getChildren().addAll(bItem,bParty,bQuest,bSave);
	}
	
	 private EventHandler<ActionEvent> openItem() {
	        return event -> {
	            System.out.println("Items menu opened!");
	            VBox Item;
	            // inserire logica per aprire il munu degli ogggetti
	        };
	    }

	    private EventHandler<ActionEvent> openParty() {
	        return event -> {
	            System.out.println("Party management opened!");
	            // inserire logica per aprire il munu del party
	        };
	    }

	    private EventHandler<ActionEvent> openQuest() {
	        return event -> {
	            System.out.println("Quest menu opened!");
	            // Logica futura per visualizzare le missioni
	        };
	    }

	    private EventHandler<ActionEvent> saveData() {
	        return event -> {
	            System.out.println("Game data saved!");
	            // salvataggio dati su file 
	        };
	    }

	public VBox getMenu() {
		return menu;
	}
	
}
