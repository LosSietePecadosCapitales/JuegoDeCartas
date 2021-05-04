package Controllers.Cards;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

public class Cards_Create_Controller {
    
    @FXML public AnchorPane base;
    @FXML public Button exit;
    @FXML public Button minimize;
    @FXML public Button back;
    @FXML public Button save;
    @FXML public Button uploadImg;

    @FXML public Label name_Card_Label;
    @FXML public Label type_Card_Label;
    @FXML public Label description_Card_Label;
    @FXML public Label created_by_Card_Label;
    @FXML public Label atk_Card_Label;
    @FXML public Label def_Card_Label;

    @FXML public TextField name_Card_TF;
    @FXML public TextField atk_Card_TF;
    @FXML public TextField def_Card_TF;
    @FXML public TextArea description_Card_TA;

    @FXML public ComboBox element_Card_CB;
    @FXML public ComboBox type_Card_TF;
    @FXML public ComboBox stars_Amounts_S;

    @FXML public ImageView star_1, star_2, star_3, star_4;
    @FXML public ImageView star_5, star_6, star_7, star_8;
    @FXML public ImageView star_9, star_10, star_11;
    @FXML public ImageView element_Icon;
    @FXML public ImageView image_Card;
    @FXML public AnchorPane card_complete;

    
    
    
    /* TEMPORALES*/
    private final String url_bd = "jdbc:mysql://186.64.121.26:3306/yugioh";
    private final String userBD ="yugioh";
    private final String passBD ="Y5g34H";
    private PreparedStatement s;
    private File file;
    /**/
    
    @FXML
    public void initialize(){
        file = null;
        s = null;
        //Estrellas
        //Atributos combo box (Cantidad de estrellas)
        stars_Amounts_S.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");
        stars_Amounts_S.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String s, String s2) {
                String auxString = "";
                auxString = stars_Amounts_S.getSelectionModel().getSelectedItem().toString();
                
                if(auxString.equals("1")){
                    star_1.setVisible(true);
                    star_2.setVisible(false);
                    star_3.setVisible(false);
                    star_4.setVisible(false);
                    star_5.setVisible(false);
                    star_6.setVisible(false);
                    star_7.setVisible(false);
                    star_8.setVisible(false);
                    star_9.setVisible(false);
                    star_10.setVisible(false);
                    star_11.setVisible(false);
                }
                else if(auxString.equals("2")){
                    star_1.setVisible(true);
                    star_2.setVisible(true);
                    star_3.setVisible(false);
                    star_4.setVisible(false);
                    star_5.setVisible(false);
                    star_6.setVisible(false);
                    star_7.setVisible(false);
                    star_8.setVisible(false);
                    star_9.setVisible(false);
                    star_10.setVisible(false);
                    star_11.setVisible(false);
                }
                else if(auxString.equals("3")){
                    star_1.setVisible(true);
                    star_2.setVisible(true);
                    star_3.setVisible(true);
                    star_4.setVisible(false);
                    star_5.setVisible(false);
                    star_6.setVisible(false);
                    star_7.setVisible(false);
                    star_8.setVisible(false);
                    star_9.setVisible(false);
                    star_10.setVisible(false);
                    star_11.setVisible(false);
                }
                else if(auxString.equals("4")){
                    star_1.setVisible(true);
                    star_2.setVisible(true);
                    star_3.setVisible(true);
                    star_4.setVisible(true);
                    star_5.setVisible(false);
                    star_6.setVisible(false);
                    star_7.setVisible(false);
                    star_8.setVisible(false);
                    star_9.setVisible(false);
                    star_10.setVisible(false);
                    star_11.setVisible(false);
                }
                else if(auxString.equals("5")){
                    star_1.setVisible(true);
                    star_2.setVisible(true);
                    star_3.setVisible(true);
                    star_4.setVisible(true);
                    star_5.setVisible(true);
                    star_6.setVisible(false);
                    star_7.setVisible(false);
                    star_8.setVisible(false);
                    star_9.setVisible(false);
                    star_10.setVisible(false);
                    star_11.setVisible(false);
                }
                else if(auxString.equals("6")){
                    star_1.setVisible(true);
                    star_2.setVisible(true);
                    star_3.setVisible(true);
                    star_4.setVisible(true);
                    star_5.setVisible(true);
                    star_6.setVisible(true);
                    star_7.setVisible(false);
                    star_8.setVisible(false);
                    star_9.setVisible(false);
                    star_10.setVisible(false);
                    star_11.setVisible(false);
                }
                else if(auxString.equals("7")){
                    star_1.setVisible(true);
                    star_2.setVisible(true);
                    star_3.setVisible(true);
                    star_4.setVisible(true);
                    star_5.setVisible(true);
                    star_6.setVisible(true);
                    star_7.setVisible(true);
                    star_8.setVisible(false);
                    star_9.setVisible(false);
                    star_10.setVisible(false);
                    star_11.setVisible(false);
                }
                else if(auxString.equals("8")){
                    star_1.setVisible(true);
                    star_2.setVisible(true);
                    star_3.setVisible(true);
                    star_4.setVisible(true);
                    star_5.setVisible(true);
                    star_6.setVisible(true);
                    star_7.setVisible(true);
                    star_8.setVisible(true);
                    star_9.setVisible(false);
                    star_10.setVisible(false);
                    star_11.setVisible(false);
                }
                else if(auxString.equals("9")){
                    star_1.setVisible(true);
                    star_2.setVisible(true);
                    star_3.setVisible(true);
                    star_4.setVisible(true);
                    star_5.setVisible(true);
                    star_6.setVisible(true);
                    star_7.setVisible(true);
                    star_8.setVisible(true);
                    star_9.setVisible(true);
                    star_10.setVisible(false);
                    star_11.setVisible(false);
                }
                else if(auxString.equals("10")){
                    star_1.setVisible(true);
                    star_2.setVisible(true);
                    star_3.setVisible(true);
                    star_4.setVisible(true);
                    star_5.setVisible(true);
                    star_6.setVisible(true);
                    star_7.setVisible(true);
                    star_8.setVisible(true);
                    star_9.setVisible(true);
                    star_10.setVisible(true);
                    star_11.setVisible(false);
                    
                }
                else if(auxString.equals("11")){
                    star_1.setVisible(true);
                    star_2.setVisible(true);
                    star_3.setVisible(true);
                    star_4.setVisible(true);
                    star_5.setVisible(true);
                    star_6.setVisible(true);
                    star_7.setVisible(true);
                    star_8.setVisible(true);
                    star_9.setVisible(true);
                    star_10.setVisible(true);
                    star_11.setVisible(true);
                }
            }
        });
        
        //Cambio del nombre de la carta (dinamico)
        name_Card_TF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                String auxString = "";
                auxString = name_Card_TF.getText();
                name_Card_Label.setText(auxString);
            }
        });
        //Cambio de la descripción de la carta (dinamico)
        description_Card_TA.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                String auxString = "";
                auxString = description_Card_TA.getText();
                description_Card_Label.setText(auxString);
            }
        });
        //Atributos combo box (elemento)
        element_Card_CB.getItems().addAll("AGUA", "FUEGO", "LUZ", "OSCURIDAD", "TIERRA", "VIENTO", "DIVINO");
        //Cambio del elemento de carta (dinamico)
        element_Card_CB.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String s, String s2) {
                String auxString = "";
                auxString = element_Card_CB.getSelectionModel().getSelectedItem().toString();
                if(auxString.equals("AGUA")){
                    element_Icon.setImage(new ImageView("Assets/Images/Elements/WATER.png").getImage());
                }
                else if(auxString.equals("FUEGO")){
                    element_Icon.setImage(new ImageView("Assets/Images/Elements/FIRE.png").getImage());
                }
                if(auxString.equals("LUZ")){
                    element_Icon.setImage(new ImageView("Assets/Images/Elements/LIGHT.png").getImage());
                }
                if(auxString.equals("OSCURIDAD")){
                    element_Icon.setImage(new ImageView("Assets/Images/Elements/DARK.png").getImage());
                }
                if(auxString.equals("TIERRA")){
                    element_Icon.setImage(new ImageView("Assets/Images/Elements/EARTH.png").getImage());
                }
                if(auxString.equals("VIENTO")){
                    element_Icon.setImage(new ImageView("Assets/Images/Elements/WIND.png").getImage());
                }
                if(auxString.equals("DIVINO")){
                    element_Icon.setImage(new ImageView("Assets/Images/Elements/DIVINE.png").getImage());
                }
            }
        });
        //Atributos combo box (Tipo)
        type_Card_TF.getItems().addAll("Aqua", "Bestia", "Demonio", "Dinosaurio", "Dragon", "Guerrero",
                "Guerrero-Bestia", "Hada", "Insecto", "Landor de conjuros", "Maquina", "Pez", "Planta",
                "Psiquico", "Piro", "Reptil", "Roca", "Serpiente marina", "Trueno", "Zombi");
        //Cambio del tipo de carta (dinamico)
        type_Card_TF.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String s, String s2) {
                String auxString = "";
                auxString = "[ "+type_Card_TF.getSelectionModel().getSelectedItem().toString()+" ]";
                type_Card_Label.setText(auxString);
            }
        });
        //Cambio del ataque (dinamico)
        atk_Card_TF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                String auxString = "";
                auxString = atk_Card_TF.getText();
                atk_Card_Label.setText(auxString);
            }
        });
        //Cambio de la defensa (dinamico)
        def_Card_TF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                String auxString = "";
                auxString = def_Card_TF.getText();
                def_Card_Label.setText(auxString);
            }
        });
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
         " "+ this.type_Card_TF.getValue().toString() + " " + this.element_Card_CB.getValue().toString() +
            " "+ this.description_Card_TA.getText() + " "+this.atk_Card_TF.getText() +
            " "+ this.def_Card_TF.getText();
    }
    
    @FXML
    public void uploadImage(){
        try {
            FileChooser fc = new FileChooser();
            file = fc.showOpenDialog(base.getScene().getWindow());
            FileInputStream fis = new FileInputStream(file);
            Image image = new Image(fis);
            image_Card.setImage(image);
        } catch (FileNotFoundException e) {
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
