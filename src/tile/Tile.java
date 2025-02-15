package tile;

import javafx.scene.image.Image;

public class Tile {

    // Definizione di ogni immagine come variabile
    Image earthTile = new Image("\\immagini\\tiles\\earth.png");
    Image floor_01Tile = new Image("\\immagini\\tiles\\floor01.png");
    Image grass_00Tile = new Image("\\immagini\\tiles\\grass00.png");
    Image grass_01Tile = new Image("\\immagini\\tiles\\grass01.png");
    Image hutTile = new Image("\\immagini\\tiles\\hut.png");
    Image road_00Tile = new Image("\\immagini\\tiles\\road00.png");
    Image road_01Tile = new Image("\\immagini\\tiles\\road01.png");
    Image road_02Tile = new Image("\\immagini\\tiles\\road02.png");
    Image road_03Tile = new Image("\\immagini\\tiles\\road03.png");
    Image road_04Tile = new Image("\\immagini\\tiles\\road04.png");
    Image road_05Tile = new Image("\\immagini\\tiles\\road05.png");
    Image road_06Tile = new Image("\\immagini\\tiles\\road06.png");
    Image road_07Tile = new Image("\\immagini\\tiles\\road07.png");
    Image road_08Tile = new Image("\\immagini\\tiles\\road08.png");
    Image road_09Tile = new Image("\\immagini\\tiles\\road09.png");
    Image road_10Tile = new Image("\\immagini\\tiles\\road10.png");
    Image road_11Tile = new Image("\\immagini\\tiles\\road11.png");
    Image road_12Tile = new Image("\\immagini\\tiles\\road12.png");
    Image table_01Tile = new Image("\\immagini\\tiles\\table01.png");
    Image treeTile = new Image("\\immagini\\tiles\\tree.png");
    Image wallTile = new Image("\\immagini\\tiles\\wall.png");
    Image water_00Tile = new Image("\\immagini\\tiles\\water00.png");
    Image water_01Tile = new Image("\\immagini\\tiles\\water01.png");
    Image water_02Tile = new Image("\\immagini\\tiles\\water02.png");
    Image water_03Tile = new Image("\\immagini\\tiles\\water03.png");
    Image water_04Tile = new Image("\\immagini\\tiles\\water04.png");
    Image water_05Tile = new Image("\\immagini\\tiles\\water05.png");
    Image water_06Tile = new Image("\\immagini\\tiles\\water06.png");
    Image water_07Tile = new Image("\\immagini\\tiles\\water07.png");
    Image water_08Tile = new Image("\\immagini\\tiles\\water08.png");
    Image water_09Tile = new Image("\\immagini\\tiles\\water09.png");
    Image water_10Tile = new Image("\\immagini\\tiles\\water10.png");
    Image water_11Tile = new Image("\\immagini\\tiles\\water11.png");
    Image water_12Tile = new Image("\\immagini\\tiles\\water12.png");
    Image water_13Tile = new Image("\\immagini\\tiles\\water13.png");

    // Array di tutte le immagini (se vuoi accedere dinamicamente)
    Image[] tileImages = {
        earthTile, floor_01Tile, grass_00Tile, grass_01Tile, hutTile, road_00Tile, road_01Tile, road_02Tile,
        road_03Tile, road_04Tile, road_05Tile, road_06Tile, road_07Tile, road_08Tile, road_09Tile, road_10Tile,
        road_11Tile, road_12Tile, table_01Tile, treeTile, wallTile, water_00Tile, water_01Tile, water_02Tile,
        water_03Tile, water_04Tile, water_05Tile, water_06Tile, water_07Tile, water_08Tile, water_09Tile,
        water_10Tile, water_11Tile, water_12Tile, water_13Tile
    };

    // Metodo per accedere a una tile specifica tramite indice
    public Image getTileByIndex(int index) {
        if (index >= 0 && index < tileImages.length) {
            return tileImages[index];
        } else {
            throw new IndexOutOfBoundsException("Indice non valido: " + index);
        }
    }
}
