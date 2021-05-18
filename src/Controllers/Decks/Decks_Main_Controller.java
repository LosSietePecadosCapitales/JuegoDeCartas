/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Decks;

import Features.Managements.Notifications;
import Features.Objects.Deck;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.control.ListView;
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
    
    @FXML
    public void initialize(){

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
