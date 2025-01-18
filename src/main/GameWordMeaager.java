package main;

import Entity.Protagonist;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;




public class GameWordMeaager {
	private Pane word;
	public Image backgroundImage = new Image(getClass().getResourceAsStream("/immagini/map.jpg"));
	public ImageView imageView = new ImageView(backgroundImage);
	
	public Protagonist protagonist = new Protagonist();
	public Image x = protagonist.getImage(1);
	public ImageView spritePersonaggio = new ImageView(x);
	public int walkFrameUp = 0;
	public int walkFrameLeft = 0;
	public int walkFrameDown = 0;
	public int walkFrameRight = 0;
	
	public GameWordMeaager(int WIDTH_GIOCO,int HEIGHT_GIOCO) {
		word = new Pane(); 
		
		backgroundImage = new Image(getClass().getResourceAsStream("/immagini/map.jpg"));
		imageView = new ImageView(backgroundImage);
		
		imageView.setFitWidth(WIDTH_GIOCO); 
		imageView.setFitHeight(HEIGHT_GIOCO);
		
		protagonist.setImageWalk();
		spritePersonaggio = new ImageView(protagonist.getImage(1));
	    spritePersonaggio.setLayoutX(WIDTH_GIOCO/3);
	    spritePersonaggio.setLayoutY(HEIGHT_GIOCO/2);
	    word.getChildren().addAll(spritePersonaggio,imageView);
		
	}
	
	public Pane getWord() {
		return word;
	}
	
	
	//classi per la gestione del movimento
	public void moveUp() {
		spritePersonaggio.setLayoutY(spritePersonaggio.getLayoutY() - 10);
        walkFrameUp = (walkFrameUp + 1) % 2; // Alterna tra frame 0 e 1
        spritePersonaggio.setImage(protagonist.getImage(walkFrameUp == 0 ? 1 : 2)); // Frame 1 e 2 per camminata su
	}
	
	public void moveDown() {
		spritePersonaggio.setLayoutY(spritePersonaggio.getLayoutY() + 10);
        walkFrameDown = (walkFrameDown + 1) % 2; // Alterna tra frame 0 e 1
        spritePersonaggio.setImage(protagonist.getImage(walkFrameDown == 0 ? 3 : 4)); // Frame 3 e 6 per camminata giù
	}
	
	public void moveLeft() {
		spritePersonaggio.setLayoutX(spritePersonaggio.getLayoutX() - 10);
        walkFrameLeft = (walkFrameLeft + 1) % 2; // Alterna tra frame 0 e 1
        spritePersonaggio.setImage(protagonist.getImage(walkFrameLeft == 0 ? 5 : 6)); // Frame 5 e 6 per camminata sinistra
	}
	public void moveRight() {
		 spritePersonaggio.setLayoutX(spritePersonaggio.getLayoutX() + 10);
		 walkFrameRight = (walkFrameRight + 1) % 2; // Alterna tra frame 0 e 1
	     spritePersonaggio.setImage(protagonist.getImage(walkFrameRight == 0 ? 7 : 8)); // Frame 7 e 8 per camminata destra
	}
}
