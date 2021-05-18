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
    
    public static Deck deck; // PARA GUARDAR EL DECK SELECCIONADO ANTES EN EL CLICK
    
    public static ArrayList<ArrayList<Cards>> decks;
    private final ArrayList<Cards> cards = new ArrayList<>();
    private final ArrayList<String> info = new ArrayList<>();
    private int actualDeckID;
    
    @FXML
    public void initialize(){
        try {
            decks = new ArrayList<>();
            ConnectionMySQL dataBase = new ConnectionMySQL();
            String SQLsentence = "SELECT Mazo.id, Mazo.nombre, Carta.id, Carta.nombre, Carta.elemento, Carta.ataque, Carta.defensa, "
                    + "Carta.estrellas, Carta.imagen, Carta.tipo, Carta.descripcion "
                    + "FROM Carta, Mazo, Contiene "
                    + "WHERE Contiene.ref_carta = Carta.id AND Contiene.ref_mazo = Mazo.id AND Mazo.ref_jugador = "+Initial_Controller.ID_User+";";
            dataBase.ConectarBasedeDatos();    
            dataBase.result = dataBase.sentence.executeQuery(SQLsentence);          
            int i = 0;
            while (dataBase.result.next()) {
                if(actualDeckID != dataBase.result.getInt(1))
                {                    
                    decks.add(cards);
                    cards.clear();
                    actualDeckID = dataBase.result.getInt(1);
                    info.add(dataBase.result.getString(2));
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
                    i+=1;
                    
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
                    i+=1;                  
                }                
               
            }
            dataBase.DesconectarBasedeDatos();
            System.out.println(decks.size());
            
            ObservableList<ArrayList<Cards>> oList = FXCollections.observableArrayList(decks);
            cards_of_Deck.setItems(oList);            
            cards_of_Deck.setCellFactory(param -> new ListCell<ArrayList<ArrayList<Cards>>>() {
            private ImageView imageView = new ImageView(new Image ("src/Assets/Images/Logo.png"));
            
            @Override
            public void updateItem(ArrayList<ArrayList<Cards>> deck, boolean empty) {
                super.updateItem(deck, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {                      
                    imageView.setImage(new Image ("src/Assets/Images/Logo.png"));    
                    setGraphic(imageView);
                    setText(" > "+info.get(cards_of_Deck.getEditingIndex())+" < \n"+"      > Numero de Cartas: "+deck.get(cards_of_Deck.getEditingIndex()).size());                                
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
        if (deck==null) {
            Notifications.notification("Error", "Debes seleccionar un mazo antes", 1);
        }
        else{
            // SETEAR EL MAZO PREFERIDO EN LA BASE DE DATOS
        }
    }
    
    public void viewCardsOfDecks(){
        // HACER LA QUERY PARA LAS CARTAS Y MOSTRAR SOLAMENTE EL NOMBRE
        // EN EL LIST VIEW CARDS_OF_DECK
    }
    
    @FXML
    public void deleteDeck(){
        // VERIFICAR QUE DECK ESTÉ SELECCIONADO Y LUEGO HACER LA QUERY Y REFRESH
        // DEL VIEW CON ALGUN METODO EKIS DE
    }
}
