/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Cards;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Cards_Edit_Controller {
    @FXML public AnchorPane base;
    @FXML public Button exit;
    @FXML public Button minimize;
    @FXML public Button back;
    @FXML public Button save;

    @FXML public Label name_Card_Label;
    @FXML public Label type_Card_Label;
    @FXML public Label description_Card_Label;
    @FXML public Label created_by_Card_Label;
    @FXML public Label atk_Card_Label;
    @FXML public Label def_Card_Label;

    @FXML public TextField name_Card_TF;
    @FXML public TextField type_Card_TF;
    @FXML public TextField atk_Card_TF;
    @FXML public TextField def_Card_TF;
    @FXML public TextArea description_Card_TA;

    @FXML public ComboBox element_Card_CB;

    @FXML public Spinner stars_Amounts_S;

    @FXML public ImageView star_1, star_2, star_3, star_4;
    @FXML public ImageView star_5, star_6, star_7, star_8;
    @FXML public ImageView star_9, star_10, star_11;
    @FXML public ImageView element_Icon;
    @FXML public ImageView image_Card;

    @FXML
    public void initialize(){

    }

    @FXML
    public void back() {
        try {
            Stage stage = (Stage) base.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/Views/Cards/Cards_View.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
        }
    }
    
    @FXML
    public void save(){
        String aux = "";
        aux = this.name_Card_TF.getText() + " " +this.stars_Amounts_S.getValue().toString() +
             " "+ this.type_Card_TF.getText() + " " + this.element_Card_CB.getValue().toString() +
                " "+ this.description_Card_TA.getText() + " "+this.atk_Card_TF.getText() +
                " "+ this.def_Card_TF.getText();
        //escribir sobre BD
    }
    
    public void insertCardCreated(){
    
    }
}
