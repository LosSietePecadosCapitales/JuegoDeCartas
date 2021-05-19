/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Game;

import Features.Connection.ConnectionMySQL;
import Features.Objects.Game;
import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Vicente
 */
public class Game_Join_Controller {
    
    @FXML public AnchorPane base;
    @FXML public TableView games;
    @FXML public TableColumn<Game, String> gameName;
    @FXML public TableColumn<Game, String> gameOwner;
    @FXML public TableColumn<Game, String> gamePass;
    @FXML public Label title;
    @FXML public Button exit;
    @FXML public Button refresh;
    @FXML public Button minimize;
    @FXML public Button back;
    @FXML public Button join;
    @FXML public Text slogan;  
    
    private String check = "✓";
    private String uncheck = "✗";
    
    public static String socketIP;
    
    @FXML
    public void initialize(){
        initializeTableView();
        refreshGames();
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
    public void refreshGames(){
        games.getItems().clear();
        try {
            ConnectionMySQL con = new ConnectionMySQL();
            con.ConectarBasedeDatos();
            String query = "SELECT * FROM Partida";
            con.result = con.sentence.executeQuery(query);
            ObservableList<Game> gamesList = FXCollections.observableArrayList();            
            while (con.result.next()) {
                Game g = new Game(con.result.getString(1), con.result.getString(2),con.result.getString(3), "", con.result.getString(4));
                if (g.getPass().equals("")) {
                    g.setHasPass(check);
                }
                else{
                    g.setHasPass(uncheck);
                }
                games.getItems().add(g);
            }
            con.DesconectarBasedeDatos();
        } catch (SQLException e) {
        }
    }
    
    @FXML
    public void joinGame(){
        
        try {
            Stage stage = (Stage) base.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/Views/Game/Game_View_Client.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void initializeTableView(){        
        gameName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        gameOwner.setCellValueFactory(new PropertyValueFactory<>("Owner"));
        gamePass.setCellValueFactory(new PropertyValueFactory<>("HasPass"));
    }
}