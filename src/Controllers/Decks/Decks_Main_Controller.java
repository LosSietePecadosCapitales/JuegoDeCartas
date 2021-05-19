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
    @FXML public Button createDeckButton;
    @FXML public Button editDeckButton;
    @FXML public Button deleteDeckButton;
    @FXML public Button prefDeckButton;
    
    @FXML public ListView cards_of_Deck;

    @FXML public ImageView deck00, deck01, deck02, deck03;
    @FXML public ImageView deck10, deck11, deck12, deck13;
    @FXML public ImageView deck20, deck21, deck22, deck23;
    
    public static Deck deckSelected;
    public static Deck deckFavorite;
    public static int deckID;
    public static String deckName;
    
    private final ArrayList<Deck> decks = new ArrayList<>();
    private final ArrayList<Cards> cards = new ArrayList<>();
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
            System.out.println(decks.get(0).getName());
            
            ObservableList<Deck> oList = FXCollections.observableArrayList(decks);
            cards_of_Deck.setItems(oList);            
            cards_of_Deck.setCellFactory(param -> new ListCell<Deck>() {
            private final ImageView imageView = new ImageView(new Image ("/Assets/Images/Card_Back.png", 20, 30, false, false));
            
            @Override
            public void updateItem(Deck deck, boolean empty) {
                super.updateItem(deck, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {                      
                    imageView.setImage(new Image ("/Assets/Images/Card_Back.png", 20, 30, false, false));    
                    setGraphic(imageView);
                    setText(" > "+deck.getName()+" < \n"+"      > Numero de Cartas: "+deck.getCardsCount());                                
                }
            }
            });
            
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
    
    /* DESDE AQUÍ SON LOS METODOS QUE FALTAN DE ESTA CLASE LEER LAS INSTRUCCIONES*/
    
    @FXML
    public void setPrefDeck(){
        // AQUI DEBERÍA IR EL METODO PARA ELEGIR EL MAZO PREFERIDO Y GUARDARLO EN LA DB
        if (deckSelected==null) {
            Notifications.notification("Error", "Debes seleccionar un mazo antes", 1);
        }
        else{
            // SETEAR EL MAZO PREFERIDO EN LA BASE DE DATOS
            
            /* SOLUCION PARCHE*/
            deckFavorite = deckSelected;
            Notifications.notification("Mazo Preferido", "Se ha cambiado el mazo preferido por el "+deckFavorite.getName(), 9);
        }
    }
    
    public void viewCardsOfDecks(){
        // HACER LA QUERY PARA LAS CARTAS Y MOSTRAR SOLAMENTE EL NOMBRE
        // EN EL LIST VIEW CARDS_OF_DECK
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
            deckName = temp.getName();
        }catch(NullPointerException e){
        }
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
