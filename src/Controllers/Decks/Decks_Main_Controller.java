/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Decks;

import Controllers.Panels.Initial_Controller;
import Features.Connection.ConnectionMySQL;
import Features.Managements.Adapters;
import Features.Objects.Cards;
import Features.Objects.Deck;
import Features.Managements.Notifications;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Decks_Main_Controller {
    
    @FXML public AnchorPane base;
    @FXML public AnchorPane base_decks;
    @FXML public Button exit;
    @FXML public Button minimize;
    @FXML public Button back;
    @FXML public Button next;
    @FXML public Button prev;
    @FXML public Button createDeckButton;
    @FXML public Button editDeckButton;
    @FXML public Button deleteDeckButton;
    @FXML public Button prefDeckButton;
    
    @FXML public ListView cards_of_Deck;
    
    @FXML public ImageView card00, card01, card02, card03;
    @FXML public ImageView card10, card11, card12, card13;
    @FXML public ImageView card20, card21, card22, card23;
    
    public static Deck deckSelected; 
    public static Deck deckFavorite=null;
    public static int deckID;
    public static String deckName;
    
    private int position = 0;
    
    private final ArrayList<Deck> decks = new ArrayList<>();
    private final ArrayList<Cards> cards = new ArrayList<>();
    private final ArrayList<Image> imagesActualDeck = new ArrayList<>();
    
    private int actualDeckID;
    Deck auxDeck;
    
    @FXML
    public void initialize(){
        try {
            initialize_Decks();
        } catch (Exception e) {
        }
    }

    public void initialize_Decks(){
        try {
            ConnectionMySQL dataBase = new ConnectionMySQL();
            String SQLsentence = "SELECT Mazo.id, Mazo.nombre, Carta.id, Carta.nombre, Carta.elemento, Carta.ataque, Carta.defensa, "
                    + "Carta.estrellas, Carta.imagen, Carta.tipo, Carta.descripcion "
                    + "FROM Carta, Mazo, Contiene "
                    + "WHERE Contiene.ref_carta = Carta.id AND Contiene.ref_mazo = Mazo.id AND Mazo.ref_jugador = "+Initial_Controller.ID_User+";";
            dataBase.ConectarBasedeDatos();    
            dataBase.result = dataBase.sentence.executeQuery(SQLsentence);          
            int i = 0;
            
            while (dataBase.result.next()) {
                if(i==0){                        
                        auxDeck = new Deck(dataBase.result.getInt(1),dataBase.result.getString(2));
                        actualDeckID = dataBase.result.getInt(1);
                        Image imageAux = Adapters.blobToImage(dataBase.result.getBlob(9));
                        Cards c = new Cards(dataBase.result.getInt(3),
                        dataBase.result.getString(4),
                        dataBase.result.getString(5),
                        dataBase.result.getInt(6),
                        dataBase.result.getInt(7),
                        dataBase.result.getInt(8),
                        imageAux,
                        dataBase.result.getString(10),
                        dataBase.result.getString(11));
                        //cards_ImagesView.get(i).setImage(imageAux);
                        cards.add(c);
                }else{
                    if(actualDeckID != dataBase.result.getInt(1))
                    {                    
                        auxDeck.setCards((ArrayList<Cards>) cards.clone());
                        decks.add(auxDeck);
                        cards.clear();
                        auxDeck = new Deck(dataBase.result.getInt(1),dataBase.result.getString(2));
                        actualDeckID = dataBase.result.getInt(1);
                        Image imageAux = Adapters.blobToImage(dataBase.result.getBlob(9));
                        Cards c = new Cards(dataBase.result.getInt(3),
                        dataBase.result.getString(4),
                        dataBase.result.getString(5),
                        dataBase.result.getInt(6),
                        dataBase.result.getInt(7),
                        dataBase.result.getInt(8),
                        imageAux,
                        dataBase.result.getString(10),
                        dataBase.result.getString(11));
                        //cards_ImagesView.get(i).setImage(imageAux);
                        cards.add(c);
                    }else{
                        Image imageAux = Adapters.blobToImage(dataBase.result.getBlob(9));
                        Cards c = new Cards(dataBase.result.getInt(3),
                        dataBase.result.getString(4),
                        dataBase.result.getString(5),
                        dataBase.result.getInt(6),
                        dataBase.result.getInt(7),
                        dataBase.result.getInt(8),
                        imageAux,
                        dataBase.result.getString(10),
                        dataBase.result.getString(11));
                        //cards_ImagesView.get(i).setImage(imageAux);
                        cards.add(c);                                    
                    }
                }
                i++;         
            }          
            auxDeck.setCards((ArrayList<Cards>) cards.clone());           
            decks.add(auxDeck);
            cards.clear();
            dataBase.DesconectarBasedeDatos();        
            viewDecksUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(Decks_Edit_Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @FXML
    public void back() {
        try {
            Stage stage = (Stage) base.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/Views/Panels/Principal_Panel_View.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
        }
    }

    @FXML
    public void createDeck(){
        try{
            Stage stage = (Stage) base.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/Views/Decks/Create_Deck_View.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void editDeck(){
        try{
            Stage stage = (Stage) base.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/Views/Decks/Edit_Deck_View.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
        }
    }
    
    @FXML
    public void minimize(){
        Stage s = (Stage) base.getScene().getWindow();
        s.setIconified(true);
    }
    
    @FXML
    public void exit(){
        System.exit(1);
    }
    
    @FXML
    public void setPrefDeck(){
        if (deckSelected==null) {
            Notifications.notification("Error", "Debes seleccionar un mazo antes", 1);
        }
        else{
            if (deckFavorite!=null)
                deckFavorite.setFavorite(false);
            deckFavorite = deckSelected;  
            deckFavorite.setFavorite(true);
            viewDecksUpdate();
            Notifications.notification("Mazo Preferido", "Se ha cambiado el mazo preferido por el "+deckFavorite.getName(), 9);
        }
    }
    
    public void viewDecksUpdate(){
        ObservableList<Deck> oList = FXCollections.observableArrayList(decks);
        cards_of_Deck.setItems(oList);            
        cards_of_Deck.setCellFactory(param -> new ListCell<Deck>() {
        private final ImageView imageView = new ImageView(new Image ("/Assets/Images/Card_Back.png", 20, 30, false, false));
        private char symbolFavorite;
        @Override
        public void updateItem(Deck deck, boolean empty) {
            super.updateItem(deck, empty);
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {                      
                imageView.setImage(new Image ("/Assets/Images/Card_Back.png", 20, 30, false, false));    
                if(deck.isFavorite())
                    symbolFavorite = 10029;
                else
                    symbolFavorite = ' ';
                setGraphic(imageView);
                setText("<*> "+deck.getName()+" <*> \n"+"  @ Numero de Cartas: "+deck.getCardsCount()+"         "+symbolFavorite);                                
            }
        }
        });
    }
    
    @FXML
    public void seleccionDeck(MouseEvent event){
        try{
            Deck temp =  (Deck) cards_of_Deck.getSelectionModel().getSelectedItem();
            String idString = String.valueOf(temp.getID());
            StringSelection stringSelect = new StringSelection(idString);
            Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
            cb.setContents(stringSelect, null);
            deckSelected = temp;           
            deckID = temp.getID();            
            next.setDisable(false);
            prev.setDisable(true);
            position = 12;
            updateDeckBook();
            deckName = temp.getName();
        }catch(NullPointerException e){
        }
    }    
    
    public void updateDeckBook(){
        imagesActualDeck.clear();
        for (int i = 0; i < deckSelected.getCards().size() ; i++) {
            imagesActualDeck.add(deckSelected.getCards().get(i).getImagen());
        }
        card00.setImage(imagesActualDeck.get(0)); 
        card01.setImage(imagesActualDeck.get(1)); 
        card02.setImage(imagesActualDeck.get(2)); 
        card03.setImage(imagesActualDeck.get(3));
        card10.setImage(imagesActualDeck.get(4));
        card11.setImage(imagesActualDeck.get(5));
        card12.setImage(imagesActualDeck.get(6));
        card13.setImage(imagesActualDeck.get(7));
        card20.setImage(imagesActualDeck.get(8)); 
        card21.setImage(imagesActualDeck.get(9)); 
        card22.setImage(imagesActualDeck.get(10)); 
        card23.setImage(imagesActualDeck.get(11));            
    }
    
    public void changePageForward(){
        if(position < 36){           
            card00.setImage(imagesActualDeck.get((0+position))); 
            card01.setImage(imagesActualDeck.get((1+position))); 
            card02.setImage(imagesActualDeck.get((2+position))); 
            card03.setImage(imagesActualDeck.get((3+position)));
            card10.setImage(imagesActualDeck.get((4+position)));
            card11.setImage(imagesActualDeck.get((5+position)));
            card12.setImage(imagesActualDeck.get((6+position)));
            card13.setImage(imagesActualDeck.get((7+position)));
            card20.setImage(imagesActualDeck.get((8+position))); 
            card21.setImage(imagesActualDeck.get((9+position)));
            card22.setImage(imagesActualDeck.get((10+position))); 
            card23.setImage(imagesActualDeck.get((11+position)));
            position += 12;
        }else{
            card00.setImage(imagesActualDeck.get((0+position))); 
            card01.setImage(imagesActualDeck.get((1+position)));
            card02.setImage(imagesActualDeck.get((2+position))); 
            card03.setImage(imagesActualDeck.get((3+position))); 
            card10.setImage(null);
            card11.setImage(null);
            card12.setImage(null);
            card13.setImage(null);
            card20.setImage(null);
            card21.setImage(null);
            card22.setImage(null); 
            card23.setImage(null);
            next.setDisable(true);        
        }            
        prev.setDisable(false);
    }
    
    public void changePageBackward(){
        if(position >= 12){
            position -= 12;
            card00.setImage(imagesActualDeck.get(0+position)); 
            card01.setImage(imagesActualDeck.get(1+position)); 
            card02.setImage(imagesActualDeck.get(2+position)); 
            card03.setImage(imagesActualDeck.get(3+position));
            card10.setImage(imagesActualDeck.get(4+position));
            card11.setImage(imagesActualDeck.get(5+position));
            card12.setImage(imagesActualDeck.get(6+position));
            card13.setImage(imagesActualDeck.get(7+position));
            card20.setImage(imagesActualDeck.get(8+position)); 
            card21.setImage(imagesActualDeck.get(9+position)); 
            card22.setImage(imagesActualDeck.get(10+position)); 
            card23.setImage(imagesActualDeck.get(11+position));
        }else{
            card00.setImage(imagesActualDeck.get(0)); 
            card01.setImage(imagesActualDeck.get(1)); 
            card02.setImage(imagesActualDeck.get(2)); 
            card03.setImage(imagesActualDeck.get(3));
            card10.setImage(imagesActualDeck.get(4));
            card11.setImage(imagesActualDeck.get(5));
            card12.setImage(imagesActualDeck.get(6));
            card13.setImage(imagesActualDeck.get(7));
            card20.setImage(imagesActualDeck.get(8)); 
            card21.setImage(imagesActualDeck.get(9)); 
            card22.setImage(imagesActualDeck.get(10)); 
            card23.setImage(imagesActualDeck.get(11));      
            prev.setDisable(true);        
        }            
        next.setDisable(false);        
    }
    
    
    @FXML
    public void deleteDeck(){
        try {
            ConnectionMySQL dataBase = new ConnectionMySQL();
            String SQLsentence = "DELETE FROM Mazo WHERE id = "+deckID+" ;";
            dataBase.ConectarBasedeDatos();
            dataBase.sentence.execute(SQLsentence);
            dataBase.DesconectarBasedeDatos();
            Notifications.notification("Mazo Eliminado", "Mazo "+deckName+" Eliminado Correctamente", 9);
        } catch (SQLException ex) {
            Logger.getLogger(Decks_Main_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
