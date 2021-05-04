package Controllers.Cards;

import Controllers.Panels.Initial_Controller;
import Features.Connection.ConnectionMySQL;
import java.awt.image.RenderedImage;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

public class Cards_Create_Controller {
    
    @FXML public AnchorPane base;
    @FXML public AnchorPane card_complete;
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
    
    @FXML
    public void initialize(){
        created_by_Card_Label.setText(created_by_Card_Label.getText()+" "+Initial_Controller.Name_User);
        Font font = Font.loadFont(Cards_Create_Controller.class.getResource("/Assets/Fonts/matrixb.ttf").toExternalForm(), 14);
        Font font2 = Font.loadFont(Cards_Create_Controller.class.getResource("/Assets/Fonts/matrixr.ttf").toExternalForm(), 16);
        name_Card_Label.setFont(font2);
        type_Card_Label.setFont(font);
        description_Card_Label.setFont(font);
        
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
    public void insertCardCreated(){
        try {
            Image image_card_complete = card_complete.snapshot(new SnapshotParameters(), null);
            File f2 = new File("temp.png");
            RenderedImage ri = SwingFXUtils.fromFXImage(image_card_complete, null);
            ImageIO.write(ri, "png", f2);            
            File f = new File("temp.png");
            FileInputStream fis = new FileInputStream(f);         
            ConnectionMySQL dataBase = new ConnectionMySQL();      
            dataBase.ConectarBasedeDatos();
            PreparedStatement s;
            s = dataBase.connection.prepareStatement(""
                    + "INSERT INTO Carta (nombre, elemento, ataque, defensa, estrellas, imagen, tipo, descripcion, ref_Jugador)"
                    + " VALUES (?,?,?,?,?,?,?,?,?);");
            s.setString(1, name_Card_TF.getText());
            s.setString(2, String.valueOf(element_Card_CB.getValue()));
            s.setInt(3, Integer.valueOf(atk_Card_TF.getText()));
            s.setInt(4, Integer.valueOf(def_Card_TF.getText()));
            s.setInt(5, Integer.valueOf(String.valueOf(stars_Amounts_S.getValue())));
            s.setBlob(6, fis);
            s.setString(7, String.valueOf(type_Card_TF.getValue()));
            s.setString(8, description_Card_TA.getText());
            s.setInt(9, Initial_Controller.ID_User);
            s.execute();
            f.delete(); /*SEE deleteOnExit();*/
            dataBase.DesconectarBasedeDatos();
        }
        catch (FileNotFoundException | NumberFormatException | SQLException e) { System.out.println(e.getMessage());}
        catch (IOException ex) {System.out.println(ex.getMessage());}
    }

    @FXML
    public void uploadImage(){
        try {
            FileChooser fc = new FileChooser();
            File file = fc.showOpenDialog(base.getScene().getWindow());
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