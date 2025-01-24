/*
 * creare un ui nella quale mostrare gli elementi in una list wiew
 * una volta selezionato si cariceranno i dati dell'oggetto accanto nei seguenti campi:
 * Nome
 * Rarità -> da approvare ancora
 * Descrizione
 * 
 * Se un oggetto equipaggiabile inserire anche dati come difesa attacco ecc
 */
package main;

import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;


public class ItemMenuManager {
    private GridPane root; // Layout principale
    private ListView<String> itemListView; // Lista degli oggetti
    private ImageView itemPreview; // Anteprima immagine
    private Label nameLabel, rarityLabel, descriptionLabel; // Dettagli oggetto

    public ItemMenuManager() {
        // Inizializzazione del GridPane
        root = new GridPane();
        root.setPadding(new Insets(20));
        root.setHgap(20);
        root.setVgap(20);

        // **Colonna 0: ListView per gli oggetti**
        itemListView = new ListView<>();
        itemListView.setPrefWidth(200); // Larghezza della ListView
        root.add(itemListView, 0, 0, 1, 2); // Spanning su due righe

        // **Colonna 1: Anteprima immagine**
        itemPreview = new ImageView();
        itemPreview.setFitWidth(150);
        itemPreview.setFitHeight(150);
        itemPreview.setStyle("-fx-border-color: black; -fx-border-width: 2;");
        root.add(itemPreview, 1, 0);

        // **Colonna 2: Dettagli dell'oggetto**
        GridPane detailsPane = dettagliOggetto();
        root.add(detailsPane, 2, 0);

        
    }

    // Metodo per creare il pannello dei dettagli
    private GridPane dettagliOggetto() {
        GridPane detailsPane = new GridPane();
        detailsPane.setHgap(10);
        detailsPane.setVgap(10);

        // Etichette per i dettagli
        nameLabel = new Label("Name: -");
        rarityLabel = new Label("Rarity: -");
        descriptionLabel = new Label("Description: -");

        detailsPane.add(nameLabel, 0, 0);
        detailsPane.add(rarityLabel, 0, 1);
        detailsPane.add(descriptionLabel, 0, 2);

        return detailsPane;
    }


    // Metodo per caricare gli oggetti da un file
   
    
    // Getter per il GridPane
    public GridPane getItemMenu() {
        return root;
    }
}
