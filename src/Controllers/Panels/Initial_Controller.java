/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Panels;


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
import javafx.stage.Window;

import java.io.IOException;

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

    @FXML
    public void initialize(){

    }

    @FXML
    public void login(){
        if(user_TextField.getText().equals("mono") &&
           pass_TextField.getText().equals("mono")){
            try{
                Stage stage = (Stage) base.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/Views/Panels/Principal_Panel_View.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);

            } catch (IOException e) {
                //Saltar alarma que no se puede iniciar sesion
            }
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
