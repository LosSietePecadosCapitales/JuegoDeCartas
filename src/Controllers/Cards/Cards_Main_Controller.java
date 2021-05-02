
package Controllers.Cards;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Cards_Main_Controller {
    
    @FXML public AnchorPane base;
    @FXML public Button back;
    @FXML public Button createCardButton;
    @FXML public Button editCardButton;
    @FXML public Button deleteCardButton;

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
    public void createCard(){
        try{
            Stage stage = (Stage) base.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/Views/Cards/Create_Card_View.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
        }
    }

    @FXML
    public void editCard(){
        try{
            Stage stage = (Stage) base.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/Views/Cards/Edit_Card_View.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
        }
    }

    @FXML
    public void deleteCard(){

    }
}
