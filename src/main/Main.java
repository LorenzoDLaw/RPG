package main;



import Entity.Entity;
import Entity.Protagonist;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    
    /*public Protagonist protagonist = new Protagonist();
    public Image x = protagonist.getImage(1);
    public ImageView spritePersonaggio = new ImageView(x);
    private int walkFrameUp = 0;
    private int walkFrameLeft = 0;
    private int walkFrameDown = 0;
    private int walkFrameRight = 0;*/
    
    Timeline timelineGioco = new Timeline(new KeyFrame(
            Duration.seconds(0.5), // ogni quanto va chiamata la funzione
            x -> aggiornaGioco()));
    
	public void start(Stage stageFinestra) throws Exception{
		 root = new StackPane();
	     mainScene = new Scene(root, WIDTH_GIOCO, HEIGHT_GIOCO);
	     
	     wordManager = new GameWordMeaager(WIDTH_GIOCO, HEIGHT_GIOCO);
	     menuManager = new MenuManager();
	     battleMenager = new Battle(WIDTH_GIOCO, HEIGHT_GIOCO);
	     battleMenager.setOnRunCallback(() -> runFromBattle());

	     
	     menu = menuManager.getMenu();
	     word = wordManager.getWord();
	     battle = battleMenager.getBattle();
	     /*protagonist.setImageWalk();
	     //x = protagonist.getImage(1);
	     spritePersonaggio = new ImageView(protagonist.getImage(1));
	     spritePersonaggio.setLayoutX(WIDTH_GIOCO/3);
	     spritePersonaggio.setLayoutY(HEIGHT_GIOCO/2);
	     word.getChildren().add(spritePersonaggio);*/
	     root.getChildren().addAll(word);
	   
	     stageFinestra.setScene(mainScene);
	     stageFinestra.setTitle("JRPG Game");
	     stageFinestra.show();
	     // inizio la timeline
	     timelineGioco.play();
	     
	     
	     
	     //Key pressed scene
	     mainScene.setOnKeyPressed(event -> handleInput(event.getCode()));

	     
	     
	}
	
	
	// Modifica la posizione del personaggio in base alla pressione dei tasti
	private void handleInput(KeyCode code) {
	    if (code == KeyCode.ESCAPE) {
	        if (!menuAttivo) {
	            root.getChildren().add(menu);
	            menuAttivo = true;
	            timelineGioco.stop();
	        } else {
	            root.getChildren().remove(menu);
	            menuAttivo = false;
	            timelineGioco.play();
	        }
	    }else if (code == KeyCode.B) {
	        if (battleOn) {
	            root.getChildren().remove(battle);
	            root.getChildren().add(word);
	            battleOn = false;
	        } else {
	            root.getChildren().remove(word);
	            root.getChildren().add(battle);
	            battleOn = true;
	        }
	    }else switch (code) {
		case W:
			wordManager.moveUp();
			break;
		case S:
			wordManager.moveDown();
			break;
		case A:
			wordManager.moveLeft();
			break;
		case D:
			wordManager.moveRight();
			break;
		default:
			break;
		}
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