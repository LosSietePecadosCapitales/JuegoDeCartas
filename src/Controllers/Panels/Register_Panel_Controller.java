/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Panels;

import java.io.IOException;
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

/**
 *
 * @author Vicente
 */
public class Register_Panel_Controller {
    
    @FXML public AnchorPane base;
    @FXML public Label title;
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

    private Thread thread_Register;
    
    @FXML
    public void initialize(){

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
    public void register() {
        /*
        * AQUI VA LA QUERY PARA LA DB
        */
        
        try {
            Stage stage = (Stage) base.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/Views/Panels/Initial_View.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
        }
    }
    
    @FXML
    public void shape_In_Register(){
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
    public void shape_Out_Register(){
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
