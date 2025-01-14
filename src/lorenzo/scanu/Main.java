package lorenzo.scanu;



import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

	private Scene mainScene;
    private StackPane root;  // usato per layerare il menu e il mondo di gioco :https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/StackPane.html
    
    private GameWordMeaager wordManager;
    private MenuManager menuManager;
    private Battle battleMenager;
    
    final public int WIDTH_GIOCO = 1100;
    final public int HEIGHT_GIOCO = 700;
    
    boolean menuAttivo = false;
    boolean battleOn = false;
    
    VBox menu;
    Pane word; 
    Pane battle;
    
    Timeline timelineGioco = new Timeline(new KeyFrame(
            Duration.seconds(0.5), // ogni quanto va chiamata la funzione
            x -> aggiornaGioco()));
    
	public void start(Stage stageFinestra) throws Exception{
		 root = new StackPane();
	     mainScene = new Scene(root, WIDTH_GIOCO, HEIGHT_GIOCO);
	     
	     wordManager = new GameWordMeaager();
	     menuManager = new MenuManager();
	     battleMenager = new Battle();
	     
	     menu = menuManager.getMenu();
	     word = wordManager.getWord();
	     battle = battleMenager.getBattle();
	     root.getChildren().add(word);
	
	     stageFinestra.setScene(mainScene);
	     stageFinestra.setTitle("JRPG Game");
	     stageFinestra.show();
	     // inizio la timeline
	     timelineGioco.play();
	     
	     
	     mainScene.setOnKeyPressed(event ->{
	    	 if (event.getCode()== KeyCode.ESCAPE) {
	    		/*
	    		 * gestire la visione del menu con una variabile boolean per la visibilita
	    		 * da qui sovrapporre il menu sulla mappa e bolccare la timeline ->stop
	    		 */
	    		 if (menuAttivo == false) {
	    			 root.getChildren().add(menu);
	    			 menuAttivo = true;
	    			 timelineGioco.stop();
	    		 }else {
	    			 root.getChildren().remove(menu);
	    			 menuAttivo = false;
	    			 timelineGioco.play();
	    		 }
	    		 
	    	 }
	    	 if (event.getCode() == KeyCode.B) {
	    		    if (battleOn) {
	    		        root.getChildren().remove(battle);
	    		        root.getChildren().add(word);
	    		        battleOn = false; // Aggiorna lo stato
	    		    } else {
	    		        root.getChildren().remove(word);
	    		        root.getChildren().add(battle);
	    		        battleOn = true; // Aggiorna lo stato
	    		    }
	    		}

	     });
	}
	
	
	public void runFromBattle() {
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