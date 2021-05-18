/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Panels;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Principal_Panel_Controller {
    
    @FXML public AnchorPane base;
    @FXML public Label title;
    @FXML public Button exit;
    @FXML public Button minimize;
    @FXML public Text slogan;
    @FXML public Button cards;
    @FXML public Button decks;
    @FXML public Button createGame;
    @FXML public Button joinGame;
    
    @FXML public Label nick;

    @FXML public AnchorPane ap01;
    @FXML public AnchorPane ap02;
    @FXML public AnchorPane ap11;
    @FXML public AnchorPane ap12;
    @FXML public AnchorPane ap21;
    @FXML public AnchorPane ap22;
    @FXML public AnchorPane ap31;
    @FXML public AnchorPane ap32;
    @FXML public AnchorPane ap41;
    @FXML public AnchorPane ap42;
    @FXML public AnchorPane ap51;
    @FXML public AnchorPane ap52;
    
    
    @FXML
    public void initialize(){
        nick.setText(Initial_Controller.Name_User);
    }

    @FXML
    public void goToCards(){
        try{
            Stage stage = (Stage) base.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/Views/Cards/Cards_View.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
        }
    }

    @FXML
    public void goToDecks(){
        try{
            Stage stage = (Stage) base.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/Views/Decks/Decks_View.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void createGame(){
        try{
            Stage stage = (Stage) base.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/Views/Game/Create_Game_View.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void joinGame(){
        try{
            Stage stage = (Stage) base.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/Views/Game/Join_Game_View.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void minimize(){
        Stage s = (Stage) base.getScene().getWindow();
        s.setIconified(true);
    }
    
    @FXML
    public void exit(){
        Stage s = (Stage) base.getScene().getWindow();
        System.exit(1);
    }
    
}
