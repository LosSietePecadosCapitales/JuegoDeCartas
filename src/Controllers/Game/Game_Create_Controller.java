/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Game;

import Controllers.Panels.Initial_Controller;
import Features.Connection.ConnectionMySQL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

/**
 *
 * @author Vicente
 */
public class Game_Create_Controller {
    
    @FXML public AnchorPane base;        
    @FXML public Label title;
    @FXML public Button exit;
    @FXML public Button minimize;
    @FXML public Button back;
    @FXML public Button join;
    @FXML public Text slogan;
    @FXML public TextField gameName;
    @FXML public TextField gamePass;
    
    @FXML
    public void initialize(){
        
    }
    
    @FXML
    public void back() {
        try {
            Stage stage = (Stage) base.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/Views/Panels/Principal_Panel_View.fxml"));
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
    public void createGame(){
        String ip = getPublicIP();
        if (!gameName.getText().equals("")) {
            try {
                ConnectionMySQL dataBase = new ConnectionMySQL();      
                dataBase.ConectarBasedeDatos();
                PreparedStatement s;
                s = dataBase.connection.prepareStatement(""
                        + "INSERT INTO Partida ()"
                        + " VALUES (?,?,?,?);");
                s.setString(1, ip);
                s.setString(2, gameName.getText());
                s.setString(3, gamePass.getText());
                s.setString(4, Initial_Controller.Name_User);
                s.execute();
                dataBase.DesconectarBasedeDatos();
            } catch (SQLException e) {
                // Notifiacion que no pueden haber dos partidas
                // con el mismo nombre
            }
        }
        else{
            // Notificacion que falta info
        }
    }
    
    private String getPublicIP(){
        String ipString = "";
        try {
            URL ip = new URL("https://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(ip.openStream())); 
            ipString = in.readLine();
        } catch (MalformedURLException ex) {            
        } catch (IOException ex) {
        }
        return ipString;
    }
}
