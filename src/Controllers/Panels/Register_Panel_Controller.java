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
 * Clase Controlador del Panel de Registro
 * @author LosSietePecadosCapitales
 */
public class Register_Panel_Controller {
    
    //Declaraciones de variables
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
    
    /**
     * Metodo para Registrarse
     */
    @FXML
    public void register() {     
        Validations validator = new Validations();
        try {       
            String nick = this.nick.getText();
            String emailDirection = this.email.getText();        
            String pass = this.password.getText();    
            if (!validator.validateNick(nick)) {
                Notifications.notification("Problemas con el Nick", "Recuerda que el nick debe contener"
                        + " entre 8 y 16 caracteres, y alfanumérico.", 1);
                // Mensaje de Problema con Nick
                return;                
            } 
            if (!validator.validateEmail(emailDirection)) {
                Notifications.notification("Problemas con el Correo", "Recuerda que el correo debe contener"
                        + " un @ entre el nombre y el dominio, adicionalmente terminar en el codominio.", 1);
                // Mensaje de Problema con email
                return;                
            }          
            if (!validator.validatePassword(pass)) {
                Notifications.notification("Problemas con la contraseña", "Recuerda que la contraseña debe contener"
                        + " entre 6 y 10 caracteres, y como mínimo una mayúscula, una minúscula y un número.", 1);
                // Mensaje de Problema con pass
                return;                
            }
            if (!password.getText().equals(confirmpass.getText())) {
                Notifications.notification("Problemas con las contraseñas", "Las contraseñas no coinciden.", 1);
            }
            ConnectionMySQL dataBase = new ConnectionMySQL();
            String SQLsentence = "INSERT INTO Jugador (correo, nick, contrasenia) "
                    + "Values ('"+emailDirection+"' ,'"+nick+"' , '"+pass+"');";            
            dataBase.ConectarBasedeDatos();
            boolean ready = dataBase.sentence.execute(SQLsentence);
            dataBase.DesconectarBasedeDatos();
            Notifications.notification("Bienvenido "+nick, "Usuario Creado Exitosamente", 0);
            try {
                Stage stage = (Stage) base.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/Views/Panels/Initial_View.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Metodo para Regresar Atras 
     * Regresa al panel anterior (Panel Inicial)
     */
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
    
    /**
     * Metodo para Minimizar Ventana
     */
    @FXML
    public void minimize(){
        Stage s = (Stage) base.getScene().getWindow();
        s.setIconified(true);
    }
    
    /**
     * Metodo para Salir
     */
    @FXML
    public void exit(){        
        System.exit(1);
    }
    
    /**
     * Estilos Campo Email
     */
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
    /**
     * Estilos Campo Email
     */
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
    
    /**
     * Estilos Campo Nickname
     */
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
    
    /**
     * Estilos Campo Nickname
     */
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
    
    /**
     * Estilos Campo Contraseña
     */
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
    
    /**
     * Estilos Campo Contraseña
     */
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
    
    /**
     * Estilos Campo Confirmar Contraseña
     */
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
    
    /**
     * Estilos Campo Comfirmar Contraseña
     */
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
