package main;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	
	private Scene mainScene;
    private StackPane root;  // usato per layerare il menu e il mondo di gioco :https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/StackPane.html
    
    private GameWordMeaager wordManager;
    private MenuManager menuManager;
    private Battle battleMenager;
    
    int defaultTileSize = 16;
    int scale = 3;
    int tilesSize = defaultTileSize * scale;
    int gameColoum = 16;
    int gameRow = 12;
    final int WIDTH_GIOCO = gameColoum * tilesSize;
    final int HEIGHT_GIOCO = gameRow * tilesSize;
    
    boolean menuAttivo = false;
    boolean battleOn = false;
    
    Pane menu;
    Pane word; 
    Pane battle;
    
    Timeline timelineGioco = new Timeline(new KeyFrame(
            Duration.seconds(0.5), // ogni quanto va chiamata la funzione
            x -> aggiornaGioco()));
    
	public void start(Stage stageFinestra) throws Exception{
		 root = new StackPane();
	     mainScene = new Scene(root, WIDTH_GIOCO, HEIGHT_GIOCO);
	     
	     wordManager = new GameWordMeaager(WIDTH_GIOCO, HEIGHT_GIOCO);
	     menuManager = new MenuManager(WIDTH_GIOCO, HEIGHT_GIOCO);
	     battleMenager = new Battle(WIDTH_GIOCO, HEIGHT_GIOCO);
	     battleMenager.setOnRunCallback(() -> runFromBattle());

	     
	     menu = menuManager.getMenu();
	     word = wordManager.getWord();
	     battle = battleMenager.getBattle();
	     root.getChildren().addAll(word);
	   
	     stageFinestra.setScene(mainScene);
	     stageFinestra.setTitle("JRPG Game");
	     stageFinestra.show();
	     // inizio la timeline
	     timelineGioco.play();
	     
	     
	     
	     //Key pressed scene
	     mainScene.setOnKeyPressed(event -> handleInput(event.getCode()));

	     
	     
	}
	

	private void handleInput(KeyCode code) {
		System.out.println("IN keyCode");
	    if (code == KeyCode.Q) {
	    	System.out.println("Q");
	        if (menuAttivo) {
	        	
	            // Se un sotto-menu è aperto, chiudilo prima
	            if (menuManager.isItemMenuOn()) {
	                menuManager.closeMenu();
	            } else {
	                // Altrimenti chiudi il menu principale
	                root.getChildren().remove(menu);
	                menuAttivo = false;
	                timelineGioco.play();
	            }
	        } else {
	            // Apri il menu principale
	            root.getChildren().add(menu);
	            menuAttivo = true;
	            timelineGioco.stop();
	        }
	    } else if (code == KeyCode.B) {
	        if (battleOn) {
	            root.getChildren().remove(battle);
	            root.getChildren().add(word);
	            battleOn = false;
	        } else {
	            root.getChildren().remove(word);
	            root.getChildren().add(battle);
	            battleOn = true;
	        }
	    } else {
	    	// Modifica la posizione del personaggio in base alla pressione dei tasti 
	        switch (code) { // vado a richiamare nel GameWOrdMenager metodi per muovere il personaggio
	            case W -> wordManager.moveUp();
	            case S -> wordManager.moveDown();
	            case A -> wordManager.moveLeft();
	            case D -> wordManager.moveRight();
	            default -> {}
	        }
	    }
	}

	public void runFromBattle() { //Metodo per uscire dalla battaglia durante la fase di battaglia nel gioco
		root.getChildren().remove(battle);
        root.getChildren().add(word);
        battleOn = false; // Aggiorna lo stato
	}

	
	private void aggiornaGioco() {
		
		// TODO Auto-generated method stub
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}