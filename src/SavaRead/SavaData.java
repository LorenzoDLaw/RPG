package SavaRead;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;


import Entity.Entity;

public class SavaData {
	/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Entity contatto1 = new Entity("minotauro");
        
        
        FileWriter writer = null;
        try {
            // Specifica il percorso del file di testo
            File file = new File("dati\\contatti.txt");
            writer = new FileWriter(file, false); // Il parametro `true` abilita l'append
            String nuovoTesto = "GESTIONE CONTATTI\n\n";
            
            writer.write(nuovoTesto + System.lineSeparator());//L'uso di System.lineSeparator() migliora la leggibilità. Conviene usarlo quando si aggiunge testo in coda a un file, per garantire che ogni aggiunta inizi su una nuova riga.
           
            
            writer.close();
            if (file.exists()) {
                
                System.out.println("Il file esiste. Verra’ creato.");
            }
        } catch (FileNotFoundException ex) {
           // Logger.getLogger(GestContatti.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRORE: Non posso creare il file");
        
        } catch (IOException ex) {

        
        }
                
    }

}
