package Controllers.Decks;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Decks_Create_Controller {
    
    @FXML public AnchorPane base;
    @FXML public ScrollPane eligible_Cards;
    @FXML public Label number_Label;
    @FXML public Label amount_Label;
    @FXML public Text slogan;
    @FXML public Button back;
    @FXML public Button save;

    @FXML
    public void initialize(){

    }

    @FXML
    public void back() {
        try {
            Stage stage = (Stage) base.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/Views/Decks/Decks_View.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
        }
    }
}
