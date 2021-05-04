/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Panels;


import Features.Connection.ConnectionMySQL;
import Features.Managements.AppControler;
import static Features.Managements.AppControler.trayIcon;
import Features.Managements.Notifications;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import javafx.concurrent.Task;


public class Initial_Controller {
    
    @FXML public AnchorPane base;
    @FXML public AnchorPane alertBase;
    
    @FXML public Button exit;
    @FXML public Button minimize;
    @FXML public Button login;
    @FXML public Button register;
    
    @FXML public Text slogan;
    @FXML public Label title;
    @FXML public Label alertMsg;
    
    @FXML public TextField user_TextField;
    @FXML public PasswordField pass_TextField;
        
    
    public static int ID_User;

    @FXML
    public void initialize(){
        new AppControler();
    }

    @FXML
    public void login(){
        if (internetStatus()) {
            try {
                ConnectionMySQL dataBase = new ConnectionMySQL();
                String user = user_TextField.getText();
                String pass = pass_TextField.getText();
                String SQLsentence = "SELECT id, correo, nick, contrasenia "
                        + "FROM Jugador WHERE (correo='"+user+"' or nick='"+user+"') and contrasenia='"+pass+"';";
                dataBase.ConectarBasedeDatos();
                dataBase.result = dataBase.sentence.executeQuery(SQLsentence);       
                    if(dataBase.result.next()){
                        ID_User = dataBase.result.getInt(1);
                        Notifications.notification("Bienvenido "+user,"Estadisticas del dia",9);
                        try{
                            dataBase.DesconectarBasedeDatos();
                            trayIcon.setToolTip(user+"-LogOut");
                            Stage stage = (Stage) base.getScene().getWindow();
                            Parent root = FXMLLoader.load(getClass().getResource("/Views/Panels/Principal_Panel_View.fxml"));
                            Scene scene = new Scene(root);
                            stage.setScene(scene);                        
                        } catch (IOException e) {
                            e.printStackTrace();
                            alertMsg.setText("Usuario o Contraseña Invalidos");
                            showAlert();
                        }
                    }else{
                        alertMsg.setText("Usuario o Contraseña Invalidos");
                        showAlert();
                    }                          
            } catch (SQLException ex) {
                alertMsg.setText("Verifica tu conexion a internet");
                showAlert();
                System.out.println(ex.getMessage());
                System.out.println("No Funciono");
            }
        }
        else{
            alertMsg.setText("Verifica tu conexion a internet");
            showAlert();
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
    public void register() {
        try{
            Stage stage = (Stage) base.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/Views/Panels/Register_Panel_View.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showAlert(){
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() {
                try {
                    for (double i = 0.0; i < 1.0; i = i + 0.01) {
                        Thread.sleep(10);
                        alertBase.setOpacity(i);
                    }
                    Thread.sleep(5000);
                    for (double i = 1.0; i > 0.0; i = i - 0.01) {
                        Thread.sleep(10);
                        alertBase.setOpacity(i);
                    }
                } catch (InterruptedException e) {
                }
                return null;
            }
        };

        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }
    
    private boolean internetStatus(){
        try {
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            return true;
        } catch (MalformedURLException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }
}
