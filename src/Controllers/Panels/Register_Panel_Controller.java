/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Panels;

import Features.Connection.ConnectionMySQL;
import Features.Managements.Notifications;
import Features.Managements.Validations;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Vicente
 */
public class Register_Panel_Controller {
    
    @FXML public AnchorPane base;
    @FXML public Label title;
    @FXML public Label alertMsg;
    @FXML public Button exit;
    @FXML public Button minimize;
    @FXML public Button back;
    @FXML public Text slogan;
    @FXML public TextField email;
    @FXML public TextField nick;
    @FXML public TextField password;
    @FXML public TextField confirmpass;
    @FXML public Button register;
    @FXML public Rectangle shape_Register_Button;
    @FXML public AnchorPane base_Button_Register;
    @FXML public AnchorPane alertBase;
    
    @FXML
    public void initialize(){
        
    }
        
    @FXML
    public void register() {     
        Validations validator = new Validations();
        try {       
            String nick = this.nick.getText();
            String emailDirection = this.email.getText();        
            String pass = this.password.getText();    
            if (!validator.validateNick(nick)) {
                // Mensaje de Problema con Nick
                return;                
            } 
            if (!validator.validateEmail(emailDirection)) {
                // Mensaje de Problema con email
                return;                
            }          
            if (!validator.validatePassword(pass)) {
                // Mensaje de Problema con pass
                return;                
            }          
            ConnectionMySQL dataBase = new ConnectionMySQL();
            String SQLsentence = "INSERT INTO Jugador (correo, nick, contrasenia) "
                    + "Values ('"+emailDirection+"' ,'"+nick+"' , '"+pass+"');";
            System.out.println(SQLsentence);
            dataBase.ConectarBasedeDatos();
            boolean ready = dataBase.sentence.execute(SQLsentence);
            dataBase.DesconectarBasedeDatos();
            Notifications.notification("Bienvenido "+nick, "Usuario Creado Exitosamente", 0);
            try {
                Stage stage = (Stage) base.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/Views/Panels/Initial_View.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException e) {
            }
        } catch (SQLException ex) {
            Logger.getLogger(Register_Panel_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void back() {
        try {
            Stage stage = (Stage) base.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/Views/Panels/Initial_View.fxml"));
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
    public void inEmailField(){
        email.setStyle("-fx-background-image: url('../Images/Buttons/Button_4_Hit.png');\n" +
                    "    -fx-background-repeat: no-repeat;\n" +
                    "    -fx-background-size: cover, auto;\n" +
                    "    -fx-background-color: transparent;\n" +
                    "    -fx-background-radius: 0px;    \n" +
                    "    -fx-prompt-text-fill: rgba(15,15,15,0.7);\n" +
                    "    -fx-text-fill: rgba(20,20,20,0.85);");
    }
    
    @FXML
    public void outEmailField(){
        if (email.getText().equals("")) {
            email.setStyle("-fx-background-image: url('../Images/Buttons/Button_4.png');\n" +
                    "    -fx-background-repeat: no-repeat;\n" +
                    "    -fx-background-size: cover, auto;\n" +
                    "    -fx-background-color: transparent;\n" +
                    "    -fx-background-radius: 0px;\n" +
                    "    -fx-prompt-text-fill: rgba(15,15,15,0.7);\n" +
                    "    -fx-text-fill: rgba(20,20,20,0.85);");
        }
    }
    
    @FXML
    public void inNickField(){
        nick.setStyle("-fx-background-image: url('../Images/Buttons/Button_4_Hit.png');\n" +
                    "    -fx-background-repeat: no-repeat;\n" +
                    "    -fx-background-size: cover, auto;\n" +
                    "    -fx-background-color: transparent;\n" +
                    "    -fx-background-radius: 0px;    \n" +
                    "    -fx-prompt-text-fill: rgba(15,15,15,0.7);\n" +
                    "    -fx-text-fill: rgba(20,20,20,0.85);");
    }
    
    @FXML
    public void outNickField(){
        if (nick.getText().equals("")) {
            nick.setStyle("-fx-background-image: url('../Images/Buttons/Button_4.png');\n" +
                    "    -fx-background-repeat: no-repeat;\n" +
                    "    -fx-background-size: cover, auto;\n" +
                    "    -fx-background-color: transparent;\n" +
                    "    -fx-background-radius: 0px;\n" +
                    "    -fx-prompt-text-fill: rgba(15,15,15,0.7);\n" +
                    "    -fx-text-fill: rgba(20,20,20,0.85);");
        }
    }
    
    @FXML
    public void inPassField(){
        password.setStyle("-fx-background-image: url('../Images/Buttons/Button_4_Hit.png');\n" +
                    "    -fx-background-repeat: no-repeat;\n" +
                    "    -fx-background-size: cover, auto;\n" +
                    "    -fx-background-color: transparent;\n" +
                    "    -fx-background-radius: 0px;    \n" +
                    "    -fx-prompt-text-fill: rgba(15,15,15,0.7);\n" +
                    "    -fx-text-fill: rgba(20,20,20,0.85);");
    }
    
    @FXML
    public void outPassField(){
        if (password.getText().equals("")) {
            password.setStyle("-fx-background-image: url('../Images/Buttons/Button_4.png');\n" +
                    "    -fx-background-repeat: no-repeat;\n" +
                    "    -fx-background-size: cover, auto;\n" +
                    "    -fx-background-color: transparent;\n" +
                    "    -fx-background-radius: 0px;\n" +
                    "    -fx-prompt-text-fill: rgba(15,15,15,0.7);\n" +
                    "    -fx-text-fill: rgba(20,20,20,0.85);");
        }
    }
    
    @FXML
    public void inConfField(){
        confirmpass.setStyle("-fx-background-image: url('../Images/Buttons/Button_4_Hit.png');\n" +
                    "    -fx-background-repeat: no-repeat;\n" +
                    "    -fx-background-size: cover, auto;\n" +
                    "    -fx-background-color: transparent;\n" +
                    "    -fx-background-radius: 0px;    \n" +
                    "    -fx-prompt-text-fill: rgba(15,15,15,0.7);\n" +
                    "    -fx-text-fill: rgba(20,20,20,0.85);");
    }
    
    @FXML
    public void outConfField(){
        if (confirmpass.getText().equals("")) {
            confirmpass.setStyle("-fx-background-image: url('../Images/Buttons/Button_4.png');\n" +
                    "    -fx-background-repeat: no-repeat;\n" +
                    "    -fx-background-size: cover, auto;\n" +
                    "    -fx-background-color: transparent;\n" +
                    "    -fx-background-radius: 0px;\n" +
                    "    -fx-prompt-text-fill: rgba(15,15,15,0.7);\n" +
                    "    -fx-text-fill: rgba(20,20,20,0.85);");
        }
    }
}
