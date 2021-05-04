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
import javafx.concurrent.Task;
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

import java.io.IOException;
import java.sql.SQLException;

public class Initial_Controller {
    @FXML public AnchorPane base;
    @FXML public Label title;
    @FXML public Button exit;
    @FXML public Button minimize;
    @FXML public Text slogan;
    @FXML public TextField user_TextField;
    @FXML public TextField pass_TextField;
    @FXML public Button login;
    @FXML public Text register;
    @FXML public Rectangle shape_Register_Button;

    private Thread thread_Register;
    public static int ID_User;

    @FXML
    public void initialize(){
        new AppControler();

    }

    @FXML
    private void login(){
        try {
            ConnectionMySQL dataBase = new ConnectionMySQL();
            String user = user_TextField.getText();
            String pass = pass_TextField.getText();         
            String SQLsentence = "SELECT correo, nick, contrasenia "
                    + "FROM Jugador WHERE (correo='"+user+"' or nick='"+user+"') and contrasenia='"+pass+"';";
            dataBase.ConectarBasedeDatos();
            dataBase.result = dataBase.sentence.executeQuery(SQLsentence);            
                if(dataBase.result.next()){
                    Notifications.notification("Bienvenido "+user,"Estadisticas del dia",9);
                    try{
                        dataBase.DesconectarBasedeDatos();
                        trayIcon.setToolTip(user+"-LogOut");
                        Stage stage = (Stage) base.getScene().getWindow();
                        Parent root = FXMLLoader.load(getClass().getResource("/Views/Panels/Principal_Panel_View.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);                        
                    } catch (IOException e) {
                        //Saltar alarma que no se puede iniciar sesion
                    }
                }else{
                    
                }                          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("No Funciono");
        }
    }

    @FXML
    public void register() {
        /*
         * Aqui va la query para la db para registrar
         */

        System.out.println("registrado");

        try{
            Stage stage = (Stage) base.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/Views/Panels/Register_Panel_View.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void shape_In_Login(){
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() {
                try {
                    for (double i = shape_Register_Button.getWidth(); i <= 150; i = i + 1) {
                        Thread.sleep(1);
                        shape_Register_Button.setWidth(i);
                    }
                } catch (InterruptedException e) {
                }
                return null;
            }
        };

        try{
            thread_Register.stop();
        } catch (Exception e) {
        }
        Thread thread = new Thread(task);
        thread_Register = thread;
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    public void shape_Out_Login(){
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() {
                try {
                    for (double i = shape_Register_Button.getWidth(); i > 0; i = i - 1) {
                        Thread.sleep(1);
                        shape_Register_Button.setWidth(i);
                    }
                } catch (InterruptedException e) {
                }
                return null;
            }
        };

        try{
            thread_Register.stop();
        } catch (Exception e) {
        }

        Thread thread = new Thread(task);
        thread_Register = thread;
        thread.setDaemon(true);
        thread.start();
    }
}
