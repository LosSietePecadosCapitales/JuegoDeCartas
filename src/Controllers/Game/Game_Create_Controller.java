/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Game;

import Controllers.Decks.Decks_Main_Controller;
import Controllers.Panels.Initial_Controller;
import Features.Connection.ConnectionMySQL;
import Features.Managements.Notifications;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
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
import javax.management.Notification;

/**
 *
 * @author LosSietePecadosCapitales
 */

/**
 * Clase que permite crear una partida
 * 
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
    
    public static Socket s;
    
    @FXML
    public void initialize(){
        
    }
    
    @FXML
    /**
     * muestra panel principal
     */
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
    /**
     * Se crea el juego
     */
    public void createGame(){
        String ip = getPublicIP();
        if (Decks_Main_Controller.deckFavorite==null) {
            Notifications.notification("Error", "Aun no seleccionas un mazo, favor ir a la ventana de mazo y seleccionar uno", 1);
        }
        else{
            if (!gameName.getText().equals("")) {
                /*
                ConnectionMySQL dataBase = new ConnectionMySQL();
                dataBase.ConectarBasedeDatos();
                PreparedStatement ps;
                ps = dataBase.connection.prepareStatement(""
                + "INSERT INTO Partida ()"
                + " VALUES (?,?,?,?);");
                ps.setString(1, ip);
                ps.setString(2, gameName.getText());
                ps.setString(3, gamePass.getText());
                ps.setString(4, Initial_Controller.Name_User);
                ps.execute();
                dataBase.DesconectarBasedeDatos();

                // AQUI DEBERÍA IR LA PARTE DEL SOCKET
                */
                try {
                    Stage stage = (Stage) base.getScene().getWindow();
                    Parent root = FXMLLoader.load(getClass().getResource("/Views/Game/Game_View_Server.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                Notifications.notification("Error", "Falta que agregues un nombre a la sala", 1);
            }
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
